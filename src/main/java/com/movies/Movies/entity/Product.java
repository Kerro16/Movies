package com.movies.Movies.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter
    private int id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private int stock;

    @Getter @Setter
    private float rentalprice;

    @Getter @Setter
    private float saleprice;

    @Getter @Setter
    private int available;

    public Product(String title, String description, String image, int stock, float rentalprice, float saleprice, int available) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.stock = stock;
        this.rentalprice = rentalprice;
        this.saleprice = saleprice;
        this.available = available;
    }

    public Product() {
    }
}
