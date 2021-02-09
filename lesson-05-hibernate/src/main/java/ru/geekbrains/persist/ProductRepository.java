package ru.geekbrains.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductRepository {
    private final EntityManagerFactory emFactory;
    private EntityManager em;

    public ProductRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;

    }

    public List<Product> findAll() {
        em = emFactory.createEntityManager();
        List<Product> productList = em.createQuery("from Product", Product.class)
                .getResultList();
        em.close();
        return productList;
    }

    public Product findById(long id) {
        em = emFactory.createEntityManager();

        Product product = em.find(Product.class, id);
        em.close();
        return product;
    }

    public void insert(Product product) {
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Product product) {
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Product productBD = em.find(Product.class, product.getId());
        if (productBD != null) {
            em.merge(product);
        }
        em.getTransaction().commit();
        em.close();


    }

    public void delete(long id) {
        em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
        em.getTransaction().commit();
        em.close();
    }
}
