package com.cabBooking.serviceLayer.customer;

import com.cabBooking.model.Address;
import com.cabBooking.model.Booking;
import com.cabBooking.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer viewCustomer(Long customerId);
    String deleteCustomer(Long customerId);

    String newBooking();
    String deleteBookingFromCustomer();

    List<Booking> getAllBookings(Long CustomerId);
    List<Booking> getBookingHistory(Long customerId);
    List<Booking> getActiveBookings(Long customerId);
    List<Booking> getUpComingBookings(Long customerId);
}
