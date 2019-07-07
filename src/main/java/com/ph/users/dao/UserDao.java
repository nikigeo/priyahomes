package com.ph.users.dao;

import com.ph.customer.model.Customer;
import com.ph.users.model.User;

public interface UserDao {

	User findByUserName(String username);

}