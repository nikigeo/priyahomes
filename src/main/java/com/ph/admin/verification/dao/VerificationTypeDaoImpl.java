/*
 * Copyright (c) Priya homes.
 */

package com.ph.admin.verification.dao;

import com.ph.admin.verification.model.VerificationType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VerificationTypeDaoImpl implements VerificationTypeDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public Integer insertVerificationType(VerificationType verificationType) {
        Integer customerVerificationNumber = null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        customerVerificationNumber = (Integer)session.save(verificationType);
        session.getTransaction().commit();
        return customerVerificationNumber;
    }

    public List<VerificationType> getAllVerificationTypes() {

        return sessionFactory.getCurrentSession().createQuery("from VerificationType").list();
    }
}
