/*
 * Copyright (c) Priya homes.
 */

package com.ph.customer.facade;

import com.ph.customer.model.Customer;

public interface CustomerApiFacade {
Customer getCustomerById(final String customerId);
}
