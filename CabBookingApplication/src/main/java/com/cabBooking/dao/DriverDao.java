package com.cabBooking.dao;

import com.cabBooking.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDao extends JpaRepository<Driver, Long> {

    @Query("from Driver d where d.email=?1")
    Driver findDriverByEmail(String email);

    @Query("from  Driver d where d.phone=?1")
    Driver findDriverByPhone(String phone);
}
