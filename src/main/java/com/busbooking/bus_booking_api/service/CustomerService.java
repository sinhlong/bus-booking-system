package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.entity.Customer;
import com.busbooking.bus_booking_api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Integer id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Integer id, Customer customer){
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if (existingCustomer == null) {
            return null;
        }

        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setCustomerNumberPhone(customer.getCustomerNumberPhone());
        existingCustomer.setCustomerGender(customer.getCustomerGender());
        existingCustomer.setCustomerAddress(customer.getCustomerAddress());

        return customerRepository.save(existingCustomer);
    }

    public boolean deleteCustomer(Integer id){

        if (!customerRepository.existsById(id)){
            return false;
        }

        customerRepository.deleteById(id);
        return true;
    }
}
