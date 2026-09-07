package com.busbooking.bus_booking_api.repository;

import com.busbooking.bus_booking_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
