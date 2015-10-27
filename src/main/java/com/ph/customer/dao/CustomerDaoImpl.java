/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.dao;

import com.ph.customer.model.Customer;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    private SessionFactory sessionFactory;

    public List<Customer> findCustomer(String firstName) {
        return null;
    }


    public Customer getCustomerDetail(String customerId) {
        List<Customer> customers = new ArrayList<Customer>();
        customers = getSessionFactory().getCurrentSession().createQuery("from Customer where customerId=?").setParameter(0,customerId).list();
        if(CollectionUtils.isNotEmpty(customers)){
            return customers.get(0);
        }
        return null;
    }

    public Customer getCustomerDetailsByContactNumber(String contactNumber) {
        return null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
