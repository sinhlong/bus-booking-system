package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.entity.Driver;
import com.busbooking.bus_booking_api.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private  final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository){
        this.driverRepository =driverRepository;
    }

    public List<Driver>getAllDriver(){
        return driverRepository.findAll();
    }

    public Driver getDriverById(Integer id ){
        return driverRepository.findById(id).orElse(null);
    }

    public Driver createDriver(Driver driver){
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Integer id,Driver driver){
        Driver existingDriver = driverRepository.findById(id).orElse(null);

        if(existingDriver == null){
            return null;
        }

        existingDriver.setDriverName(driver.getDriverName());
        existingDriver.setDriverNumberPhone(driver.getDriverNumberPhone());
        existingDriver.setDriverLicenseNo(driver.getDriverLicenseNo());
        existingDriver.setDriverExperience(driver.getDriverExperience());
        existingDriver.setDriverAddress(driver.getDriverAddress());

        return driverRepository.save(existingDriver);
    }

    public boolean deleteDriver(Integer id){
        if(!driverRepository.existsById(id)){
            return false;
        }

        driverRepository.deleteById(id);
        return true;
    }
}
