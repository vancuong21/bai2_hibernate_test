package com.vancuong.utils;

import com.vancuong.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    public static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory != null) {
            return sessionFactory;
        }

        Configuration configuration = new Configuration();
        configuration.configure("Hibernate.cfg.xml");
        configuration.addAnnotatedClass(ProductEntity.class);
        configuration.addAnnotatedClass(TestTable.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(BillDetail.class);
        configuration.addAnnotatedClass(CategoryEntity.class);
        // thêm nhiều class dưới dây

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        sessionFactory = configuration.buildSessionFactory(registry);
        return sessionFactory;
    }
}
