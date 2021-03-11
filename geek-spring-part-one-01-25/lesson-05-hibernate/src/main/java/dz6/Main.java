package dz6;

import dz6.persist.Product;
import dz6.persist.Сustomer;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernateDz6.cfg.xml")
                .buildSessionFactory();

    }

}
