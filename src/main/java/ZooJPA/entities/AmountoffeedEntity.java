package ZooJPA.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "amountoffeed", schema = "public", catalog = "shaimart")
@IdClass(AmountoffeedEntityPK.class)
public class AmountoffeedEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_feed")
    private int idFeed;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_amount")
    private int idAmount;
    @ManyToOne
    @JoinColumn(name = "id_feed", referencedColumnName = "id_feed", nullable = false)
    private FeedEntity feedByIdFeed;
    @ManyToOne
    @JoinColumn(name = "id_amount", referencedColumnName = "id_amount", nullable = false)
    private AmountEntity amountByIdAmount;

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

        AmountoffeedEntity that = (AmountoffeedEntity) o;

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

    public FeedEntity getFeedByIdFeed() {
        return feedByIdFeed;
    }

    public void setFeedByIdFeed(FeedEntity feedByIdFeed) {
        this.feedByIdFeed = feedByIdFeed;
    }

    public AmountEntity getAmountByIdAmount() {
        return amountByIdAmount;
    }

    public void setAmountByIdAmount(AmountEntity amountByIdAmount) {
        this.amountByIdAmount = amountByIdAmount;
    }
}
