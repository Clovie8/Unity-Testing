package auca.sunday;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.fail;

public class LifecycleDemoTest {

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println(">> BeforeClass");
    }

    @Before
    public void setUp() {
        System.out.println(">> Before");
    }

    @Test
    public void testMethodOne() {
        System.out.println(">> Test 1");
    }

    @Test
    public void testMethodTwo() {
        System.out.println(">> Test 2");
    }

    @Test
    public void testMethodThreeFailing() {
        System.out.println(">> Test 3 (Intentionally Failing)");
        fail("Crashing this test to prove @After still runs!");
    }

    @After
    public void tearDown() {
        System.out.println(">> After");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println(">> AfterClass");
    }
}
