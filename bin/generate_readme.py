#!/usr/bin/env python3
"""Regenerate README.md listing solved LeetCode problems per language."""

from __future__ import annotations

import re
from pathlib import Path
from typing import Dict, List, Optional, Sequence, Set, Tuple

ROOT = Path(__file__).resolve().parents[1]
README_PATH = ROOT / "README.md"
LANGUAGE_CONFIG: Sequence[Tuple[str, Path, str]] = (
    ("Java", ROOT / "leetcodejava" / "src" / "main" / "java" / "com" / "leetcode", ".java"),
    ("C++", ROOT / "leetcodecpp" / "leetcode", ".cpp"),
    ("Python", ROOT / "leetcodepython" / "app" / "leetcode", ".py"),
)


def collect_problem_names(folder: Path, extension: str) -> List[str]:
    if not folder.exists():
        return []

    names: List[str] = []
    for path in folder.iterdir():
        if not path.is_file():
            continue
        if path.name.startswith("."):
            continue
        if path.suffix != extension:
            continue
        names.append(path.stem)

    return sorted(names, key=str.lower)


_DIGIT_WORDS: Dict[str, str] = {
    "zero": "0",
    "one": "1",
    "two": "2",
    "three": "3",
    "four": "4",
    "five": "5",
    "six": "6",
    "seven": "7",
    "eight": "8",
    "nine": "9",
}

_TENS_WORDS: Dict[str, int] = {
    "ten": 10,
    "twenty": 20,
    "thirty": 30,
    "forty": 40,
    "fifty": 50,
    "sixty": 60,
    "seventy": 70,
    "eighty": 80,
    "ninety": 90,
}

_NUMBER_WORDS: Set[str] = set(_DIGIT_WORDS) | set(_TENS_WORDS)


def _split_camel_or_acronym(name: str) -> List[str]:
    # Examples:
    # - OneThreeFour -> [One, Three, Four]
    # - LCRZeroFourOne -> [LCR, Zero, Four, One]
    # - ten -> [ten]
    pattern = r"[A-Z]+(?![a-z])|[A-Z][a-z]+|[a-z]+|\d+"
    return re.findall(pattern, name)


def _greedy_word_tokenize(lower_name: str) -> Optional[List[str]]:
    # Tokenize strings like "twoeight" or "twoninezero".
    # Prefer longest match to reduce ambiguity.
    vocab = sorted(_NUMBER_WORDS, key=len, reverse=True)
    tokens: List[str] = []
    i = 0
    while i < len(lower_name):
        matched = None
        for word in vocab:
            if lower_name.startswith(word, i):
                matched = word
                break
        if matched is None:
            return None
        tokens.append(matched)
        i += len(matched)
    return tokens


def parse_problem_id(stem: str) -> Optional[int]:
    s = stem.strip()
    if not s or s.startswith("__"):
        return None

    if s.isdigit():
        return int(s)

    parts = _split_camel_or_acronym(s)
    lower_parts = [p.lower() for p in parts]

    # If there's no obvious camel-case segmentation (often all-lower), try greedy.
    if len(parts) == 1 and parts[0].islower():
        greedy = _greedy_word_tokenize(parts[0])
        if greedy is not None:
            lower_parts = greedy

    number_parts = [p for p in lower_parts if p in _NUMBER_WORDS]
    if not number_parts:
        return None

    if all(p in _DIGIT_WORDS for p in number_parts):
        return int("".join(_DIGIT_WORDS[p] for p in number_parts))

    if len(number_parts) == 1 and number_parts[0] in _TENS_WORDS:
        return _TENS_WORDS[number_parts[0]]

    if (
        len(number_parts) == 2
        and number_parts[0] in _TENS_WORDS
        and number_parts[1] in _DIGIT_WORDS
    ):
        return _TENS_WORDS[number_parts[0]] + int(_DIGIT_WORDS[number_parts[1]])

    return None


def _checkmark(value: bool) -> str:
    return "✅" if value else ""


def build_readme(language_to_ids: Dict[str, Set[int]]) -> str:
    languages = ["Java", "C++", "Python"]
    all_ids: Set[int] = set()
    for lang in languages:
        all_ids |= language_to_ids.get(lang, set())

    total_unique = len(all_ids)
    total_per_lang = {lang: len(language_to_ids.get(lang, set())) for lang in languages}

    lines: List[str] = [
        "# LeetCode Practice Tracker",
        "",
        f"Total problems solved (unique): **{total_unique}**.",
        "",
        "Each solution file name spells out the corresponding LeetCode problem number (e.g., `OneThreeFour` ⇒ Problem 134).",
        "",
        "## Solved Problems Table",
        "",
    ]

    lines.append(f"Java: **{total_per_lang['Java']}** | C++: **{total_per_lang['C++']}** | Python: **{total_per_lang['Python']}**")
    lines.append("")

    lines.append("| Problem | Java | C++ | Python |")
    lines.append("|---:|:---:|:---:|:---:|")
    for pid in sorted(all_ids):
        lines.append(
            "| "
            + str(pid)
            + " | "
            + _checkmark(pid in language_to_ids.get("Java", set()))
            + " | "
            + _checkmark(pid in language_to_ids.get("C++", set()))
            + " | "
            + _checkmark(pid in language_to_ids.get("Python", set()))
            + " |"
        )

    return "\n".join(lines).strip() + "\n"


def write_if_changed(path: Path, content: str) -> None:
    if path.exists() and path.read_text() == content:
        print(f"{path} already up to date.")
        return
    path.write_text(content)
    print(f"Wrote {path} with updated problem list.")


def main() -> None:
    language_to_ids: Dict[str, Set[int]] = {"Java": set(), "C++": set(), "Python": set()}

    for language, folder, ext in LANGUAGE_CONFIG:
        print(f"Scanning {language} in: {folder}", flush=True)
        stems = collect_problem_names(folder, ext)
        ids: Set[int] = set()
        skipped = 0
        for stem in stems:
            pid = parse_problem_id(stem)
            if pid is None:
                skipped += 1
                continue
            ids.add(pid)
        language_to_ids[language] = ids
        print(f"{language}: {len(ids)} parsed problem IDs (skipped {skipped} non-problem files)", flush=True)

    readme_content = build_readme(language_to_ids)
    write_if_changed(README_PATH, readme_content)


if __name__ == "__main__":
    main()
