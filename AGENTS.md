# AGENTS

## Role

This repository uses coding agents to scaffold NeetCode-style exercises in Java.

## Default Behavior For New Exercises

When the user provides a new exercise statement:

1. Add or update the exercise documentation (`.md`) with:
- Title
- Difficulty
- Problem statement
- Examples (input/output)
- Constraints

2. Add or update unit tests in `src/test/java/...` with:
- The official examples from the statement
- Useful edge cases (zeros, negatives, minimum size, etc.)
- Clear test names

3. Keep package naming and folder conventions consistent with existing files.

## Hard Constraint

- Never solve the exercise.
- Never add algorithm implementation in the main solution class.
- If a method body is required for compilation, leave only a minimal placeholder and a TODO comment.
- Do not replace placeholders with full logic unless the user explicitly asks for implementation.

## Scope

These instructions apply to all exercises in this workspace unless the user explicitly overrides them.
