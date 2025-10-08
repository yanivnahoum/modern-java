# Modern Java (JDK 25) Workshop

Hands‑on workshop for practicing and teaching modern Java (up to Java 25) language features and idioms. The repo is organized as a multi‑module Maven project:

- `modern-java-examples` – Curated, minimal examples demonstrating individual features.
- `modern-java-exercises` – Test‑driven exercises for participants to implement. Failing (or skipped) tests guide the work.

## Contents / Feature Map
| Package (examples module) | Focus / Topics |
|---------------------------|----------------|
| `data`                    | Simple domain/data classes; contrast with records & Lombok |
| `interfaces`              | Interface evolution: default & static methods, multiple inheritance rules |
| `lambdas`                 | Functional interfaces, lambda syntax variations, method references |
| `optional`                | Proper `Optional` usage patterns & anti‑patterns |
| `patternmatching`         | Pattern matching for `instanceof`, switch patterns, record patterns |
| `records`                 | Records: declaration, canonical constructor validation, compact constructors |
| `sealed`                  | Sealed classes & interfaces, permits clauses, exhaustive switches |
| `streams`                 | Stream pipeline patterns, collectors, performance notes |
| `switches`                | Enhanced switch (expressions, arrows, pattern labels, guards) |
| `text`                    | Text blocks, string templates (if adopted), formatting APIs |

> The exercises module mirrors many of these areas but provides skeletons + tests you complete.

## Why Java 25?
Java 25 (GA September 2025) consolidates several features introduced across recent releases (17–24) plus refinements:
- Mature pattern matching in `switch` (no longer preview) & richer guards.
- Record patterns usable in more contexts.
- Sealed hierarchy ergonomics improvements.
- Continuous improvements to virtual threads (if you extend the workshop later) – not yet in examples here but easy to add.

(Adjust this list as you add/curate features.)

## Project Structure
```
modern-java/ (root aggregator POM)
  modern-java-examples/     # Executable / reference examples (no tests by design)
  modern-java-exercises/    # Test-driven exercises (JUnit + AssertJ + Mockito)
```
Root `pom.xml` manages shared versions and Java release target:
- `maven.compiler.release = 25`
- Testing stack (scoped in exercises module):
  - JUnit Jupiter 6.0.0
  - AssertJ 3.27.6
  - Mockito 5.20.0 (core + JUnit Jupiter extension)
- Jackson (examples that may need JSON) – `jackson-databind` 2.20.0
- Lombok (examples only; provided scope) – 1.18.42

## Prerequisites
- JDK 25 (ensure `java -version` shows 25.x). AdoptOpenJDK / Eclipse Temurin / Oracle builds are fine.
- Maven 3.9.x+ (optional, because the Maven Wrapper is included)
- An IDE with Java 25 support (IntelliJ IDEA 2024.2+ recommended)

## Getting Started
Clone and build everything (tests in exercises are skipped by default via `skipTests=true` property):
```bash
./mvnw clean verify
```
You should see both modules build successfully.

### Running All Exercise Tests
The exercises module sets `<skipTests>true</skipTests>` so the parent build is fast for newcomers. To actually run tests:
```bash
./mvnw -pl modern-java-exercises test -DskipTests=false
```
Or override at the parent level:
```bash
./mvnw test -DskipTests=false
```

### Running a Single Test Class
```bash
./mvnw -q -pl modern-java-exercises -Dtest=records.RecordsTest test -DskipTests=false
```
(Adjust `-Dtest=` to match the package / class you want.)

### Importing into IntelliJ
1. Open the root directory (`pom.xml` will be detected as aggregator).
2. Ensure Project SDK is set to JDK 25.
3. Enable Annotation Processors (for Lombok) if you add Lombok usages in exercises.
4. Re‑import Maven projects to sync.

## Working Through the Exercises
1. Pick a feature (e.g. Records). Open corresponding tests in `modern-java-exercises/src/test/java/...`
2. Run the test – it may be disabled, skipped, or initially failing.
3. Implement missing code under `src/main/java/...`
4. Re-run tests until green.
5. Compare with the reference approach in the `modern-java-examples` module (but only after trying yourself!).

### Example: Records
Test snippet (`RecordsTest`) asserts:
- `HttpClientProperties` is a `record`.
- Null validations throw `NullPointerException` with specific messages.
- Overloaded construction and factory (`of`) semantics.
Use a compact constructor or explicit canonical constructor to enforce invariants.

## Conventions & Guidelines
- Keep examples minimal: one concept per file when possible.
- Prefer expressive names in exercises; comments may hint at constraints.
- Use AssertJ fluent assertions for clarity.
- Favor pure functions for exercises unless the feature under study involves state.
- Keep package names lowercase and aligned with topic names for discoverability.

## Adding a New Feature Module Area
1. In `modern-java-examples/src/main/java/com/.../training/java/` create a new package (e.g. `virtualthreads`).
2. Add illustrative example classes.
3. In exercises module, mirror the package and add tests driving the task.
4. Update this README Feature Map table.

## Upgrading Dependencies / Java Version
- Change `maven.compiler.release` in root POM if moving beyond Java 25.
- Use Maven Versions Plugin to audit updates:
```bash
./mvnw versions:use-latest-releases -Dincludes=org.junit.jupiter:* -DgenerateBackupPoms=false
```
Revert or pin intentionally; this is a teaching repo—stability matters more than chasing every micro update.

## Common Troubleshooting
| Issue | Fix |
|-------|-----|
| Tests not running | Ensure you passed `-DskipTests=false` or removed `<skipTests>true</skipTests>` in exercises POM |
| Lombok annotations not working in IDE | Enable annotation processing in IDE settings, recompile |
| Using the wrong JDK | `echo $JAVA_HOME` and `java -version` – adjust shell config or IDE SDK |
| Failing URL/URI examples behind proxy | Replace with a neutral internal URL if needed for corporate networks |

## Extending Beyond Core Language
Potential future sections (PRs welcome):
- Virtual Threads & Structured Concurrency
- HTTP Client (incubator to standard usage patterns)
- Foreign Function & Memory API examples
- Performance profiling mini‑lab

## Contribution Workflow
1. Fork & branch (`feature/pattern-matching-nested-examples`).
2. Add / modify examples + matching exercises & tests.
3. Update README Feature Map.
4. Run `./mvnw verify -DskipTests=false` locally.
5. Open a PR describing learning objective & rationale.

## License
(Choose an OSI license – e.g. Apache 2.0 or MIT – and place it in `LICENSE`. Update this section accordingly.)

## Acknowledgements
Inspired by incremental Java evolution from 8 through 25; designed for internal workshop delivery and self‑study.

Happy learning – embrace the modern Java toolbox!

