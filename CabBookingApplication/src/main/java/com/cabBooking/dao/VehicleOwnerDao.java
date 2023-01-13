package com.cabBooking.dao;

import com.cabBooking.model.Vehicle;
import com.cabBooking.model.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleOwnerDao extends JpaRepository<VehicleOwner, Long> {

    @Query("from VehicleOwner vo where vo.email=?1")
    VehicleOwner findVehicleOwnerByEmail(String email);

    @Query("from VehicleOwner vo where vo.phone=?1")
    VehicleOwner findVehicleOwnerByPhone(String phone);
}
