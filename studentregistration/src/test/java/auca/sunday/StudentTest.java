package auca.sunday;

import auca.sunday.domain.enums.EAcademicUnit;
import auca.sunday.domain.model.AcademicUnit;
import auca.sunday.domain.model.Semester;
import auca.sunday.domain.model.Student;
import auca.sunday.domain.model.StudentRegistration;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StudentTest {

    @Test
    public void testStudentRegistrationCreation() {
        Student student = new Student();
        student.setRegNo("STU123");
        student.setFirstName("Alice");
        student.setDateOfBirth(LocalDate.of(2000, 5, 20));

        AcademicUnit academicUnit = new AcademicUnit();
        academicUnit.setCode("COMPSCI");
        academicUnit.setName("Computer Science");
        academicUnit.setUnitType(EAcademicUnit.DEPARTMENT);

        Semester semester = new Semester();
        semester.setId("S2026");
        semester.setName("Spring 2026");
        semester.setStartDate(LocalDate.of(2026, 1, 10));
        semester.setEndDate(LocalDate.of(2026, 5, 25));

        StudentRegistration registration = new StudentRegistration();
        registration.setStudent(student);
        registration.setAcademicUnit(academicUnit);
        registration.setSemester(semester);
        registration.setRegistrationDate(LocalDate.of(2026, 1, 15));

        assertNotNull(registration.getStudent());
        assertEquals("STU123", registration.getStudent().getRegNo());
        assertEquals("Alice", registration.getStudent().getFirstName());
        assertEquals(LocalDate.of(2026, 1, 15), registration.getRegistrationDate());
        assertNotNull(registration.getAcademicUnit());
        assertEquals(EAcademicUnit.DEPARTMENT, registration.getAcademicUnit().getUnitType());
        assertNotNull(registration.getSemester());
        assertEquals("Spring 2026", registration.getSemester().getName());
    }
}

