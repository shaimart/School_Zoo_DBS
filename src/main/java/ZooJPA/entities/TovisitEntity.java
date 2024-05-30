package ZooJPA.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tovisit", schema = "public", catalog = "shaimart")
@IdClass(TovisitEntityPK.class)
public class TovisitEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_visitor")
    private int idVisitor;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_animal")
    private int idAnimal;
    @ManyToOne
    @JoinColumn(name = "id_visitor", referencedColumnName = "id_visitor", nullable = false)
    private VisitorEntity visitorByIdVisitor;
    @ManyToOne
    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal", nullable = false)
    private AnimalEntity animalByIdAnimal;

    public int getIdVisitor() {
        return idVisitor;
    }

    public void setIdVisitor(int idVisitor) {
        this.idVisitor = idVisitor;
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

        TovisitEntity that = (TovisitEntity) o;

        if (idVisitor != that.idVisitor) return false;
        if (idAnimal != that.idAnimal) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisitor;
        result = 31 * result + idAnimal;
        return result;
    }

    public VisitorEntity getVisitorByIdVisitor() {
        return visitorByIdVisitor;
    }

    public void setVisitorByIdVisitor(VisitorEntity visitorByIdVisitor) {
        this.visitorByIdVisitor = visitorByIdVisitor;
    }

    public AnimalEntity getAnimalByIdAnimal() {
        return animalByIdAnimal;
    }

    public void setAnimalByIdAnimal(AnimalEntity animalByIdAnimal) {
        this.animalByIdAnimal = animalByIdAnimal;
    }
}
