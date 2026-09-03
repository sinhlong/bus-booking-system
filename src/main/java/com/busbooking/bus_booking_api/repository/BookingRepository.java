package com.busbooking.bus_booking_api.repository;

import com.busbooking.bus_booking_api.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

    boolean existsBySchedule_ScheduleIdAndBookingSeatNo(
            Integer scheduleId,
            String bookingSeatNo
    );

    boolean existsBySchedule_ScheduleIdAndBookingSeatNoAndBookingIdNot(
            Integer scheduleId,
            String bookingSeatNo,
            Integer bookingId
    );
}
