/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.service;

import com.ph.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(final String customerId);

    String insertCustomer(final Customer customer);

    List<Customer> findByPhoneNumber(final String contactNumber);
}
