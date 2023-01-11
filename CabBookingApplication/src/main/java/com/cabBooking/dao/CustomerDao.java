package com.cabBooking.dao;

import com.cabBooking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    @Query("from Customer where phone=?1")
    Customer findCustomerByPhone(String phone);

    @Query("from Customer where email=?1")
    Customer findCustomerByEmail(String email);
}
