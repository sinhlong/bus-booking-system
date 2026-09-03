package com.busbooking.bus_booking_api.repository;


import com.busbooking.bus_booking_api.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
}
