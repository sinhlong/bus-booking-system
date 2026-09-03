package com.busbooking.bus_booking_api.repository;

import com.busbooking.bus_booking_api.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,Integer> {
}
