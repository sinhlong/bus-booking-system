package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.entity.Bus;
import com.busbooking.bus_booking_api.service.BusService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Bus getBusById(@PathVariable Integer id){
        return busService.getBusById(id);
    }

    @PostMapping
    public Bus createBus(@RequestBody Bus bus){
        return busService.createBus(bus);
    }

    @PutMapping("/{id}")
    public Bus updateBus(
            @PathVariable Integer id,
            @RequestBody Bus bus
    ){
        return busService.updateBus(id,bus);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id){
        return busService.deleteBus(id);
    }
}
