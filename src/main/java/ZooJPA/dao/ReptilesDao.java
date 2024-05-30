package ZooJPA.dao;

import ZooJPA.entities.ReptilesEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ReptilesDao {

private final EntityManager em;

    public ReptilesDao(EntityManager em) {
        this.em = em;
    }

    public ReptilesEntity findReptileById(int idAnimal) {
        return em.find(ReptilesEntity.class, idAnimal);
    }

    public void create(ReptilesEntity reptile) {
        em.persist(reptile);
    }

    public void delete(ReptilesEntity reptile) {
        em.remove(reptile);
    }

    public void update(ReptilesEntity reptile) {
        em.merge(reptile);
    }

    public void refresh(ReptilesEntity reptile) {
        em.refresh(reptile);
    }

    public List<ReptilesEntity> getReptilesByActivity(String activity) {
        return em.createQuery("SELECT r FROM ReptilesEntity r WHERE r.activity = :activity", ReptilesEntity.class)
                .setParameter("activity", activity)
                .getResultList();
    }
}
