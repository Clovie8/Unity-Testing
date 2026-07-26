package auca.sunday;

import auca.sunday.domain.Course;
import auca.sunday.service.CourseService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseServiceTest {

    private CourseService service;

    // Use @Before to create a clean state with two known courses
    @Before
    public void setUp() {
        service = new CourseService();
        service.saveCourse(new Course("CS101", "Intro to Programming", 3, 50));
        service.saveCourse(new Course("ENG201", "General English", 2, 30));
    }

    // Tests for saveCourse() 
    @Test
    public void saveCourse_shouldReturnProvideCourseData_whenCourseIsNull() {
        String result = service.saveCourse(null);
        assertEquals("provide course data", result);
    }

    @Test
    public void saveCourse_shouldReturnAlreadyExists_whenCodeIsDuplicate() {
        Course duplicateCourse = new Course("cs101", "Duplicate Course", 4, 20);
        String result = service.saveCourse(duplicateCourse);
        assertEquals("course already exists", result);
    }

    @Test
    public void saveCourse_shouldReturnInvalidCredits_whenCreditsAreBelowOne() {
        Course badCourse = new Course("MAT301", "Calculus", 0, 40);
        String result = service.saveCourse(badCourse);
        assertEquals("invalid credits", result);
    }

    @Test
    public void saveCourse_shouldReturnInvalidCredits_whenCreditsAreAboveFive() {
        Course badCourse = new Course("PHY401", "Quantum Physics", 6, 20);
        String result = service.saveCourse(badCourse);
        assertEquals("invalid credits", result);
    }

    @Test
    public void saveCourse_shouldReturnSuccess_whenCourseIsValid() {
        Course validCourse = new Course("DBA201", "Database Admin", 4, 40);
        String result = service.saveCourse(validCourse);
        assertEquals("course saved successfully", result);
    }

    // Tests for searchByCourseCode() 

    @Test
    public void searchByCourseCode_shouldReturnCourse_whenCodeIsFound() {
        Course found = service.searchByCourseCode("ENG201");
        assertNotNull(found);
        assertEquals("Technical Writing", found.getCourseName());
    }

    @Test
    public void searchByCourseCode_shouldReturnSameObject_whenCodeIsFound() {
        Course original = new Course("NET301", "Networking", 3, 25);
        service.saveCourse(original);

        Course found = service.searchByCourseCode("NET301");
        assertSame("Should return the exact memory reference of the saved course", original, found);
    }

    @Test
    public void searchByCourseCode_shouldReturnNull_whenCodeIsNotFoundOrNull() {
        assertNull(service.searchByCourseCode("NONEXISTENT999"));
        assertNull(service.searchByCourseCode(null));
    }

    // Tests for deleteCourse() 

    @Test
    public void deleteCourse_shouldReturnCourseDeleted_whenFoundAndRemoved() {
        String result = service.deleteCourse("CS101");
        assertEquals("course deleted", result);
        assertNull(service.searchByCourseCode("CS101"));
    }

    @Test
    public void deleteCourse_shouldReturnCourseNotFound_whenCodeDoesNotExist() {
        String result = service.deleteCourse("FAKECODE");
        assertEquals("course not found", result);
    }
}
