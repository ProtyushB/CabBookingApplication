package com.cabBooking.dao;

import com.cabBooking.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {

    @Query("from Address a where a.country=?1 and a.state=?2 and a.city=?3 and a.pincode=?4  and a.streetName=?5 and a.buildingName=?6 and a.apartmentNumber=?7")
    Address findAddressByAllDetails(String country, String state, String city, String pincode, String streetName, String buildingName, String apartmentNumber);
}
