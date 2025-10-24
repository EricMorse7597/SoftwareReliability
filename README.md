
# CIS*4150 SoftwareReliability

A collection of assignments, utilities, and a research paper related to software reliability, testing, and small example projects (Java and Python). This repository collects course assignments (A1–A5), supporting libraries, a research paper (LaTeX source + PDF), and research code used for evaluation.

## Quick summary

- Language: Java (JUnit-based assignments) and Python (unit-tested utilities / research code)
- Tests: JUnit 4 for Java projects, pytest for Python projects
- Paper: LaTeX source under `Research Paper/` and compiled PDF `Research_Paper.pdf`

## Repository layout

- `A1/` — Java assignment 1 (union of vectors). Contains `src/`, `lib/` with JUnit jars and an `A1/README.md`.
- `A2/` — Java assignment 2 (min & prime numbers) with tests and local `lib/` for JUnit.
- `A3/` — Assignment 3 (Python `graph.py` for finding prime paths).
- `A4/` — Assignment 4. Contains a small Python calculator example in `Q2/` with `calculator.py` and tests.
- `A5/` — Java assignment 5 (Programmable Thermostat) with `Thermostat.java`, `ProgrammedSettings.java`, `ThermostatTest.java` and supporting enums.
- `Research Paper/` — LaTeX source for the research paper plus figures and bibliography.
- `Research-paper-code/` — Python research code (scientific calculator) and tests.
- `lib/` — Common JUnit / Hamcrest jars used by some assignments.
- `.github/workflows/python-app.yml` — CI workflow that runs pytest and optionally builds/runs a Docker image.
- `requirements.txt` — Python test requirements (pytest, pytest-cov).
- `Dockerfile` — container image used by CI for running Python tests.

## Requirements

- Java 8+ (for compiling/running the Java assignments)
- Python 3.8+ (the CI uses 3.10; local Python 3.10 recommended)
- `pip` for Python dependencies
- `pdflatex` / TeX toolchain if you want to rebuild the LaTeX paper

Python dependencies are pinned in `requirements.txt`:

```text
pytest==8.3.3
pytest-cov==6.0.0
```

## Running the Python tests

Most Python tests live in `Research-paper-code/` and `A4/Q2/`.

1. Create a virtual environment and install dependencies:

```bash
python -m venv .venv
source .venv/bin/activate
pip install --upgrade pip
pip install -r requirements.txt
```

2. Run tests (research code):

```bash
pytest Research-paper-code/ --cov
```

3. Run the small calculator tests in A4:

```bash
pytest A4/Q2/
```

CI: The repository contains a GitHub Actions workflow (`.github/workflows/python-app.yml`) that installs dependencies and runs `pytest` against `Research-paper-code/`.

## Running Java tests (JUnit 4)

Several assignments use JUnit 4. Each assignment typically contains its own `lib/` directory with the necessary JARs (JUnit and Hamcrest). Example commands below assume a Unix-like shell and that JUnit jars are present in the assignment `lib/` folder.

Notes:
- Many source files are in the default (unnamed) Java package. That makes classpath-based execution easier but is not recommended for larger projects.

Example: run A1 tests

```bash
# Compile sources and tests into a bin directory
mkdir -p A1/bin
javac -cp "A1/lib/junit-4.13.2.jar:A1/lib/hamcrest-core-1.3.jar:." -d A1/bin A1/src/*.java

# Run the test (uses JUnitCore). Class name is the test class without package.
java -cp "A1/bin:A1/lib/junit-4.13.2.jar:A1/lib/hamcrest-core-1.3.jar:." org.junit.runner.JUnitCore DataDrivenUnionTest
```

Example: run A5 (Thermostat) tests — adjust classpath to where the JUnit jars live (A5 uses top-level `lib/` in this repo or `A5/lib` if present):

```bash
mkdir -p A5/bin
javac -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:." -d A5/bin A5/*.java
java -cp "A5/bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:." org.junit.runner.JUnitCore ThermostatTest
```

If your assignment folder includes its own `lib/` (e.g., `A2/lib`), point the classpath to those jars instead.

IDE: Alternatively, open the assignment folder in VS Code / IntelliJ and import as a Java project — the IDE will handle the classpath and test runner for you.

## Rebuilding the Research Paper (LaTeX)

The LaTeX source for the research paper lives under `Research Paper/`. A simple workflow to rebuild the PDF (may vary depending on your LaTeX distribution):

```bash
cd "Research Paper"
pdflatex main.tex
bibtex main       # if you changed citations
pdflatex main.tex
pdflatex main.tex
# output will be main.pdf
```

The repository already contains a compiled PDF `Research_Paper.pdf`.

## Docker

The repository includes a `Dockerfile` that installs the Python requirements and runs `pytest` inside the container. Example:

```bash
# Build
docker build -t software-reliability:latest .

# Run (this runs pytest in Research-paper-code by default per the Dockerfile)
docker run --rm software-reliability:latest
```

GitHub Actions also includes a job (`run-tests-docker`) that demonstrates building and running the Docker image.

## Notes, caveats and known issues

- Some Java sources are intentionally in the default package (no package declaration) since these are small course assignments. That affects how tests are run from the command line.
- JUnit 4 is used; the classpath must include both `junit-4.13.2.jar` and `hamcrest-core-1.3.jar` when compiling and running tests.
- `A2/PrimeNumbers.java` contains a clearly marked faulty algorithm (intentional for testing exercises) — if you plan to use it as a utility, review and fix the algorithm.
- The Python tests in `Research-paper-code/` are extensive and use math functions; some tests assert against large numbers or approximations — `pytest.approx` is used in many places.

## Contact / Attribution

Repository owner: Eric Morse (workspace owner). This is a course-style collection of assignments and a research paper. Use the code for learning, testing, and experiments.

If you'd like, I can also:
- add Makefile or simple scripts to automate Java compilation and running tests for each assignment,
- add a matrix CI to run Java tests in GitHub Actions, or
- fix/annotate the intentionally faulty algorithms (A2 PrimeNumbers) and add unit tests that illustrate the bug.

---
Generated: October 23, 2025
