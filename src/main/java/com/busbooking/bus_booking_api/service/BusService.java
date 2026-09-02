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

    public Bus getBusById(Integer id){
        return busRepository.findById(id).orElse(null);
    }

    public Bus createBus(Bus bus){
        return busRepository.save(bus);
    }

    public Bus updateBus(Integer id,Bus bus){
        Bus existingBus = busRepository.findById(id).orElse(null);

        if(existingBus == null){
            return null;
        }

        existingBus.setBusPlateNo(bus.getBusPlateNo());
        existingBus.setBusType(bus.getBusType());
        existingBus.setBusStatus(bus.getBusStatus());
        existingBus.setBusTotalSeat(bus.getBusTotalSeat());

        return busRepository.save(existingBus);
    }

    public boolean deleteBus(Integer id){

        if(!busRepository.existsById(id)){
            return false;
        }

        busRepository.deleteById(id);
        return true;
    }
}
