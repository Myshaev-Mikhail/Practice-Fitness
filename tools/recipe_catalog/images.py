"""Download explicitly selected Commons images and retain per-file rights evidence."""
import hashlib
import json
from pathlib import Path
import subprocess
import time

from review_sources import Document

ROOT = Path(__file__).resolve().parents[2]
ASSETS = ROOT / "app/src/main/assets/recipe_catalog"
EVIDENCE = ROOT / "docs/recipe_catalog"
CACHE = Path("/tmp/practice-fitness-recipe-images")

SELECTED = {
    "veggie-omelet-in-a-mug": "File:2750Onion Cheese Omelette Sliced cheese 07.jpg",
    "blueberry-tofu-smoothie": "File:Blueberry smoothie.jpg",
    "oatmeal-pecan-waffles-or-pancakes": "File:Berries on heart waffles (Unsplash).jpg",
    "overnight-oats-for-one": "File:Protein overnight oats.jpg",
    "baked-berry-oatmeal": "File:Baked oatmeal.JPG",
    "tofu-scramble": "File:Tofu Scramble in New Orleans.jpg",
    "green-pineapple-power-smoothie": "File:Green smoothie (8222465502).jpg",
    "oven-baked-salmon": "File:Baked Salmon - Lavash 2024-06-24.jpg",
    "skillet-braised-chicken": "File:Grilled chicken 2.jpg",
    "vegetarian-cowboy-salad": "File:Texas caviar.jpg",
    "black-bean-soup": "File:Black bean soup (3370127734).jpg",
    "kale-and-white-bean-soup": "File:Collard Greens and White Bean Soup.jpg",
    "vegetarian-chili": "File:Two-Bean Vegetarian Chili.jpg",
    "pasta-caprese": "File:Raw tomato pasta (5224493642).jpg",
    "salmon-pasta-skillet": "File:Smoked salmon pasta - Figaros, Brighton 2024-04-19.jpg",
    "chicken-and-rice": "File:Hainanese chicken rice at Thai Ten.jpg",
    "baked-tilapia-with-tomatoes": "File:Liat Portal for Foodie Disorder - Raw Tilapia Prepared for Baking.jpg",
    "hummus-with-tahini": "File:Homemade hummus and pita 03.jpg",
    "quick-black-bean-dip": "File:Black bean dip.jpg",
    "peanut-power-smoothie": "File:Fruit and peanut butter smoothie.jpg",
    "melon-and-mint": "File:Melon and Citullu.jpg",
    "banana-oatmeal-cookies": "File:Vegan Oatmeal Cookies (4597797170).jpg",
    "perfect-hard-cooked-eggs": "File:Arrautza egosiak.jpg",
    "baked-tomatoes-with-cheese": "File:Baked Parmesan Tomatoes04.jpg",
    "chicken-and-black-bean-salsa-burritos": "File:Grilled Chicken Burrito.jpg",
    "cheesy-beef-pasta": "File:Diavola - August 2022 - Sarah Stierch 03.jpg",
    "indian-lentils-and-pasta": "File:Paella - Pastan, Brighton 2024-01-24.jpg",
}


def main():
    evidence_file = EVIDENCE / "image-source-metadata.json"
    existing = json.loads(evidence_file.read_text()) if evidence_file.exists() else {}
    found = {p["title"]: p for p in existing.values()}
    for path in sorted(CACHE.glob("*.json")):
        for page in json.loads(path.read_text()).get("query", {}).get("pages", {}).values():
            found[page["title"]] = page
    pages = {slug: found[title] for slug, title in SELECTED.items()}
    EVIDENCE.mkdir(parents=True, exist_ok=True)
    evidence_file.write_text(json.dumps(pages, ensure_ascii=False, indent=2) + "\n")
    credits_file = ASSETS / "image_credits.json"
    old_credits = {c["recipeId"]: c for c in json.loads(credits_file.read_text())} if credits_file.exists() else {}

    images = []
    for slug, page in pages.items():
        info = page["imageinfo"][0]
        meta = info["extmetadata"]

        def value(key):
            return Document(str(meta.get(key, {}).get("value", ""))).root.text()

        license_name = value("LicenseShortName")
        assert license_name == "CC0" or license_name.startswith(("CC BY ", "CC BY-SA ")), (slug, license_name)
        assert value("Restrictions") == "", (slug, value("Restrictions"))
        assert value("Artist") and value("LicenseUrl"), slug
        target = ASSETS / "images" / f"{slug}.jpg"
        target.parent.mkdir(parents=True, exist_ok=True)
        download_url = info.get("thumburl", info["url"])
        if not target.exists() or old_credits.get(slug, {}).get("title") != page["title"]:
            temporary = target.with_suffix(".download")
            result = subprocess.run([
                "curl", "-fsSL", "--retry", "2", "--retry-all-errors", "--connect-timeout", "10",
                "--max-time", "45", "-A", "PracticeFitnessRecipeCatalog/1.0",
                download_url, "-o", str(temporary),
            ], capture_output=True)
            if result.returncode:
                raise RuntimeError(f"{slug}: {result.stderr.decode()}")
            assert temporary.read_bytes().startswith(b"\xff\xd8\xff"), f"Not JPEG: {slug}"
            temporary.replace(target)
            time.sleep(0.3)
        data = target.read_bytes()
        images.append({
            "recipeId": slug, "assetPath": f"recipe_catalog/images/{slug}.jpg",
            "title": page["title"], "author": value("Artist"),
            "authorHtml": meta.get("Artist", {}).get("value"),
            "sourceUrl": info["descriptionurl"], "originalUrl": info["url"],
            "downloadUrl": download_url, "license": license_name, "licenseUrl": value("LicenseUrl").replace("http://creativecommons.org/", "https://creativecommons.org/"),
            "attributionRequired": value("AttributionRequired").lower() == "true",
            "shareAlike": license_name.startswith("CC BY-SA"),
            "creditLine": f'{page["title"][5:]} - {value("Artist")} - {license_name}',
            "changes": "Wikimedia-served thumbnail; no editorial image changes.",
            "representation": "REPRESENTATIVE_NOT_EXACT_RECIPE",
            "scene": "RAW_INGREDIENTS_BEFORE_BAKING" if slug == "baked-tilapia-with-tomatoes" else ("INGREDIENTS" if slug == "melon-and-mint" else "REPRESENTATIVE_PREPARED_FOOD"),
            "visualReview": "Inspected; illustrative only. Additional food and different preparation may be visible.",
            "checkedOn": page.get("reviewedOn", "2026-09-11"),
            "sha256": hashlib.sha256(data).hexdigest(), "bytes": len(data),
        })
        print(slug, len(data), license_name, flush=True)
    (ASSETS / "image_credits.json").write_text(json.dumps(images, ensure_ascii=False, indent=2) + "\n")


if __name__ == "__main__":
    main()
