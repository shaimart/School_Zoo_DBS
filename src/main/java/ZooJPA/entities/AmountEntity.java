package ZooJPA.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "amount", schema = "public", catalog = "shaimart")
public class AmountEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_amount")
    private int idAmount;
    @Basic
    @Column(name = "amount")
    private int amount;
    @Basic
    @Column(name = "namefeed")
    private String namefeed;
    @OneToMany(mappedBy = "amountByIdAmount")
    private Collection<AmountoffeedEntity> amountoffeedsByIdAmount;

    public int getIdAmount() {
        return idAmount;
    }

    public void setIdAmount(int idAmount) {
        this.idAmount = idAmount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNamefeed() {
        return namefeed;
    }

    public void setNamefeed(String namefeed) {
        this.namefeed = namefeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmountEntity that = (AmountEntity) o;

        if (idAmount != that.idAmount) return false;
        if (amount != that.amount) return false;
        if (namefeed != null ? !namefeed.equals(that.namefeed) : that.namefeed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAmount;
        result = 31 * result + amount;
        result = 31 * result + (namefeed != null ? namefeed.hashCode() : 0);
        return result;
    }

    public Collection<AmountoffeedEntity> getAmountoffeedsByIdAmount() {
        return amountoffeedsByIdAmount;
    }

    public void setAmountoffeedsByIdAmount(Collection<AmountoffeedEntity> amountoffeedsByIdAmount) {
        this.amountoffeedsByIdAmount = amountoffeedsByIdAmount;
    }
}
