package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.entity.Booking;
import com.busbooking.bus_booking_api.entity.Ticket;
import com.busbooking.bus_booking_api.repository.BookingRepository;
import com.busbooking.bus_booking_api.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final BookingRepository bookingRepository;

    public TicketService(
            TicketRepository ticketRepository,
            BookingRepository bookingRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Integer id) {
        return ticketRepository.findById(id).orElse(null);
    }

    private boolean setTicketRelation(Ticket ticket) {

        if (ticket.getBooking() == null) {
            return false;
        }

        Booking booking = bookingRepository
                .findById(ticket.getBooking().getBookingId())
                .orElse(null);

        if (booking == null) {
            return false;
        }

        ticket.setBooking(booking);

        return true;
    }

    public Ticket createTicket(Ticket ticket) {

        if (!setTicketRelation(ticket)) {
            return null;
        }

        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Integer id, Ticket ticket) {

        Ticket existingTicket =
                ticketRepository.findById(id).orElse(null);

        if (existingTicket == null) {
            return null;
        }

        if (!setTicketRelation(ticket)) {
            return null;
        }

        existingTicket.setBooking(ticket.getBooking());
        existingTicket.setTicketNumber(ticket.getTicketNumber());
        existingTicket.setTicketQrCode(ticket.getTicketQrCode());

        return ticketRepository.save(existingTicket);
    }

    public boolean deleteTicketById(Integer id) {

        if (!ticketRepository.existsById(id)) {
            return false;
        }

        ticketRepository.deleteById(id);

        return true;
    }
}