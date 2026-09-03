package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.entity.Booking;
import com.busbooking.bus_booking_api.entity.Customer;
import com.busbooking.bus_booking_api.entity.Schedule;
import com.busbooking.bus_booking_api.repository.BookingRepository;
import com.busbooking.bus_booking_api.repository.CustomerRepository;
import com.busbooking.bus_booking_api.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final ScheduleRepository  scheduleRepository;

    public BookingService(BookingRepository bookingRepository, CustomerRepository customerRepository, ScheduleRepository scheduleRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Integer id){
        return bookingRepository.findById(id).orElse(null);
    }

    private boolean setBookingRelations(Booking booking){
        if(booking.getCustomer()==null ||
                booking.getSchedule()==null
        ){
            return false;
        }

        Customer customer = customerRepository
                .findById(booking.getCustomer().getCustomerId())
                .orElse(null);

        Schedule schedule = scheduleRepository
                .findById(booking.getSchedule().getScheduleId())
                .orElse(null);

        if(customer == null || schedule == null){
            return false;
        }

        booking.setCustomer(customer);
        booking.setSchedule(schedule);

        return true;
    }

    public Booking createBooking(Booking booking){
        if(!setBookingRelations(booking)){
            return null;
        }

        boolean seatAlreadyBooking =
                bookingRepository.existsBySchedule_ScheduleIdAndBookingSeatNo(
                        booking.getSchedule().getScheduleId(),
                        booking.getBookingSeatNo()
                );

        if(seatAlreadyBooking){
            return null;
        }
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Integer id , Booking booking){
        Booking existingBooking = bookingRepository.findById(id).orElse(null);

        if(existingBooking == null){
           return null;
        }

        if(!setBookingRelations(booking)){
            return null;
        }

        boolean seatAlreadyBooking =
                bookingRepository
                        .existsBySchedule_ScheduleIdAndBookingSeatNoAndBookingIdNot(
                                booking.getSchedule().getScheduleId(),
                                booking.getBookingSeatNo(),
                                id
                        );

        if(seatAlreadyBooking){
            return null;
        }
        existingBooking.setSchedule(booking.getSchedule());
        existingBooking.setCustomer(booking.getCustomer());

        existingBooking.setBookingSeatNo(booking.getBookingSeatNo());
        existingBooking.setBookingStatus(booking.getBookingStatus());

        return bookingRepository.save(existingBooking);
    }

    public boolean deleteById(Integer id){
        if(!bookingRepository.existsById(id)){
            return false;
        }

        bookingRepository.deleteById(id);
        return true;
    }
}
