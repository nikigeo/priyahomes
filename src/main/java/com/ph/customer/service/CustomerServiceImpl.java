/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.service;

import com.ph.customer.dao.CustomerDao;
import com.ph.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired(required = true)
    private CustomerDao customerDao;


    public Customer getCustomerById(final String customerId) {
        return customerDao.getCustomerDetail(customerId);
    }

    public String insertCustomer(final Customer customer){
        return customerDao.insertCustomer(customer);
    }

    public List<Customer> findByPhoneNumber(String contactNumber) {
        return customerDao.findByPhoneNumber(contactNumber);
    }
}
