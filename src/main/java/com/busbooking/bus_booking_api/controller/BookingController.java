package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.entity.Booking;
import com.busbooking.bus_booking_api.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Integer id){
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBookingById(
            @PathVariable Integer id,
            @RequestBody Booking booking
    ){
        return bookingService.updateBooking(id,booking);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id){
        return bookingService.deleteById(id);
    }
}
