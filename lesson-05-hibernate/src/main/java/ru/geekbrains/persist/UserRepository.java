package ru.geekbrains.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserRepository {

    private final EntityManagerFactory emFactory;
    private EntityManager em;

    public UserRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;

    }

    public List<User> findAll() {
        em = emFactory.createEntityManager();
//        em.getTransaction().begin();
        List<User> userList = em.createQuery("from User", User.class)
                .getResultList();
//        em.getTransaction().commit();
        em.close();
        return userList;
    }

    public User findById(long id) {
        em = emFactory.createEntityManager();

//        em.getTransaction().begin();
        User user = em.find(User.class, id);
//        em.getTransaction().commit();
        em.close();
        return user;
    }

    public void insert(User user) {
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public void update(User user) {
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        User userBD = em.find(User.class, user.getId());
        if (userBD != null) {
            em.merge(user);
        }
        em.getTransaction().commit();
        em.close();


    }

    public void delete(long id) {
        em = emFactory.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
        em.close();
    }

}
