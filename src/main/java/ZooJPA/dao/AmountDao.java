package ZooJPA.dao;

import jakarta.persistence.EntityManager;

import jakarta.persistence.Query;

public class AmountDao {

private EntityManager em;

    public AmountDao(EntityManager em) {
        this.em = em;
    }

    public void updateFeedAmounts() {
        // Update amount for 'Feed4'
        Query query1 = em.createQuery("UPDATE AmountEntity a SET a.amount = a.amount + 1 WHERE a.namefeed = :feedName1");
        query1.setParameter("feedName1", "Feed4");
        query1.executeUpdate();

        // Update amount for 'Feed1'
        Query query2 = em.createQuery("UPDATE AmountEntity a SET a.amount = a.amount - 1 WHERE a.namefeed = :feedName2");
        query2.setParameter("feedName2", "Feed1");
        query2.executeUpdate();
    }
}

