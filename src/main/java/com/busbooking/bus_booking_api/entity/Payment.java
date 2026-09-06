package com.busbooking.bus_booking_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "payment_id")
    private Integer paymentId;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_total_amount")
    private double paymentTotalAmount;

    @Column(name = "payment_paid_amount")
    private double paymentPaidAmount;

    @Column(name = "payment_status")
    private String paymentStatus;

    public Payment(){

    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentTotalAmount() {
        return paymentTotalAmount;
    }

    public void setPaymentTotalAmount(double paymentTotalAmount) {
        this.paymentTotalAmount = paymentTotalAmount;
    }

    public double getPaymentPaidAmount() {
        return paymentPaidAmount;
    }

    public void setPaymentPaidAmount(double paymentPaidAmount) {
        this.paymentPaidAmount = paymentPaidAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


}
