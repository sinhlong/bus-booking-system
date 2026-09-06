package com.busbooking.bus_booking_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    private Integer ticketId;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "ticket_qr_code")
    private String ticketQrCode;

    public Ticket() {
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketQrCode() {
        return ticketQrCode;
    }

    public void setTicketQrCode(String ticketQrCode) {
        this.ticketQrCode = ticketQrCode;
    }
}