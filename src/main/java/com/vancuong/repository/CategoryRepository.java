package com.vancuong.repository;

import com.vancuong.entity.CategoryEntity;
import com.vancuong.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class CategoryRepository {
    public static Optional<CategoryEntity> findByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query<CategoryEntity> query = session.createQuery("FROM CategoryEntity WHERE name = :name", CategoryEntity.class)
                .setParameter("name", name);

        return query.getResultStream().findFirst();
    }
}
