package com.cabBooking.dao;

import com.cabBooking.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends JpaRepository<Location, Long> {
}
