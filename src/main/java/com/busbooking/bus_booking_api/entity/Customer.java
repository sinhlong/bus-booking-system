package com.busbooking.bus_booking_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column (name = "customer_name")
    private String customerName;

    @Column (name = "customer_number_phone")
    private String customerNumberPhone;

    @Column (name = "customer_gender")
    private String customerGender;

    @Column (name = "customer_address")
    private String customerAddress;

    public Customer(){

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumberPhone() {
        return customerNumberPhone;
    }

    public void setCustomerNumberPhone(String customerNumberPhone) {
        this.customerNumberPhone = customerNumberPhone;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
