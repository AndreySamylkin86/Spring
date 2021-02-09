package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        UserRepository ur = new UserRepository(emFactory);
        ur.insert(new User("user10", "password10", "some4@email.cc"));
        List<User> userList = ur.findAll();
        System.out.println(userList.toString());
        User user = ur.findById(3);
        System.out.println(user.toString());
        user.setUsername("newName");
        ur.update(user);
        System.out.println(ur.findById(3).toString());
        ur.delete(5);

        ProductRepository pr = new ProductRepository(emFactory);
        pr.insert(new Product("Apple", "Nice apple", 10.0));
        pr.insert(new Product("Orange", "Big orange", 18.0));
        pr.insert(new Product("Banana", "Little banana", 15.0));
        List<Product> productList = pr.findAll();
        System.out.println(productList.toString());
        Product product = pr.findById(3);
        System.out.println(product.toString());
        product.setProductName("newName");
        pr.update(product);
        System.out.println(pr.findById(3).toString());
        pr.delete(2);
    }
}
