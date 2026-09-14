# 2627i.32d by [Prof. Paulo Pereira](https://palbp.github.io/)
Repository for LEIC-TDS course, winter semester of 2026-2027, course section LEIC32D

## Outline
-----------

### Week 1 (07/09/2026)
* Course introduction
  * Syllabus
  * Evaluation criteria
  * Course materials
* Revision
  * Execution on the JVM
  * Memory
    * Memory areas: stack, heap and global
    * Garbage collection and memory retention
  * Objects, values and references 
    * A case for immutability: simplicity
    * Aliasing and side effects
* Demos:
  * Testing limits: StackOverflowError and OutOfMemoryError
  * Consequences of aliasing combined with mutable data types

References:
* [Immutability in Kotlin](https://kotlinlang.org/docs/coding-conventions.html#immutability)
* [Immutability we can afford, by Roman Elizarov](https://elizarov.medium.com/immutability-we-can-afford-10c0dcb8351d)
* [Video lecture](https://youtu.be/thp4b0JEvFU) (in Portuguese)

-----------
### Week 2 (14/09/2026)
#### Part 1 - Domain model
* Principles of software design
  * Purpose and benefits of software design
  * Abstraction and encapsulation
  * Separation of concerns
    * Domain model: purpose and benefits of a domain model
    * The case against primitive obsession: the need for a domain model
* Introduction to the SOLID principles
  * SRP - Single Responsibility Principle (the S in SOLID)
* Introduction to automated testing
  * Unit testing with Kotlin's test framework
  * Test-driven development (TDD) as a human discipline
* Demos:
  * Building a domain model for the "8 Puzzle" application
* [Video lecture](https://youtu.be/v3uRTXBDluI) (in Portuguese)

##### Part 2 - Building a Domain Model in Kotlin _(coming soon)_
* Kotlin's [classes](https://kotlinlang.org/docs/classes.html)
  * [Primary](https://kotlinlang.org/docs/classes.html#primary-constructor) and [secondary constructors](https://kotlinlang.org/docs/classes.html#secondary-constructors)
  * [Initialization blocks](https://kotlinlang.org/docs/classes.html#initializer-blocks)
  * [Data classes](https://kotlinlang.org/docs/data-classes.html#standard-data-classes), revisited
* [Companion objects](https://kotlinlang.org/docs/classes.html#companion-objects)
* [Operator overloading](https://kotlinlang.org/docs/operator-overloading.html) in Kotlin
* Demos:
  * Building a domain model for the "8 Puzzle" application (no leakage of implementation details)
* Video lecture (in Portuguese)

-----------
