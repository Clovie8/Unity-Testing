package auca.sunday.domain.model; 

import auca.sunday.domain.enums.EAcademicUnit; 
import jakarta.persistence.*;

@Entity
@Table(name = "academic_unit")
public class AcademicUnit {

    @Id
    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_type", nullable = false)
    private EAcademicUnit unitType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_code")
    private AcademicUnit parent;

    public AcademicUnit() {}
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EAcademicUnit getUnitType() {
        return unitType;
    }

    public void setUnitType(EAcademicUnit unitType) {
        this.unitType = unitType;
    }

    public AcademicUnit getParent() {
        return parent;
    }

    public void setParent(AcademicUnit parent) {
        this.parent = parent;
    }

}