package com.vancuong.main;

import com.vancuong.entity.ProductEntity;
import com.vancuong.entity.Student;
import com.vancuong.entity.TestTable;
import com.vancuong.enumurations.ProductStatus;
import com.vancuong.repository.ProductRepository;
import com.vancuong.utils.HibernateUtils;
import org.hibernate.Session;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
//        System.out.printf("%05d", 12);
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        for (int i = 0; i< 50; i++) {
            Student testTable = new Student();
            testTable.setName("st 1");
            session.saveOrUpdate(testTable);
        }
        session.getTransaction().commit();

        // student generator
        // Session session = HibernateUtils.getSessionFactory().openSession();
        // session.beginTransaction();
        // Student testTable = new Student();
        // testTable.setName("st 1");
        // session.saveOrUpdate(testTable);
        // session.getTransaction().commit();

        // TestTable
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        session.beginTransaction();
//        for (int i = 0; i < 50; i++) {
//            TestTable testTable = new TestTable();
//            testTable.setName("ok " + i);
//            testTable.setName("ok " + i);
//            session.saveOrUpdate(testTable); // persist
//        }
//        session.getTransaction().commit();

        // System.out.println(UUID.randomUUID());
        // testInsert();
        // testSelectAndUpdate();
        // testSelectAndDelete();

        // List<Product> result = ProductRepository.findByName("san pham 1");
        // for (Product product : result) {
        // System.out.println(result);
        // }
        // }
    }

    public static void testSelectAndDelete() {
        ProductEntity product = ProductRepository.findById(4);
        if (product != null) {
            ProductRepository.delete(product);
        }
    }

    public static void testSelectAndUpdate() {
        ProductEntity product = ProductRepository.findById(4);
        if (product != null) {
            product.setName("test enum");
            product.setStatus(ProductStatus.INACTIVE);
            ProductRepository.saveOrUpdate(product);
        }
    }

    public static void testInsert() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.getTransaction().begin();

        ProductEntity product = new ProductEntity();

        product.setName("San pham 1");
        product.setPrice(99.999);
        product.setCreateDate(LocalDateTime.now());
        product.setUpdateDate(LocalDateTime.now());

        // session.save(product);
        session.saveOrUpdate(product); // lưu các đối tượng thực thể

        session.getTransaction().commit();
    }
}
