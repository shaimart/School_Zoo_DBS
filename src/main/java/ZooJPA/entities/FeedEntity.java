package ZooJPA.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "feed", schema = "public", catalog = "shaimart")
public class FeedEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_feed")
    private int idFeed;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "unitofmeasurement")
    private String unitofmeasurement;
    @ManyToOne
    @JoinColumn(name = "name", referencedColumnName = "namefeed",  nullable = false, insertable = false, updatable = false)
    private AmountEntity amountByName;
    @OneToMany(mappedBy = "feedByIdFeed")
    private Collection<AmountoffeedEntity> amountoffeedsByIdFeed;
    @OneToMany(mappedBy = "feedByIdFeed")
    private Collection<ToeatEntity> toeatsByIdFeed;

    public int getIdFeed() {
        return idFeed;
    }

    public void setIdFeed(int idFeed) {
        this.idFeed = idFeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitofmeasurement() {
        return unitofmeasurement;
    }

    public void setUnitofmeasurement(String unitofmeasurement) {
        this.unitofmeasurement = unitofmeasurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedEntity that = (FeedEntity) o;

        if (idFeed != that.idFeed) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (unitofmeasurement != null ? !unitofmeasurement.equals(that.unitofmeasurement) : that.unitofmeasurement != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFeed;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unitofmeasurement != null ? unitofmeasurement.hashCode() : 0);
        return result;
    }

    public AmountEntity getAmountByName() {
        return amountByName;
    }

    public void setAmountByName(AmountEntity amountByName) {
        this.amountByName = amountByName;
    }

    public Collection<AmountoffeedEntity> getAmountoffeedsByIdFeed() {
        return amountoffeedsByIdFeed;
    }

    public void setAmountoffeedsByIdFeed(Collection<AmountoffeedEntity> amountoffeedsByIdFeed) {
        this.amountoffeedsByIdFeed = amountoffeedsByIdFeed;
    }

    public Collection<ToeatEntity> getToeatsByIdFeed() {
        return toeatsByIdFeed;
    }

    public void setToeatsByIdFeed(Collection<ToeatEntity> toeatsByIdFeed) {
        this.toeatsByIdFeed = toeatsByIdFeed;
    }
}
