package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.entity.Ticket;
import com.busbooking.bus_booking_api.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAllTicket() {
        return ticketService.getAllTicket();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Integer id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(
            @PathVariable Integer id,
            @RequestBody Ticket ticket
    ) {
        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTicketById(@PathVariable Integer id) {
        return ticketService.deleteTicketById(id);
    }
}