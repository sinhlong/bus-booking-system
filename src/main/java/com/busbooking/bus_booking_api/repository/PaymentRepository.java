package com.busbooking.bus_booking_api.repository;

import com.busbooking.bus_booking_api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    boolean existsByBooking_BookingId(Integer bookingId);
}
