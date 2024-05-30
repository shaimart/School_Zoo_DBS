package ZooJPA.dao;

import ZooJPA.entities.BirdsEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BirdsDao {

private final EntityManager em;

    public BirdsDao(EntityManager em) {
        this.em = em;
    }

    public BirdsEntity findBirdById(int idAnimal) {
        return em.find(BirdsEntity.class, idAnimal);
    }

    public void create(BirdsEntity bird) {
        em.persist(bird);
    }

    public void delete(BirdsEntity bird) {
        em.remove(bird);
    }

    public void update(BirdsEntity bird) {
        em.merge(bird);
    }

    public void refresh(BirdsEntity bird) {
        em.refresh(bird);
    }

    public List<BirdsEntity> getBirdsByWingspan(int wingspan) {
        return em.createQuery("SELECT b FROM BirdsEntity b WHERE b.wingspan = :wingspan", BirdsEntity.class)
                .setParameter("wingspan", wingspan)
                .getResultList();
    }
}
