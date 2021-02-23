package ru.geekbrains.persist;

import ru.geekbrains.service.ProductRepr;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String productname;

    @Column
    private String title;

    @Column(nullable = false)
    private BigDecimal price;

    public Product() {
    }

    public Product(String productname) {
        this.productname = productname;
    }



    public Product(ProductRepr productRepr) {
        this.id = productRepr.getId();
        this.productname = productRepr.getProductname();
        this.title = productRepr.getTitle();
        this.price = productRepr.getPrice();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
