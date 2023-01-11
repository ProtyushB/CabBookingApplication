package com.cabBooking.serviceLayer.customer;

import com.cabBooking.dao.CustomerDao;
import com.cabBooking.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer addCustomer(Customer customer) {
        Customer cust = null;

        //Checking With Email
        if (customer.getEmail()!=null){
            cust = customerDao.findCustomerByEmail(customer.getEmail());

            if (cust==null){
                cust = customerDao.save(customer);
            }
            else {
                // Customer With Email Already Exists
            }
        }

        //Checking With Phone
        if (customer.getPhone()!=null){
            cust = customerDao.findCustomerByPhone(customer.getPhone());

            if (cust==null){
                cust = customerDao.save(customer);
            }
            else {
                //Customer With Phone Already Exists
            }
        }

        return cust;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer cust = null;

        Optional<Customer> optionalCustomer = customerDao.findById(customer.getCustomerId());

        if (optionalCustomer.isPresent()){
            cust = customerDao.save(customer);
        }
        else{
            //Customer Not Exists
        }

        return cust;
    }

    @Override
    public Customer viewCustomer(Long customerId) {
        Customer cust = null;

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()) cust = optionalCustomer.get();
        else{
            //Customer Not Exists
        }

        return cust;
    }

    @Override
    public String deleteCustomer(Long customerId) {
        String msg = null;

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()){
            customerDao.deleteById(customerId);
            msg = "Customer Deleted Successfully";
        }
        else {
            //Customer Not Exists
        }
        return msg;
    }
}
