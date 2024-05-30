package ZooJPA.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class AmountoffeedEntityPK implements Serializable {
    @Column(name = "id_feed")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFeed;
    @Column(name = "id_amount")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAmount;

    public int getIdFeed() {
        return idFeed;
    }

    public void setIdFeed(int idFeed) {
        this.idFeed = idFeed;
    }

    public int getIdAmount() {
        return idAmount;
    }

    public void setIdAmount(int idAmount) {
        this.idAmount = idAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmountoffeedEntityPK that = (AmountoffeedEntityPK) o;

        if (idFeed != that.idFeed) return false;
        if (idAmount != that.idAmount) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFeed;
        result = 31 * result + idAmount;
        return result;
    }
}
