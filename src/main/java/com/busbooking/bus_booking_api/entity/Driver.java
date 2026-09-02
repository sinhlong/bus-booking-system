package com.busbooking.bus_booking_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "driver_number_phone")
    private String driverNumberPhone;

    @Column (name = "driver_license_no")
    private String driverLicenseNo;

    @Column (name = "driver_experience")
    private String driverExperience;

    @Column (name = "driver_address")
    private String driverAddress;

    public Driver(){

    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverNumberPhone() {
        return driverNumberPhone;
    }

    public void setDriverNumberPhone(String driverNumberPhone) {
        this.driverNumberPhone = driverNumberPhone;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getDriverExperience() {
        return driverExperience;
    }

    public void setDriverExperience(String driverExperience) {
        this.driverExperience = driverExperience;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }
}
