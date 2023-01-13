package com.cabBooking.dao;

import com.cabBooking.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle, Long> {

    @Query("from Vehicle v where v.regNo=?1")
    Vehicle findVehicleByRegNo(String regNo);
}
