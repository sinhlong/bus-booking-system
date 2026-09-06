package com.busbooking.bus_booking_api.service;

import com.busbooking.bus_booking_api.entity.Booking;
import com.busbooking.bus_booking_api.entity.Payment;
import com.busbooking.bus_booking_api.repository.BookingRepository;
import com.busbooking.bus_booking_api.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public PaymentService(
            PaymentRepository paymentRepository,
            BookingRepository bookingRepository
    ) {
        this.paymentRepository = paymentRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Integer id) {
        return paymentRepository.findById(id).orElse(null);
    }

    private boolean setPaymentRelation(Payment payment) {

        if (payment.getBooking() == null) {
            return false;
        }

        Booking booking = bookingRepository
                .findById(payment.getBooking().getBookingId())
                .orElse(null);

        if (booking == null) {
            return false;
        }

        payment.setBooking(booking);

        return true;
    }

    private boolean isValidAmount(double totalAmount, double paidAmount) {

        if (totalAmount <= 0) {
            return false;
        }

        if (paidAmount < 0 || paidAmount > totalAmount) {
            return false;
        }

        return true;
    }

    private void setPaymentStatus(
            Payment payment,
            double totalAmount,
            double paidAmount
    ) {

        if (paidAmount == 0) {
            payment.setPaymentStatus("Unpaid");

        } else if (paidAmount < totalAmount) {
            payment.setPaymentStatus("Partial");

        } else {
            payment.setPaymentStatus("Paid");
        }
    }

    public Payment createPayment(Payment payment) {

        if (!setPaymentRelation(payment)) {
            return null;
        }

        double totalAmount = payment.getPaymentTotalAmount();
        double paidAmount = payment.getPaymentPaidAmount();

        if (!isValidAmount(totalAmount, paidAmount)) {
            return null;
        }

        setPaymentStatus(payment, totalAmount, paidAmount);

        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Integer id, Payment payment) {

        Payment existingPayment =
                paymentRepository.findById(id).orElse(null);

        if (existingPayment == null) {
            return null;
        }

        double totalAmount = payment.getPaymentTotalAmount();
        double paidAmount = payment.getPaymentPaidAmount();

        if (!isValidAmount(totalAmount, paidAmount)) {
            return null;
        }

        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        existingPayment.setPaymentTotalAmount(totalAmount);
        existingPayment.setPaymentPaidAmount(paidAmount);

        setPaymentStatus(
                existingPayment,
                totalAmount,
                paidAmount
        );

        return paymentRepository.save(existingPayment);
    }

    public boolean deletePaymentById(Integer id) {

        if (!paymentRepository.existsById(id)) {
            return false;
        }

        paymentRepository.deleteById(id);

        return true;
    }
}