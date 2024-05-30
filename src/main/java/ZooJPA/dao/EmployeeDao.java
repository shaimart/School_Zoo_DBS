package ZooJPA.dao;

import ZooJPA.entities.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmployeeDao {
    private final EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    public EmployeeEntity findEmployeeById(int idEmployee) {
        return em.find(EmployeeEntity.class, idEmployee);
    }

    public void create(EmployeeEntity employee) {
        em.persist(employee);
    }

    public void delete(EmployeeEntity employee) {
        em.remove(employee);
    }

    public void update(EmployeeEntity employee) {
        em.merge(employee);
    }

    public void refresh(EmployeeEntity employee) {
        em.refresh(employee);
    }

    public List<EmployeeEntity> getAllEmployees() {
        TypedQuery<EmployeeEntity> query = em.createQuery("SELECT e FROM EmployeeEntity e", EmployeeEntity.class);
        return query.getResultList();
    }

    public List<EmployeeEntity> getEmployeesByZoo(String nameZoo) {
        TypedQuery<EmployeeEntity> query = em.createQuery("SELECT e FROM EmployeeEntity e WHERE e.namezoo = :nameZoo", EmployeeEntity.class);
        query.setParameter("nameZoo", nameZoo);
        return query.getResultList();
    }



    public EmployeeEntity findEmployeeByRodnecislo(String rodnecislo) {
        TypedQuery<EmployeeEntity> query = em.createQuery("SELECT e FROM EmployeeEntity e WHERE e.rodnecislo = :rodnecislo", EmployeeEntity.class);
        query.setParameter("rodnecislo", rodnecislo);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
