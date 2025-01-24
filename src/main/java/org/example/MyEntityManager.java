package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MyEntityManager {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("catalogoBibliograficoPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public static void close() {
        emf.close();
    }
}