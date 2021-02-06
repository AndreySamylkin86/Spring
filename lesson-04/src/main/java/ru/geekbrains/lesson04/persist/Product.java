package ru.geekbrains.lesson04.persist;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product {

    private Long id;

    @NotEmpty
    private String productName;
    private String description;

    @NotNull
    private Double price;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }


    public Product(String productName, String description, Double price) {
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
