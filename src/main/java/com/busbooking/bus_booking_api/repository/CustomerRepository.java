package com.busbooking.bus_booking_api.repository;

import com.busbooking.bus_booking_api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
