package com.cabBooking.dao;

import com.cabBooking.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverDao extends JpaRepository<Driver, Long> {

    Optional<Driver> findByEmail(String email);
}
