package com.busbooking.bus_booking_api.controller;

import com.busbooking.bus_booking_api.entity.Payment;
import com.busbooking.bus_booking_api.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAllPayment(){
        return paymentService.getAllPayment();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Integer id){
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Integer id,@RequestBody Payment payment){
        return paymentService.updatePayment(id, payment);
    }

    @DeleteMapping("/{id}")
    public  boolean deleteById(@PathVariable Integer id){
        return paymentService.deletePaymentById(id);
    }
}
