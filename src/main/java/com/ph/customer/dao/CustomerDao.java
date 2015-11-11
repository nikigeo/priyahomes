package com.ph.customer.dao;

import com.ph.customer.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findCustomer(final String firstName);
    Customer getCustomerDetail(final String customerId);
    Customer getCustomerDetailsByContactNumber(final String contactNumber);
    String insertCustomer(final Customer customer);
    List<Customer> findByPhoneNumber(final String contactNumber);
}
