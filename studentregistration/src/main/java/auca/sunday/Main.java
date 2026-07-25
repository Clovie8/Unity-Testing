package auca.sunday;

import auca.sunday.domain.model.Semester;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting JPA Connection test...");

        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("auca_pu");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Semester testSemester = new Semester();
            testSemester.setId("SEM-TEST2");
            testSemester.setName("Test Two Semester");
            testSemester.setStartDate(LocalDate.of(2026, 9, 10)); 
            testSemester.setEndDate(LocalDate.of(2026, 02, 17)); 

            em.persist(testSemester);

            em.getTransaction().commit();
            
            System.out.println("==================================================");
            System.out.println("SUCCESS! Connected to PostgreSQL and saved record.");
            System.out.println("==================================================");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}