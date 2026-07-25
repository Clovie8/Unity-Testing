package auca.sunday.service;

import auca.sunday.domain.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseService {

    // Backed by a List as requested
    private List<Course> courseList = new ArrayList<>();

    public String saveCourse(Course c) {
        if (c == null) {
            return "provide course data";
        }

        // Rule: duplicate courseCode (ignore case) rejected
        if (searchByCourseCode(c.getCourseCode()) != null) {
            return "course already exists";
        }

        // Rule: credits must be between 1 and 18
        if (c.getCredits() < 1 || c.getCredits() > 18) {
            return "invalid credits";
        }

        courseList.add(c);
        return "course saved successfully";
    }

    public Course searchByCourseCode(String code) {
        if (code == null) {
            return null;
        }

        for (Course course : courseList) {
            if (course.getCourseCode().equalsIgnoreCase(code)) {
                return course;
            }
        }
        return null;
    }

    public String deleteCourse(String code) {
        Course courseToDelete = searchByCourseCode(code);

        if (courseToDelete != null) {
            courseList.remove(courseToDelete);
            return "course deleted";
        }

        return "course not found";
    }
}