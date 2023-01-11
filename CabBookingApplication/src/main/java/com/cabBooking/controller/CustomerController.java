package com.cabBooking.controller;

import com.cabBooking.model.Address;
import com.cabBooking.model.Customer;
import com.cabBooking.serviceLayer.address.AddressService;
import com.cabBooking.serviceLayer.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @PostMapping("/")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId){
        return new ResponseEntity<>(customerService.viewCustomer(customerId), HttpStatus.FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId){
        return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> addAddressToCustomer(@PathVariable("customerId") Long customerId, @RequestBody Address address){
        return new ResponseEntity<>(customerService.addAddressToCustomer(customerId, address), HttpStatus.ACCEPTED);
    }
}
