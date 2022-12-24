package com.github.javamultiplex;

import com.github.javamultiplex.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * @author Rohit Agarwal on 24/12/22 3:23 pm
 * @copyright github.com/javamultiplex
 */
public class Main {
    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        final EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        Product product1 = new Product();
        product1.setId(201);
        product1.setName("Beer");
        product1.setPrice(10.4);
        product1.setExpirationDate(LocalDate.now());

        try {
            entityManager1.getTransaction().begin();
            entityManager1.persist(product1);
            entityManager1.getTransaction().commit();
        }catch (Exception e){
            entityManager1.getTransaction().rollback();
        }finally {
            entityManager1.close();
        }

        final EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        Product product2 = new Product();
        product2.setId(202);
        product2.setName("Beer");
        product2.setPrice(10.4);
        product2.setExpirationDate(LocalDate.now());

        try {
            entityManager2.getTransaction().begin();
            entityManager2.persist(product2);
            entityManager2.getTransaction().commit();
        }catch (Exception e){
            entityManager2.getTransaction().rollback();
        }finally {
            entityManager2.close();
        }
    }
}