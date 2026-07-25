package auca.sunday.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_definition")
public class CourseDefinition {

    @Id
    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public CourseDefinition() {}

}