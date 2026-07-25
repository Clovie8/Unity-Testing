package auca.sunday.domain.model; 

import auca.sunday.domain.enums.EQualification; 
import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "names", nullable = false)
    private String names;

    @Enumerated(EnumType.STRING)
    @Column(name = "qualification", nullable = false)
    private EQualification qualification;

    public Teacher() {}

}