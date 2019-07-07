/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.facade;

import com.ph.customer.model.Customer;
import com.ph.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class CustomerApiFacadeImpl implements CustomerApiFacade {

    private CustomerService customerService;

    @Inject
    public CustomerApiFacadeImpl(final CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getCustomerById(final String customerId) {
        return customerService.getCustomerById(customerId);
    }

    public String insertCustomer(final Customer customer){
        return customerService.insertCustomer(customer);
    }

    public List<Customer> findByPhoneNumber(String contactNumber) {
        return customerService.findByPhoneNumber(contactNumber);
    }
}
