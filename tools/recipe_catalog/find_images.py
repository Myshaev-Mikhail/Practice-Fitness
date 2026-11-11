"""Find explicitly licensed Commons photos; metadata is retained for review."""
import json
from pathlib import Path
import subprocess
import sys
import time
from urllib.parse import urlencode


def request(url):
    result = subprocess.run(["curl", "-fsSL", "--retry", "2", "--retry-all-errors", "--connect-timeout", "10", "--max-time", "30",
                             "-A", "PracticeFitnessRecipeCatalog/1.0", url], capture_output=True, check=True)
    return json.loads(result.stdout)


if __name__ == "__main__":
    root = Path("/tmp/practice-fitness-recipe-images")
    root.mkdir(exist_ok=True)
    for term in sys.argv[1:]:
        path = root / (term.replace(" ", "_") + ".json")
        if not path.exists():
            selection = {"titles": term} if term.startswith("File:") else {
                "generator": "search", "gsrsearch": term + " filetype:bitmap", "gsrnamespace": 6, "gsrlimit": 4,
            }
            url = "https://commons.wikimedia.org/w/api.php?" + urlencode({
                "action": "query", **selection, "prop": "imageinfo", "iiprop": "url|extmetadata|size|sha1",
                "iiurlwidth": 640, "format": "json"
            })
            path.write_text(json.dumps(request(url), ensure_ascii=False, indent=2) + "\n")
            time.sleep(0.4)
        data = json.loads(path.read_text())
        print(term, flush=True)
        for p in sorted(data.get("query", {}).get("pages", {}).values(), key=lambda x:x.get("index", 0)):
            ii = p["imageinfo"][0]
            m = ii["extmetadata"]
            print(p["title"], m.get("LicenseShortName", {}).get("value"),
                  m.get("Artist", {}).get("value"), flush=True)
