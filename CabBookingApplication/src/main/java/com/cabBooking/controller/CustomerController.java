package com.cabBooking.controller;

import com.cabBooking.model.Address;
import com.cabBooking.model.Booking;
import com.cabBooking.model.Customer;
import com.cabBooking.serviceLayer.address.AddressService;
import com.cabBooking.serviceLayer.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> viewCustomer(@PathVariable("id") Long customerId){
        return new ResponseEntity<>(customerService.viewCustomer(customerId), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId){
        return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
    }







    @GetMapping("/allBookings/{id}")
    public ResponseEntity<List<Booking>> getALlBookings(@PathVariable("id") Long customerId){
        return new ResponseEntity<>(customerService.getAllBookings(customerId), HttpStatus.FOUND);
    }

    @GetMapping("/bookingHistory/{id}")
    public ResponseEntity<List<Booking>> getBookingHistory(@PathVariable("id") Long customerId){
        return new ResponseEntity<>(customerService.getBookingHistory(customerId), HttpStatus.FOUND);
    }

    @GetMapping("/activeBookings/{id}")
    public ResponseEntity<List<Booking>> getActiveBookings(@PathVariable("id") Long customerId){
        return new ResponseEntity<>(customerService.getActiveBookings(customerId), HttpStatus.FOUND);
    }

    @GetMapping("/upComingBookings/{id}")
    public ResponseEntity<List<Booking>> getUpComingBookings(@PathVariable("id") Long cutsomerId){
        return new ResponseEntity<>(customerService.getUpComingBookings(cutsomerId), HttpStatus.FOUND);
    }

}
