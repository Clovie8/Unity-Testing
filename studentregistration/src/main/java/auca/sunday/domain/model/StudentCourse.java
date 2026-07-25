package auca.sunday.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "student_course")
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_registration_id", nullable = false)
    private StudentRegistration studentRegistration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "credits", nullable = false)
    private Integer credits;

    @Column(name = "results", precision = 5, scale = 2)
    private BigDecimal results;

    public StudentCourse() {}

}
