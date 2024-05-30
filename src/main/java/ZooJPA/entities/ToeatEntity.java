package ZooJPA.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "toeat", schema = "public", catalog = "shaimart")
@IdClass(ToeatEntityPK.class)
public class ToeatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_feed")
    private int idFeed;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_animal")
    private int idAnimal;
    @ManyToOne
    @JoinColumn(name = "id_feed", referencedColumnName = "id_feed", nullable = false)
    private FeedEntity feedByIdFeed;
    @ManyToOne
    @JoinColumn(name = "id_animal", referencedColumnName = "id_animal", nullable = false)
    private AnimalEntity animalByIdAnimal;

    public int getIdFeed() {
        return idFeed;
    }

    public void setIdFeed(int idFeed) {
        this.idFeed = idFeed;
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

        ToeatEntity that = (ToeatEntity) o;

        if (idFeed != that.idFeed) return false;
        if (idAnimal != that.idAnimal) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFeed;
        result = 31 * result + idAnimal;
        return result;
    }

    public FeedEntity getFeedByIdFeed() {
        return feedByIdFeed;
    }

    public void setFeedByIdFeed(FeedEntity feedByIdFeed) {
        this.feedByIdFeed = feedByIdFeed;
    }

    public AnimalEntity getAnimalByIdAnimal() {
        return animalByIdAnimal;
    }

    public void setAnimalByIdAnimal(AnimalEntity animalByIdAnimal) {
        this.animalByIdAnimal = animalByIdAnimal;
    }
}
