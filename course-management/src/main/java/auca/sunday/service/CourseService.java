package auca.sunday.service;

import auca.sunday.domain.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseService {

    // Backed by a List as requested
    private List<Course> courseList = new ArrayList<>();

    public String saveCourse(Course c) {
        // null  course rejected 
        if (c == null) {
            return "provide course data";
        }

        // duplicate courseCode (ignore case) rejected
        if (searchByCourseCode(c.getCourseCode()) != null) {
            return "course already exists";
        }

        // credits must be between 1 and 5
        if (c.getCredits() < 1 || c.getCredits() > 5) {
            return "invalid credits";
        }
        
        // valid course 
        courseList.add(c);
        return "course saved successfully";
    }

    public Course searchByCourseCode(String code) {
        // not found or null  code 
        if (code == null) {
            return null;
        }

        // found 
        for (Course course : courseList) {
            if (course.getCourseCode().equalsIgnoreCase(code)) {
                return course;
            }
        }
        return null;
    }

    public String deleteCourse(String code) {
        Course courseToDelete = searchByCourseCode(code);
        
        // found and removed 
        if (courseToDelete != null) {
            courseList.remove(courseToDelete);
            return "course deleted";
        }
        
        // not found 
        return "course not found";
    }
}
