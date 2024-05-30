package ZooJPA.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class TovisitEntityPK implements Serializable {
    @Column(name = "id_visitor")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVisitor;
    @Column(name = "id_animal")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnimal;

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

        TovisitEntityPK that = (TovisitEntityPK) o;

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
}
