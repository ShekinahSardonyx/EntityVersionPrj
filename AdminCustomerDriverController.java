package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Booking;
import com.cg.entity.Customer;
import com.cg.entity.Payment;
import com.cg.service.BookingService;
import com.cg.service.CustomerService;
import com.cg.service.PaymentService;

@RestController
public class AdminCustomerDriverController {

	@Autowired
	public BookingService bookingService;
	
	@Autowired
	public PaymentService paymentService;
	
	@Autowired
	public CustomerService customerService;
	
	@GetMapping("/viewBooking/{id}")
    public Booking viewBooking(@PathVariable ("id") int bookingId) {
    	return bookingService.viewBooking(bookingId);
    }
	
	@GetMapping("/View/{paymentId/{Status}")
	public Payment viewPaymentStatus(@PathVariable("paymentId") int paymentId, @PathVariable("status") String status) {
		return paymentService.updatePaymentStatus(paymentId, status);
	}
	
	@GetMapping("/ViewCustomer/{customerId}")
	public Customer viewCustomer(@PathVariable("customerId") int customerId) {
		return customerService.viewCustomer(customerId);
	}
}
