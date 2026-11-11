"""Make a diagnostic contact sheet; the distributed photographs are unchanged."""
import json
from pathlib import Path

from PIL import Image, ImageDraw, ImageOps

ROOT = Path(__file__).resolve().parents[2]
assets = ROOT / "app/src/main/assets"
credits = json.loads((assets / "recipe_catalog/image_credits.json").read_text())
sheet = Image.new("RGB", (1200, ((len(credits) + 3) // 4) * 240), "white")
draw = ImageDraw.Draw(sheet)
for i, credit in enumerate(credits):
    x, y = (i % 4) * 300, (i // 4) * 240
    with Image.open(assets / credit["assetPath"]) as picture:
        picture.verify()
    with Image.open(assets / credit["assetPath"]) as picture:
        preview = ImageOps.contain(picture.convert("RGB"), (288, 204))
        sheet.paste(preview, (x + (300 - preview.width) // 2, y))
    draw.text((x + 5, y + 209), f'{i + 1}. {credit["recipeId"]}', fill="black")
sheet.save(ROOT / "docs/recipe_catalog/image_review.jpg", quality=90)
print(f"Decoded {len(credits)} images and created the review sheet.")
