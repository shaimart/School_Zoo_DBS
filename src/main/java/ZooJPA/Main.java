
package ZooJPA;

import ZooJPA.dao.*;
import ZooJPA.entities.AnimalEntity;
import ZooJPA.entities.BirdsEntity;
import ZooJPA.entities.EmployeeEntity;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
public class Main {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static AmountDao amountDao;
    private static AnimalDao animalDao;
    private static BirdsDao birdsDao;
    private static ReptilesDao reptilesDao;
    private static EmployeeDao employeeDao;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("ApplicationPU");
        em = emf.createEntityManager();

        // Создание DAO объектов
        amountDao = new AmountDao(em);
        animalDao = new AnimalDao(em);
        birdsDao = new BirdsDao(em);
        reptilesDao = new ReptilesDao(em);
        employeeDao = new EmployeeDao(em);

        try {
            updateFeedAmounts(); // ok
            createEntities(); // ok
            deleteAnimal(); // ok
            printEmployees(); // ok
        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {

            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        // Закрытие EntityManagerFactory
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    // Update
    private static void updateFeedAmounts() {

        em.getTransaction().begin();


        amountDao.updateFeedAmounts();


        em.getTransaction().commit();
    }


    // Creating + inheritance
private static void createEntities() {
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();

    try {
        // Ctreating an Saving  AnimalEntity
        BirdsEntity animal = new BirdsEntity();
        animal.setSpecies("Birds");
        animal.setDateofbirth(Date.valueOf("2023-11-11"));
        animal.setAnimalName("Hlo");
        animal.setNamezoo("Prague Zoo");
        animalDao.create(animal);

        // Saving AnimalEntity for getting his ID
        em.flush();


        animal.setAmountofcolor(5);
        animal.setWingspan(120);

        birdsDao.create(animal);



        transaction.commit();

    } catch (Exception e) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
        throw e;
    }
}

// Delete
    private static void deleteAnimal() {
        // Start
        em.getTransaction().begin();

        // delete entity AnimalEntity with ID 27
        AnimalEntity animalToDelete = animalDao.findAnimalById(27);
        if (animalToDelete != null) {
            animalDao.delete(animalToDelete);
            System.out.println("Animal was successfully deleted.");
        } else {
            System.out.println("Animal was not found.");
        }


        em.getTransaction().commit();
    }

    // Print
    private static void printEmployees() {
        //  Printing All Employees
        List<EmployeeEntity> allEmployees = employeeDao.getAllEmployees();
        System.out.println("All Employees:");
        for (EmployeeEntity employee : allEmployees) {
            System.out.println("Employee ID: " + employee.getIdEmployee());
            System.out.println("First Name: " + employee.getFirstname());
            System.out.println("Second Name: " + employee.getSecondname());
            System.out.println("Date of Birth: " + employee.getDateofbirth());
            System.out.println("Rodne cislo: " + employee.getRodnecislo());
            System.out.println("Zoo Name: " + employee.getNamezoo());
            System.out.println("-----------------------------------");
        }

        // Printing Employees by Zoo
        String zooName = "Tokyo Zoo"; //  нужное название зоопарка
        List<EmployeeEntity> employeesByZoo = employeeDao.getEmployeesByZoo(zooName);
        System.out.println("Employees at " + zooName + ":");
        for (EmployeeEntity employee : employeesByZoo) {
            System.out.println("Employee ID: " + employee.getIdEmployee());
            System.out.println("First Name: " + employee.getFirstname());
            System.out.println("Second Name: " + employee.getSecondname());
            System.out.println("Date of Birth: " + employee.getDateofbirth());
            System.out.println("Rodne cislo: " + employee.getRodnecislo());
            System.out.println("-----------------------------------");
        }
    }
}


