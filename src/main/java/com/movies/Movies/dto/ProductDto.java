package com.movies.Movies.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductDto {

    @NotBlank
    @Getter @Setter
    private String title;

    @Getter @Setter
    private String description;


    @Getter @Setter
    private String image;
    @Min(0)
    @Getter @Setter
    private int stock;
    @Min(0)
    @Getter @Setter
    private float rentalprice;
    @Min(0)
    @Getter @Setter
    private float saleprice;

    @Getter @Setter
    private int available;

    public ProductDto() {
    }

    public ProductDto(String title, String description, String image, int stock, float rentalprice, float saleprice, int available) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.stock = stock;
        this.rentalprice = rentalprice;
        this.saleprice = saleprice;
        this.available = available;
    }
}
