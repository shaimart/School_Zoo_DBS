package ZooJPA.entities;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_animal")
@Table(name = "reptiles", schema = "public", catalog = "shaimart")
public class ReptilesEntity extends AnimalEntity {
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_animal")
    private int idAnimal;
    @Basic
    @Column(name = "activity")
    private String activity;
    @Basic
    @Column(name = "mimicry")
    private Boolean mimicry;
    @OneToOne
    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal", nullable = false)
    private AnimalEntity animalByIdAnimal;

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Boolean getMimicry() {
        return mimicry;
    }

    public void setMimicry(Boolean mimicry) {
        this.mimicry = mimicry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReptilesEntity that = (ReptilesEntity) o;

        if (idAnimal != that.idAnimal) return false;
        if (activity != null ? !activity.equals(that.activity) : that.activity != null) return false;
        if (mimicry != null ? !mimicry.equals(that.mimicry) : that.mimicry != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAnimal;
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        result = 31 * result + (mimicry != null ? mimicry.hashCode() : 0);
        return result;
    }

    public AnimalEntity getAnimalByIdAnimal() {
        return animalByIdAnimal;
    }

    public void setAnimalByIdAnimal(AnimalEntity animalByIdAnimal) {
        this.animalByIdAnimal = animalByIdAnimal;
    }
}
