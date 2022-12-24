package com.github.javamultiplex.entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Rohit Agarwal on 24/12/22 3:31 pm
 * @copyright github.com/javamultiplex
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
