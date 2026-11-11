"""Download a bounded list of public recipe pages and extract their JSON-LD."""
import argparse
import hashlib
import json
from html.parser import HTMLParser
from pathlib import Path
import subprocess
import time


class Page(HTMLParser):
    def __init__(self):
        super().__init__()
        self.in_json = False
        self.buffer = []
        self.recipes = []

    def handle_starttag(self, tag, attrs):
        if tag == "script" and dict(attrs).get("type") == "application/ld+json":
            self.in_json = True
            self.buffer = []

    def handle_data(self, data):
        if self.in_json:
            self.buffer.append(data)

    def handle_endtag(self, tag):
        if tag == "script" and self.in_json:
            self.in_json = False
            obj = json.loads("".join(self.buffer))
            nodes = obj if isinstance(obj, list) else obj.get("@graph", [obj])
            self.recipes.extend(x for x in nodes if x.get("@type") == "Recipe")


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("slugs", nargs="+")
    parser.add_argument("--cache", default="/tmp/practice-fitness-recipe-sources")
    args = parser.parse_args()
    root = Path(args.cache)
    root.mkdir(parents=True, exist_ok=True)
    for slug in args.slugs:
        url = f"https://medlineplus.gov/recipes/{slug}/"
        target = root / f"{slug}.html"
        if not target.exists():
            result = subprocess.run([
                "curl", "-fsSL", "--connect-timeout", "15", "--max-time", "50",
                "--retry", "1", url, "-o", str(target)
            ], capture_output=True, text=True)
            if result.returncode:
                print(slug, "DOWNLOAD FAILED", result.stderr, flush=True)
                continue
            time.sleep(0.3)
        page = Page()
        page.feed(target.read_text())
        if len(page.recipes) != 1:
            print(slug, "NO UNIQUE RECIPE", flush=True)
            continue
        data = {"sourceUrl": url, "pageSha256": hashlib.sha256(target.read_bytes()).hexdigest(),
                "recipe": page.recipes[0]}
        (root / f"{slug}.json").write_text(json.dumps(data, ensure_ascii=False, indent=2) + "\n")
        r = data["recipe"]
        print(slug, r.get("totalTime"), r.get("recipeYield"), r.get("nutrition"), flush=True)


if __name__ == "__main__":
    main()
