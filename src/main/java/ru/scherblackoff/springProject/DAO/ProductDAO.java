package ru.scherblackoff.springProject.DAO;

import ru.scherblackoff.springProject.models.Product;
import ru.scherblackoff.springProject.utils.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDAO {


    public Product findById(int id){
        return EntityManagerFactoryUtil.getEntityManager().createQuery(
                "FROM Product WHERE id =" + id, Product.class
        ).getSingleResult();
    }

    public void save(Product product) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    /*public void delete(Product product) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
        em.close();
    }*/


    public List<Product> findAll() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        List<Product> products = em.createQuery("FROM Product", Product.class).getResultList();
        return products;
    }
}
