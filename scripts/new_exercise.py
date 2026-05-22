#!/usr/bin/env python3
"""Generate Java exercise scaffolding for this repository.

Usage:
    python scripts/new_exercise.py arrayshashing containsduplicate
"""

from __future__ import annotations

import argparse
from pathlib import Path
import re
import sys


def write_file(path: Path, content: str, force: bool) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    if path.exists() and not force:
        raise FileExistsError(f"File already exists: {path}. Use --force to overwrite.")
    path.write_text(content, encoding="utf-8")


def to_slug_segment(value: str) -> str:
    # Convert PascalCase/camelCase/snake_case/space separated input to kebab-case.
    normalized = re.sub(r"[^A-Za-z0-9]+", "-", value.strip())
    normalized = re.sub(r"([a-z0-9])([A-Z])", r"\1-\2", normalized)
    normalized = re.sub(r"-+", "-", normalized).strip("-")
    return normalized.lower()


def to_package_segment(value: str) -> str:
    # Java package identifiers cannot contain '-', so keep a compact lowercase segment.
    return re.sub(r"[^A-Za-z0-9]", "", value).lower()


def to_class_name(value: str) -> str:
    # Build a Java class name from free-form input using PascalCase.
    normalized = re.sub(r"[^A-Za-z0-9]+", " ", value).strip()
    if not normalized:
        raise ValueError("exercise_name must contain at least one letter or digit")

    split_parts: list[str] = []
    for token in normalized.split():
        token_parts = re.findall(r"[A-Z]+(?=[A-Z][a-z]|[0-9]|$)|[A-Z]?[a-z]+|[0-9]+", token)
        split_parts.extend(token_parts if token_parts else [token])

    class_name = "".join(part[:1].upper() + part[1:].lower() for part in split_parts)
    if not class_name or not class_name[0].isalpha():
        raise ValueError("exercise_name must produce a Java class name that starts with a letter")

    return class_name


def confirm_overwrite_if_exists(main_dir: Path, test_dir: Path, force: bool) -> bool:
    if force:
        return True

    if not main_dir.exists() and not test_dir.exists():
        return False

    print("Warning: exercise folder already exists.")
    print(f"- {main_dir}")
    print(f"- {test_dir}")
    answer = input("Do you want to overwrite existing files? [y/N]: ").strip().lower()
    return answer in {"s", "si", "y", "yes"}


def build_contents(package_name: str, class_name: str, category_slug: str, exercise_slug: str) -> tuple[str, str, str]:
    java_content = f"""package {package_name};

public class {class_name} {{

    // TODO: define method signature based on exercise requirements.
}}
"""

    md_content = f"""# {class_name}

## Problem Statement

TODO: add the exercise statement here.

## Notes

- Category: {category_slug}
- Slug: {exercise_slug}
"""

    test_content = f"""package {package_name};

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class {class_name}Test {{

    private final {class_name} solution = new {class_name}();

    @Test
    void shouldCreateSolutionInstance() {{
        assertNotNull(solution);
    }}
}}
"""

    return java_content, md_content, test_content


def main() -> int:
    parser = argparse.ArgumentParser(description="Generate Java exercise scaffolding")
    parser.add_argument("exercise_type", help="Example: ArraysHashing")
    parser.add_argument("exercise_name", help="Example: ContainsDuplicate")
    parser.add_argument("--force", action="store_true", help="Overwrite files if they already exist")

    args = parser.parse_args()

    repo_root = Path(__file__).resolve().parent.parent
    main_root = repo_root / "src" / "main" / "java"
    test_root = repo_root / "src" / "test" / "java"

    if not main_root.exists() or not test_root.exists():
        print("Expected structure src/main/java and src/test/java was not found.", file=sys.stderr)
        return 1

    category_segment = to_package_segment(args.exercise_type)
    exercise_segment = to_package_segment(args.exercise_name)
    category_slug = to_slug_segment(args.exercise_type)
    exercise_slug = to_slug_segment(args.exercise_name)

    try:
        class_name = to_class_name(args.exercise_name)
    except ValueError as exc:
        parser.error(str(exc))

    package_category = to_package_segment(args.exercise_type)
    package_exercise = to_package_segment(args.exercise_name)
    package_name = f"{package_category}.{package_exercise}"

    main_dir = main_root / category_segment / exercise_segment
    test_dir = test_root / category_segment / exercise_segment

    java_path = main_dir / f"{class_name}.java"
    md_path = main_dir / f"{class_name}.md"
    test_path = test_dir / f"{class_name}Test.java"

    should_overwrite = confirm_overwrite_if_exists(main_dir, test_dir, args.force)
    if (main_dir.exists() or test_dir.exists()) and not should_overwrite:
        print("Operation canceled. No files were overwritten.")
        return 0

    java_content, md_content, test_content = build_contents(
        package_name=package_name,
        class_name=class_name,
        category_slug=category_slug,
        exercise_slug=exercise_slug,
    )

    write_file(java_path, java_content, should_overwrite)
    write_file(md_path, md_content, should_overwrite)
    write_file(test_path, test_content, should_overwrite)

    print("Scaffold created successfully:")
    print(f"- {java_path}")
    print(f"- {md_path}")
    print(f"- {test_path}")
    print("")
    print(f"Suggested next step: mvn -q -Dtest={class_name}Test test")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
