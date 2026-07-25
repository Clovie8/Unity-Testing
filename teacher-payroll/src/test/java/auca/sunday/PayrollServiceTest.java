package auca.sunday;

import auca.sunday.domain.Teacher;
import auca.sunday.domain.TeacherCategory;
import auca.sunday.service.PayrollService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayrollServiceTest {

    private static PayrollService service;
    private static Teacher assistant;
    private static Teacher lecturer;
    private static Teacher seniorLecturer;
    private static Teacher professor;

    // Task 1 Explanation:
    // We cannot use assertEquals(expected, actual) for doubles because floating-point 
    // arithmetic in computers is inherently imprecise (e.g., 0.1 + 0.2 might yield 0.300000000004). 
    // The 'delta' parameter defines the maximum acceptable difference between the expected and actual values.
    // We use a delta of 0.001 because for payroll (money), accuracy to the third decimal place is sufficient.
    private static final double DELTA = 0.001;

    // Task 3: Load test teachers once using @BeforeClass (static)
    @BeforeClass
    public static void setUpClass() {
        service = new PayrollService();
        
        // Base setup: All work exactly 100 hours at 10,000 RWF to easily test bonuses
        assistant = new Teacher("T1", "Alice", 10000, 100, TeacherCategory.ASSISTANT);
        lecturer = new Teacher("T2", "Bob", 10000, 100, TeacherCategory.LECTURER);
        seniorLecturer = new Teacher("T3", "Charlie", 10000, 100, TeacherCategory.SENIOR_LECTURER);
        professor = new Teacher("T4", "Diana", 10000, 100, TeacherCategory.PROFESSOR);
    }

    // --- Task 2: Exact Boundary Tests (159, 160, 161 hours) ---

    // Expected: 159 hours * 10,000 = 1,590,000 (No overtime)
    @Test
    public void calculatePay_shouldNotApplyOvertime_whenHoursAre159() {
        Teacher t = new Teacher("B1", "Test", 10000, 159, TeacherCategory.ASSISTANT);
        assertEquals(1590000.0, service.calculatePay(t), DELTA);
    }

    // Expected: 160 hours * 10,000 = 1,600,000 (Exact threshold, no overtime)
    @Test
    public void calculatePay_shouldNotApplyOvertime_whenHoursAreExactly160() {
        Teacher t = new Teacher("B2", "Test", 10000, 160, TeacherCategory.ASSISTANT);
        assertEquals(1600000.0, service.calculatePay(t), DELTA);
    }

    // Expected: (160 * 10,000) + (1 * (10,000 * 1.5)) = 1,600,000 + 15,000 = 1,615,000
    @Test
    public void calculatePay_shouldApplyOvertime_whenHoursAre161() {
        Teacher t = new Teacher("B3", "Test", 10000, 161, TeacherCategory.ASSISTANT);
        assertEquals(1615000.0, service.calculatePay(t), DELTA);
    }

    // --- Task 3: Category Bonus Tests ---

    // Expected: 100 * 10,000 = 1,000,000 + 0% bonus = 1,000,000
    @Test
    public void calculatePay_shouldApplyNoBonus_forAssistant() {
        assertEquals(1000000.0, service.calculatePay(assistant), DELTA);
    }

    // Expected: 100 * 10,000 = 1,000,000 + 5% bonus = 1,050,000
    @Test
    public void calculatePay_shouldApply5PercentBonus_forLecturer() {
        assertEquals(1050000.0, service.calculatePay(lecturer), DELTA);
    }

    // Expected: 100 * 10,000 = 1,000,000 + 10% bonus = 1,100,000
    @Test
    public void calculatePay_shouldApply10PercentBonus_forSeniorLecturer() {
        assertEquals(1100000.0, service.calculatePay(seniorLecturer), DELTA);
    }

    // Expected: 100 * 10,000 = 1,000,000 + 15% bonus = 1,150,000
    @Test
    public void calculatePay_shouldApply15PercentBonus_forProfessor() {
        assertEquals(1150000.0, service.calculatePay(professor), DELTA);
    }

    // --- Task 4: Exception Tests ---

    @Test(expected = IllegalArgumentException.class)
    public void calculatePay_shouldThrow_whenHoursAreNegative() {
        Teacher t = new Teacher("E1", "Error", 10000, -5, TeacherCategory.ASSISTANT);
        service.calculatePay(t);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculatePay_shouldThrow_whenRateIsNegative() {
        Teacher t = new Teacher("E2", "Error", -500, 100, TeacherCategory.ASSISTANT);
        service.calculatePay(t);
    }
}