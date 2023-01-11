package com.cabBooking.serviceLayer.customer;

import com.cabBooking.model.Address;
import com.cabBooking.model.Customer;
import org.springframework.stereotype.Service;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer viewCustomer(Long customerId);
    String deleteCustomer(Long customerId);
    Customer addAddressToCustomer(Long customerId, Address address);
}
