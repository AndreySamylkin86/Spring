package dz6.persist;


import ru.geekbrains.persist.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Сustomer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 128)
    private String name;

    @ManyToMany(mappedBy = "customers")
    private List<Product> products;


    public Сustomer() {
    }

    public Сustomer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
