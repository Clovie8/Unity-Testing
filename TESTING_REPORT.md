# SOFTWARE TESTING PRACTICAL ASSIGNMENT
**Student Name:** Clovis Dukundimana
**Institution:** AUCA
**Course:** Software Testing

---

## Part 0: Warm-Up (LifecycleDemoTest)

**Written Questions:**

**Why must `@BeforeClass` and `@AfterClass` methods be static in JUnit 4?**
JUnit creates a brand new instance of the test class for every single `@Test` method, so class-level annotations must be `static` to ensure they run exactly once for the entire file rather than being tied to an individual object instance.

**When would you use `@Before` instead of `@BeforeClass`? Give a concrete example.**
You use `@Before` for quick state resets that must happen before every single test scenario to ensure test independence, such as clearing out a shared `List<Course>` or executing a SQL `DELETE` statement so leftover data does not corrupt the next test.

**What happens to `@After` if the test fails – does it still run?**
Yes, `@After` still runs even if a test fails or crashes, acting exactly like a `finally` block in Java to guarantee that necessary cleanup (like closing a file or rolling back a transaction) always occurs.

---

## Part 1: Project 1 - Course Management System

### Annotations Used
*   **`@Before`**: Used to seed the `CourseService` with a fresh, clean list of two known courses before every individual test execution to guarantee test independence.
*   **`@Test`**: Used to flag methods as executable test cases to validate specific business rules.

### Written Questions
**Task 4 Trick Question:** Your duplicate-check test saves "CS301" and then "cs301". Which assert method proves the second save was rejected, and why is `assertEquals("course already exists", response)` better than `assertTrue(response.contains("exists"))`?
**Answer:** `assertEquals` is better because it is strictly deterministic; if the method accidentally returned the wrong message (e.g., "course does not exist"), `assertTrue` with a `.contains()` check would yield a false positive and pass, whereas `assertEquals` guarantees the exact business rule message was fired.

### Test Execution Outputs
**All Green Output (mvn test):**
```text
[INFO] Running auca.sunday.CourseServiceTest
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
```

**Failing Test Screenshot:**
*[Insert your screenshot of the red terminal output here showing the intentional failure of saveCourse_shouldReturnAlreadyExists_whenCodeIsDuplicate]*

---

## Part 2: Project 2 - Teacher Payroll

### Annotations Used

* **`@BeforeClass`**: Used to instantiate the `PayrollService` and load the static `Teacher` objects exactly once for the entire test run to save processing time.
* **`@Test`**: Used to execute the boundary mathematics and category bonus calculations.
* **`@Test(expected = IllegalArgumentException.class)`**: Used to strictly assert that providing negative hours or negative pay rates successfully triggers the correct system exception.

### Boundary Table (Task 2)

| Hours Worked | Overtime Applied | Calculation Logic | Expected Total Pay (RWF) |
| --- | --- | --- | --- |
| **159** (Below Boundary) | No | 159 * 10,000 | 1,590,000.0 |
| **160** (Exact Boundary) | No | 160 * 10,000 | 1,600,000.0 |
| **161** (Above Boundary) | Yes | (160 * 10,000) + (1 * (10,000 * 1.5)) | 1,615,000.0 |

### Written Questions

**Task 5 Question:** Your colleague's test computes the expected salary by calling the same `PayrollService` method being tested – `assertEquals(service.calculatePay(t), service.calculatePay(t))`. The test always passes. Explain why it is useless.
**Answer:** This test is useless because it performs a circular validation (a tautology); by calling the exact same method on both sides, it simply checks if a function equals itself, meaning any bugs in the math logic will be mirrored on both sides and the test will falsely pass.

### Test Execution Outputs

**All Green Output (mvn test):**

```text
[INFO] Running auca.sunday.PayrollServiceTest
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 9, Failures: 0, Errors: 0, Skipped: 0

```

**Failing Test Screenshot:**
*[Insert your screenshot of the red terminal output here showing the intentional failure when modifying the math logic]*
