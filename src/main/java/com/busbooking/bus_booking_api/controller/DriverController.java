package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.entity.Driver;
import com.busbooking.bus_booking_api.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/driver")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getAllDriver(){
        return driverService.getAllDriver();
    }

    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable Integer id){
        return driverService.getDriverById(id);
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver){
        return driverService.createDriver(driver);
    }

    @PutMapping("/{id}")
    public Driver updateDriver(
            @PathVariable Integer id,
            @RequestBody Driver driver
    ){
        return driverService.updateDriver(id,driver);
    }

    @DeleteMapping("/{id}")
    public  boolean deleteDriver(@PathVariable Integer id){
        return driverService.deleteDriver(id);
    }
}
