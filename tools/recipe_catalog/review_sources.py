"""Extract visible recipe content, independently of potentially stale JSON-LD."""
from html.parser import HTMLParser
import json
from pathlib import Path
import sys


class Node:
    def __init__(self, tag="root", attrs=()):
        self.tag, self.attrs, self.children = tag, dict(attrs), []

    def text(self):
        return " ".join(" ".join(c if isinstance(c, str) else c.text() for c in self.children).split())

    def find(self, tag=None, cls=None):
        result = []
        if (tag is None or self.tag == tag) and (cls is None or cls in self.attrs.get("class", "").split()):
            result.append(self)
        for c in self.children:
            if isinstance(c, Node):
                result.extend(c.find(tag, cls))
        return result


class Document(HTMLParser):
    VOID = {"area", "base", "br", "col", "embed", "hr", "img", "input", "link", "meta", "param", "source", "track", "wbr"}

    def __init__(self, text):
        super().__init__()
        self.root = Node()
        self.stack = [self.root]
        self.feed(text)

    def handle_starttag(self, tag, attrs):
        node = Node(tag, attrs)
        self.stack[-1].children.append(node)
        if tag not in self.VOID:
            self.stack.append(node)

    def handle_endtag(self, tag):
        for i in range(len(self.stack) - 1, 0, -1):
            if self.stack[i].tag == tag:
                del self.stack[i:]
                break

    def handle_data(self, text):
        if self.stack[-1].tag not in {"script", "style"}:
            self.stack[-1].children.append(text)


def extract(path):
    root = Document(path.read_text()).root
    content = root.find(cls="mp-content")
    ingredients, steps, notes = [], [], []
    timing = " ".join(n.text() for n in root.find(cls="recipe-info"))
    for n in content:
        if n.text().startswith("Ingredients"):
            ingredients = [x.text() for x in n.find("li")]
        if n.text().startswith("Directions"):
            for ol in n.find("ol"):
                steps.extend(x.text() for x in ol.find("li"))
            for ul in n.find("ul"):
                notes.extend(x.text() for x in ul.find("li"))
    facts = [x.text() for x in root.find(cls="fact-row")]
    return {"slug": path.stem, "timing": timing, "ingredients": ingredients,
            "steps": steps, "notes": notes, "facts": facts}


if __name__ == "__main__":
    folder = Path("/tmp/practice-fitness-recipe-sources")
    paths = [folder / f"{s}.html" for s in sys.argv[1:]] if len(sys.argv) > 1 else sorted(folder.glob("*.html"))
    for path in paths:
        data = extract(path)
        (folder / f"{path.stem}.visible.json").write_text(json.dumps(data, ensure_ascii=False, indent=2) + "\n")
        print(json.dumps(data, ensure_ascii=False))
