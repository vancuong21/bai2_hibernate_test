package com.vancuong.main;

import com.vancuong.entity.*;
import com.vancuong.enumurations.ProductStatus;
import com.vancuong.repository.CategoryRepository;
import com.vancuong.repository.ProductRepository;
import com.vancuong.utils.HibernateUtils;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        Optional<CategoryEntity> category = CategoryRepository.findByName("Dien tu");
////        System.out.println(test);
//        List<ProductEntity> products = ProductRepository.findAllProduct();
//
//        for (ProductEntity product : products) {
//            if (category.isPresent()) {
//                product.setCategory(category.get());
//            }
//            ProductRepository.saveOrUpdate(product);
//            System.out.println(product);
//        }
        List<ProductEntity> products = ProductRepository.findByName("San pham 4");
        for (ProductEntity product : products) {
            System.out.println(product.getCategory().getName());
        }


//        Session session = HibernateUtils.getSessionFactory().openSession();
//        session.beginTransaction();
//        BillDetail billDetail = new BillDetail();
//        billDetail.setBullId(1);
//        billDetail.setQuantity(10);
//        billDetail.setProductPrice(99.99);
//        billDetail.setProductId(1);
//        session.saveOrUpdate(billDetail);
//        session.getTransaction().commit();

//        System.out.printf("%05d", 12);
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        session.beginTransaction();
//        for (int i = 0; i< 50; i++) {
//            Student testTable = new Student();
//            testTable.setName("st 1");
//            session.saveOrUpdate(testTable);
//        }
//        session.getTransaction().commit();

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
