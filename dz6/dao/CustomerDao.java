package dz6.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import dz6.persist.Сustomer;


public class CustomerDao {

    private final EntityManagerFactory emFactory;

    public CustomerDao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public List<Сustomer> findAll() {
        return executeForEntityManager(
                em -> em.createNamedQuery("allCustomers", Сustomer.class).getResultList()
        );
    }

    public Сustomer findById(long id) {
        return executeForEntityManager(
                em -> em.find(Сustomer.class, id)
        );
    }

    public void insert(Сustomer customer) {
        executeInTransaction(em -> em.persist(customer));
    }

    public void update(Сustomer customer) {
        executeInTransaction(em -> em.merge(customer));
    }

    public void delete(long id) {
        executeInTransaction(em -> {
            Сustomer customer = em.find(Сustomer.class, id);
            if (customer != null) {
                em.remove(customer);
            }
        });
    }

    private <R> R executeForEntityManager(Function<EntityManager, R> function) {
        EntityManager em = emFactory.createEntityManager();
        try {
            return function.apply(em);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private void executeInTransaction(Consumer<EntityManager> consumer) {
        EntityManager em = emFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
