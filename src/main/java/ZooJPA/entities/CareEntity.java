package ZooJPA.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "care", schema = "public", catalog = "shaimart")
@IdClass(CareEntityPK.class)
public class CareEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_employee")
    private int idEmployee;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_animal")
    private int idAnimal;
    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee", nullable = false)
    private EmployeeEntity employeeByIdEmployee;
    @ManyToOne
    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal", nullable = false)
    private AnimalEntity animalByIdAnimal;

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CareEntity that = (CareEntity) o;

        if (idEmployee != that.idEmployee) return false;
        if (idAnimal != that.idAnimal) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmployee;
        result = 31 * result + idAnimal;
        return result;
    }

    public EmployeeEntity getEmployeeByIdEmployee() {
        return employeeByIdEmployee;
    }

    public void setEmployeeByIdEmployee(EmployeeEntity employeeByIdEmployee) {
        this.employeeByIdEmployee = employeeByIdEmployee;
    }

    public AnimalEntity getAnimalByIdAnimal() {
        return animalByIdAnimal;
    }

    public void setAnimalByIdAnimal(AnimalEntity animalByIdAnimal) {
        this.animalByIdAnimal = animalByIdAnimal;
    }
}
