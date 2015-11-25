/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.controller;

import com.ph.customer.facade.CustomerApiFacade;
import com.ph.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("v1/ph/customers")
public class CustomerController {

    @Autowired(required = true)
    private CustomerApiFacade customerApiFacade;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = {"application/json" })
    @ResponseBody
    public Customer getCustomer(@PathVariable final String customerId) {
        Customer customer = customerApiFacade.getCustomerById(customerId);
        return customer;
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json" })
    @ResponseBody
    public ModelAndView createEmployee(@RequestBody Customer  customer)
    {
        customerApiFacade.insertCustomer(customer);
        ModelAndView model = new ModelAndView();
        model.setViewName("homepage");
        return model;
    }

    @RequestMapping(value = "/findByPhoneNumber/{customerPhoneNumber}", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> findByPhoneNumber(@PathVariable String customerPhoneNumber)
    {
        List<Customer> customerList =  customerApiFacade.findByPhoneNumber(customerPhoneNumber);
        return customerList;
    }


}