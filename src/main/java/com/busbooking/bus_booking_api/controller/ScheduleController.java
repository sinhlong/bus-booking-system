package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.entity.Schedule;
import com.busbooking.bus_booking_api.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> getAllSchedule(){
        return scheduleService.getAllSchedule();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Integer id){
        return scheduleService.getScheduleById(id);
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule){
        return scheduleService.createSchedule(schedule);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(
            @PathVariable Integer id,
            @RequestBody Schedule schedule
    ){
        return scheduleService.updateSchedule(id,schedule);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id){
        return scheduleService.deleteSchedule(id);
    }
}
