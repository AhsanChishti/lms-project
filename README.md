# LMS Project

A small library management system built up over the SEC321L Software Construction labs. Requires JDK 17 or newer. Everything lives in the `com.hitms` package tree.

## Build

```
mvn clean install
```

## Test

```
mvn test
```

## Check style

```
mvn checkstyle:check
```

## Run

```
mvn clean compile
java -cp target/classes com.hitms.lms.Main
```

The client demo imports the util package, seeds a few books and members, issues and returns copies, and shows both custom exceptions.

## Built-in lab exercises

| Package | What it demonstrates |
| --- | --- |
| `com.hitms.lab01` | Environment setup: `HelloWorld`, and `Colors` printing through Jansi |
| `com.hitms.lab02` | Naming conventions: `AreaCalculator`, and `PriceUtils` with Javadoc |
| `com.hitms.lab03` | Modularity: `ReportUtil` decomposition plus the `model` / `util` split |
| `com.hitms.lab04` | Exceptions and debugging: `DivisionDemo`, `MaxDebug`, `AppLogger` |
| `com.hitms.lms` | The LMS itself: `LibraryService`, custom exceptions, `Main` |

## What it does

- **Add a book** to the catalogue, with a given number of copies.
- **Issue a book**, reducing the available copies, or raise `BookUnavailableException` when none are left.
- **Return a book**, adding the copy back to the shelf.
- **Register members** and look them up, or raise `MemberNotFoundException` for unknown ids.

## Tests

| Test class | Covers |
| --- | --- |
| `LibraryServiceTest` | Adding, issuing, returning, and the unavailable-title exception |

## State

State lives in memory for the life of the process; there is no persistence yet, that lands with the later labs.
