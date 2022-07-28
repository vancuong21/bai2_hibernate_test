package com.vancuong.repository;

import com.vancuong.entity.ProductEntity;
import com.vancuong.utils.HibernateUtils;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductRepository {

    // tim theo name
    public static List<ProductEntity> findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<ProductEntity> query = session.createQuery("FROM ProductEntity WHERE name = :productName", ProductEntity.class);
        query.setParameter("productName", name);
        try {
            return query.getResultList();
        } catch (NoResultException exception) {
            return null;
        }

    }

    // tim kiem id
    public static ProductEntity findById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().openSession();

        return session.find(ProductEntity.class, id);
    }

    // save or update
    public static ProductEntity saveOrUpdate(ProductEntity product) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(product);

        session.getTransaction().commit();
        return product;
    }

    // delete
    public static ProductEntity delete(ProductEntity product) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(product);
        session.getTransaction().commit();
        return product;
    }
}
