package ZooJPA.dao;

import ZooJPA.entities.AnimalEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AnimalDao {

private final EntityManager em;

    public AnimalDao(EntityManager em) {
        this.em = em;
    }

    public AnimalEntity findAnimalById(int idAnimal) {
        return em.find(AnimalEntity.class, idAnimal);
    }

    public void create(AnimalEntity animal) {
        em.persist(animal);
    }

    public void delete(AnimalEntity animal) {
        em.remove(animal);
    }

    public void update(AnimalEntity animal) {
        em.merge(animal);
    }

    public void refresh(AnimalEntity animal) {
        em.refresh(animal);
    }

    public List<AnimalEntity> getAnimalsBySpecies(String species) {
        return em.createQuery("SELECT a FROM AnimalEntity a WHERE a.species = :species", AnimalEntity.class)
                .setParameter("species", species)
                .getResultList();
    }

    public List<AnimalEntity> getAnimalsByNameZoo(String nameZoo) {
        return em.createQuery("SELECT a FROM AnimalEntity a WHERE a.namezoo = :nameZoo", AnimalEntity.class)
                .setParameter("nameZoo", nameZoo)
                .getResultList();
    }
}
