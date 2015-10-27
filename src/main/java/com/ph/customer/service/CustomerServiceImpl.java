/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.service;

import com.ph.customer.dao.CustomerDao;
import com.ph.customer.model.Customer;

public class CustomerServiceImpl implements CustomerService{

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    private CustomerDao customerDao;

    public Customer getCustomerById(final String customerId) {
        return getCustomerDao().getCustomerDetail(customerId);
    }
}
