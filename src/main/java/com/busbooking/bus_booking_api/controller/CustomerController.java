package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.entity.Customer;
import com.busbooking.bus_booking_api.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Integer id,
            @RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCustomer(@PathVariable Integer id){
        return customerService.deleteCustomer(id);
    }

}
