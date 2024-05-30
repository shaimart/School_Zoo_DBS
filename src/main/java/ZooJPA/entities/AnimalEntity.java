package ZooJPA.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "animal", schema = "public", catalog = "shaimart")
public class AnimalEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_animal")
    private int idAnimal;
    @Basic
    @Column(name = "species", nullable = false)
    private String species;
    @Basic
    @Column(name = "dateofbirth", nullable = false)
    private Date dateofbirth;
    @Basic
    @Column(name = "animal_name", nullable = false)
    private String animalName;
    @Basic
    @Column(name = "namezoo", nullable = false)
    private String namezoo;
//    @OneToOne(mappedBy = "animalByIdAnimal")
//    private BirdsEntity birdsByIdAnimal;
    @OneToMany(mappedBy = "animalByIdAnimal")
    private Collection<CareEntity> caresByIdAnimal;
    @OneToMany(mappedBy = "animalByIdAnimal")
    private Collection<RecipeEntity> recipesByIdAnimal;
//    @OneToOne(mappedBy = "animalByIdAnimal")
//    private ReptilesEntity reptilesByIdAnimal;
    @OneToMany(mappedBy = "animalByIdAnimal")
    private Collection<ToeatEntity> toeatsByIdAnimal;
    @OneToMany(mappedBy = "animalByIdAnimal")
    private Collection<TovisitEntity> tovisitsByIdAnimal;

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getNamezoo() {
        return namezoo;
    }

    public void setNamezoo(String namezoo) {
        this.namezoo = namezoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalEntity that = (AnimalEntity) o;

        if (idAnimal != that.idAnimal) return false;
        if (species != null ? !species.equals(that.species) : that.species != null) return false;
        if (dateofbirth != null ? !dateofbirth.equals(that.dateofbirth) : that.dateofbirth != null) return false;
        if (animalName != null ? !animalName.equals(that.animalName) : that.animalName != null) return false;
        if (namezoo != null ? !namezoo.equals(that.namezoo) : that.namezoo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAnimal;
        result = 31 * result + (species != null ? species.hashCode() : 0);
        result = 31 * result + (dateofbirth != null ? dateofbirth.hashCode() : 0);
        result = 31 * result + (animalName != null ? animalName.hashCode() : 0);
        result = 31 * result + (namezoo != null ? namezoo.hashCode() : 0);
        return result;
    }

//    public BirdsEntity getBirdsByIdAnimal() {
//        return birdsByIdAnimal;
//    }
//
//    public void setBirdsByIdAnimal(BirdsEntity birdsByIdAnimal) {
//        this.birdsByIdAnimal = birdsByIdAnimal;
//    }

    public Collection<CareEntity> getCaresByIdAnimal() {
        return caresByIdAnimal;
    }

    public void setCaresByIdAnimal(Collection<CareEntity> caresByIdAnimal) {
        this.caresByIdAnimal = caresByIdAnimal;
    }

    public Collection<RecipeEntity> getRecipesByIdAnimal() {
        return recipesByIdAnimal;
    }

    public void setRecipesByIdAnimal(Collection<RecipeEntity> recipesByIdAnimal) {
        this.recipesByIdAnimal = recipesByIdAnimal;
    }

//    public ReptilesEntity getReptilesByIdAnimal() {
//        return reptilesByIdAnimal;
//    }
//
//    public void setReptilesByIdAnimal(ReptilesEntity reptilesByIdAnimal) {
//        this.reptilesByIdAnimal = reptilesByIdAnimal;
//    }

    public Collection<ToeatEntity> getToeatsByIdAnimal() {
        return toeatsByIdAnimal;
    }

    public void setToeatsByIdAnimal(Collection<ToeatEntity> toeatsByIdAnimal) {
        this.toeatsByIdAnimal = toeatsByIdAnimal;
    }

    public Collection<TovisitEntity> getTovisitsByIdAnimal() {
        return tovisitsByIdAnimal;
    }

    public void setTovisitsByIdAnimal(Collection<TovisitEntity> tovisitsByIdAnimal) {
        this.tovisitsByIdAnimal = tovisitsByIdAnimal;
    }
}
