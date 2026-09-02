package com.busbooking.bus_booking_api.repository;


import com.busbooking.bus_booking_api.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
}
