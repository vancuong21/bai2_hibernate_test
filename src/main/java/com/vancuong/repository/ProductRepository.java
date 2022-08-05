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
    public static ProductEntity saveOrUpdate(ProductEntity productEntity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(productEntity);

        session.getTransaction().commit();
        return productEntity;
    }

    // delete
    public static ProductEntity delete(ProductEntity productEntity) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        session.getTransaction().begin();
        session.delete(productEntity);

        session.getTransaction().commit();
        return productEntity;
    }

    public static List<ProductEntity> findAllProduct() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.createQuery("from ProductEntity ", ProductEntity.class)
                .getResultList();
    }
}
