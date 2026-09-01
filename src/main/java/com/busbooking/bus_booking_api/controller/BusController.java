package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.entity.Bus;
import com.busbooking.bus_booking_api.service.BusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/bus")
public class BusController {
    private final BusService busService;

    public BusController(BusService busService){
        this.busService = busService;
    }

    @GetMapping
    public List<Bus> getAllBus(){
        return busService.getAllBus();
    }


}
