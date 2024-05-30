package ZooJPA.entities;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_animal")
@Table(name = "birds", schema = "public", catalog = "shaimart")
public class BirdsEntity extends AnimalEntity {
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "id_animal")
//    private int idAnimal;
    @Basic
    @Column(name = "amountofcolor")
    private Integer amountofcolor;
    @Basic
    @Column(name = "wingspan")
    private Integer wingspan;
//    @OneToOne
//    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal", nullable = false)
//    private AnimalEntity animalByIdAnimal;
//
//    public int getIdAnimal() {
//        return idAnimal;
//    }
//
//    public void setIdAnimal(int idAnimal) {
//        this.idAnimal = idAnimal;
//    }

    public Integer getAmountofcolor() {
        return amountofcolor;
    }

    public void setAmountofcolor(Integer amountofcolor) {
        this.amountofcolor = amountofcolor;
    }

    public Integer getWingspan() {
        return wingspan;
    }

    public void setWingspan(Integer wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BirdsEntity that = (BirdsEntity) o;

//        if (idAnimal != that.idAnimal) return false;
        if (amountofcolor != null ? !amountofcolor.equals(that.amountofcolor) : that.amountofcolor != null)
            return false;
        if (wingspan != null ? !wingspan.equals(that.wingspan) : that.wingspan != null) return false;

        return true;
    }

//    @Override
//    public int hashCode() {
//        int result = idAnimal;
//        result = 31 * result + (amountofcolor != null ? amountofcolor.hashCode() : 0);
//        result = 31 * result + (wingspan != null ? wingspan.hashCode() : 0);
//        return result;
//    }
//
//    public AnimalEntity getAnimalByIdAnimal() {
//        return animalByIdAnimal;
//    }
//
//    public void setAnimalByIdAnimal(AnimalEntity animalByIdAnimal) {
//        this.animalByIdAnimal = animalByIdAnimal;
//    }
}
