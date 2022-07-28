package com.vancuong.entity.generator;

import com.vancuong.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.Year;

public class StudentGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        session.createNativeQuery("update studentSeq set next_val = next_val + 1;")
                .executeUpdate();
        Number nextVal = (Number) session.createNativeQuery("select next_val from studentSeq")
                .getSingleResult();
        session.getTransaction().commit();
//        System.out.println(nextVal);
        String stt = String.format("%05d", nextVal.intValue());
//        return "S202200001";
        return "S" + Year.now() + stt;
    }
}