package com.vancuong.utils;

import com.vancuong.entity.ProductEntity;
import com.vancuong.entity.Student;
import com.vancuong.entity.TestTable;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("Hibernate.cfg.xml");
        configuration.addAnnotatedClass(ProductEntity.class);
        configuration.addAnnotatedClass(TestTable.class);
        configuration.addAnnotatedClass(Student.class);
        // thêm nhiều class dưới dây

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        return configuration.buildSessionFactory(registry);
    }
}
