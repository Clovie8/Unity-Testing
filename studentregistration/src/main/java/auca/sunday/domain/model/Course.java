package auca.sunday.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_definition_code", nullable = false)
    private CourseDefinition courseDefinition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_unit_code")
    private AcademicUnit academicUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tutor_code")
    private Teacher tutor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assistant_tutor_code")
    private Teacher assistantTutor;

    public Course() {}

}
