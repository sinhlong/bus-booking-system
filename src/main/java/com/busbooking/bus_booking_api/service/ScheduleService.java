package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.entity.Bus;
import com.busbooking.bus_booking_api.entity.Driver;
import com.busbooking.bus_booking_api.entity.Route;
import com.busbooking.bus_booking_api.entity.Schedule;
import com.busbooking.bus_booking_api.repository.BusRepository;
import com.busbooking.bus_booking_api.repository.DriverRepository;
import com.busbooking.bus_booking_api.repository.RouteRepository;
import com.busbooking.bus_booking_api.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final RouteRepository routeRepository;
    private final BusRepository busRepository;
    private final DriverRepository driverRepository;



    public ScheduleService(
            ScheduleRepository scheduleRepository,
            RouteRepository routeRepository,
            BusRepository busRepository,
            DriverRepository driverRepository

    ){
        this.scheduleRepository = scheduleRepository;
        this.routeRepository = routeRepository;
        this.busRepository = busRepository;
        this.driverRepository = driverRepository;
    }

    public List<Schedule> getAllSchedule(){
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Integer id){
        return  scheduleRepository.findById(id).orElse(null);
    }

    public Schedule createSchedule(Schedule schedule){

        if(!setScheduleRelations(schedule)){
            return null;
        }

        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Integer id, Schedule schedule){
        Schedule existingSchedule = scheduleRepository.findById(id).orElse(null);

        if(existingSchedule == null){
            return null;
        }

        if(!setScheduleRelations(schedule)){
            return null;
        }

        existingSchedule.setRoute(schedule.getRoute());
        existingSchedule.setDriver(schedule.getDriver());
        existingSchedule.setBus(schedule.getBus());

        existingSchedule.setDepartDate(schedule.getDepartDate());
        existingSchedule.setDepartTime(schedule.getDepartTime());
        existingSchedule.setPrice(schedule.getPrice());
        existingSchedule.setArriveTime(schedule.getArriveTime());

        return scheduleRepository.save(existingSchedule);
    }

    public boolean deleteSchedule(Integer id){
        if(!scheduleRepository.existsById(id)){
            return false;
        }

        scheduleRepository.deleteById(id);
        return true;
    }

    private boolean setScheduleRelations(Schedule schedule){
        if (schedule.getDriver() == null ||
                schedule.getRoute() == null ||
                schedule.getBus() == null) {
            return false;
        }

        Driver driver = driverRepository
                .findById(schedule.getDriver().getDriverId())
                .orElse(null);

        Route route = routeRepository
                .findById(schedule.getRoute().getRouteId())
                .orElse(null);

        Bus bus = busRepository
                .findById(schedule.getBus().getBusId())
                .orElse(null);

        if (driver == null || route == null || bus == null) {
            return false;
        }

        schedule.setBus(bus);
        schedule.setDriver(driver);
        schedule.setRoute(route);

        return true;
    }
}

