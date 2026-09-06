package com.busbooking.bus_booking_api.repository;

import com.busbooking.bus_booking_api.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
