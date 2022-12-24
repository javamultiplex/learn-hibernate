package com.github.javamultiplex;

import com.github.javamultiplex.entities.Product;

import javax.persistence.Persistence;

/**
 * @author Rohit Agarwal on 24/12/22 3:23 pm
 * @copyright github.com/javamultiplex
 */
public class Main {
    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        var entityManager = entityManagerFactory.createEntityManager();

        Product product=new Product();
        product.setName("Beer");

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}