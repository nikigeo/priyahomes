/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.controller;

import com.ph.customer.facade.CustomerApiFacade;
import com.ph.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ph/customers")
public class CustomerController {

    @Autowired(required = true)
    private CustomerApiFacade customerApiFacade;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = {"application/json" })
    @ResponseBody
    public Customer getCustomer(@PathVariable final String customerId) {
        Customer customer = customerApiFacade.getCustomerById(customerId);
        return customer;
    }
}