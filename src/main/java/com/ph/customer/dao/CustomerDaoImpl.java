/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.dao;

import com.ph.customer.model.Customer;
import com.ph.customer.model.CustomerAddress;
import com.ph.users.model.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerDaoImpl implements CustomerDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public List<Customer> findCustomer(String firstName) {
        return null;
    }


    public Customer getCustomerDetail(String customerId) {
        List<Customer> customers = new ArrayList<Customer>();
        customers = sessionFactory.getCurrentSession().createQuery("from Customer where id=?").setParameter(0,Integer.parseInt(customerId)).list();
        if(CollectionUtils.isNotEmpty(customers)){
            return customers.get(0);
        }
        return null;
    }

    public String insertCustomer(final Customer customer){
        Integer customerId = null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        customerId = (Integer)session.save(customer);

        Set<CustomerAddress> customerAddressesSet = customer.getCustomerAddresses();
        if(!CollectionUtils.isEmpty(customerAddressesSet)){
            for (CustomerAddress customerAddress : customerAddressesSet){
                customerAddress.setCustomer(customer);
                session.save(customerAddress);
            }
        }

        session.getTransaction().commit();
        return customerId.toString();
    }

    public List<Customer> findByPhoneNumber(final String contactNumber){

        List<Customer> customersList = new ArrayList<Customer>();

        if(StringUtils.isNotEmpty(contactNumber)){
            customersList = sessionFactory.getCurrentSession().createQuery("from Customer where contactNumber like '"+contactNumber+"%'").setFetchSize(1).list();
        }

        //Below line should be removed after undertanding FETCH Mode
        for(Customer customer : customersList){
            customer.setCustomerAddresses(null);
        }

        return customersList;
    }

    public Customer getCustomerDetailsByContactNumber(String contactNumber) {
        return null;
    }



}
