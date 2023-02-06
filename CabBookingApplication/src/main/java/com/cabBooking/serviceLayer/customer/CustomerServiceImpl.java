package com.cabBooking.serviceLayer.customer;

import com.cabBooking.dao.AddressDao;
import com.cabBooking.dao.CustomerDao;
import com.cabBooking.model.Address;
import com.cabBooking.model.Booking;
import com.cabBooking.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

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

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()) customerDao.deleteById(customerId);
        else {
            //Customer Not Exists
        }
        return "Customer Deleted Successfully";
    }






    @Override
    public String newBooking(Booking booking) {
        return null;
    }

    @Override
    public String deleteBookingFromCustomer(Long bookingId) {
        return null;
    }







    @Override
    public List<Booking> getAllBookings(Long CustomerId) {
        return null;
    }

    @Override
    public List<Booking> getBookingHistory(Long customerId) {
        return null;
    }

    @Override
    public List<Booking> getActiveBookings(Long customerId) {
        return null;
    }

    @Override
    public List<Booking> getUpComingBookings(Long customerId) {
        return null;
    }

}
