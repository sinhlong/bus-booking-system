package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.entity.Bus;
import com.busbooking.bus_booking_api.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {
    private final BusRepository busRepository;

    public BusService(BusRepository busRepository){
        this.busRepository=busRepository;
    }

    public List<Bus>getAllBus(){
        return busRepository.findAll();
    }
}
