package ru.geekbrains.service;

import ru.geekbrains.persist.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class ProductRepr {

    private Long id;

    @NotEmpty
    private String productname;

    private String title;

    @NotNull(message = "не должно быть пустым")
    private BigDecimal price;

    public ProductRepr() {
    }

    public ProductRepr(String productname) {
        this.productname = productname;
    }

    public ProductRepr(Product product) {
        this.id = product.getId();
        this.productname = product.getProductname();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
