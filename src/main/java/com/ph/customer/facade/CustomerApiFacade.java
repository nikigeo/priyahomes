/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.facade;

import com.ph.customer.model.Customer;

import java.util.List;

public interface CustomerApiFacade {

    Customer getCustomerById(final String customerId);
    String insertCustomer(final Customer customer);
    List<Customer> findByPhoneNumber(final String contactNumber);
}
