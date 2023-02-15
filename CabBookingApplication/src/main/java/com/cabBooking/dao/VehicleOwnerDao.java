package com.cabBooking.dao;

import com.cabBooking.model.Vehicle;
import com.cabBooking.model.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleOwnerDao extends JpaRepository<VehicleOwner, Long> {

    Optional<VehicleOwner> findByEmail(String email);
}
