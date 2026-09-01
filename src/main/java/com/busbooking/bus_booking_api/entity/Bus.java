package com.busbooking.bus_booking_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @Column(name = "bus_id")
    private Integer busId;

    @Column(name = "bus_plate_no")
    private String busPlateNo;

    @Column(name = "bus_type")
    private String busType;

    @Column(name = "bus_total_seat")
    private Integer busTotalSeat;

    @Column(name = "bus_status")
    private String busStatus;

    public Bus() {

    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getBusPlateNo() {
        return busPlateNo;
    }

    public void setBusPlateNo(String busPlateNo) {
        this.busPlateNo = busPlateNo;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public Integer getBusTotalSeat() {
        return busTotalSeat;
    }

    public void setBusTotalSeat(Integer busTotalSeat) {
        this.busTotalSeat = busTotalSeat;
    }

    public String getBusStatus() {
        return busStatus;
    }

    public void setBusStatus(String busStatus) {
        this.busStatus = busStatus;
    }

}
