/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.dao;

import com.ph.customer.model.Customer;
import com.ph.customer.model.CustomerAddress;
import com.ph.users.model.User;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    public String insertCustomer(final Customer customer){
        Integer customerId = null;
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        /*Set<CustomerAddress> customerAddressSet = customer.getCustomerAddresses();
        Iterator<CustomerAddress> customerAddressIterator = customerAddressSet.iterator();
        while (customerAddressIterator.hasNext()){
            CustomerAddress customerAddress = customerAddressIterator.next();
            customer.getCustomerAddresses().add(customerAddress);
        }*/
        customerId = (Integer)session.save(customer);
        session.getTransaction().commit();
        return customerId.toString();
    }

    public List<Customer> findByPhoneNumber(final String contactNumber){

        List<Customer> customersList = new ArrayList<Customer>();

        return customersList = getSessionFactory().getCurrentSession().createQuery("from Customer where contactNumber=?")
                .setParameter(0, contactNumber).list();
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
