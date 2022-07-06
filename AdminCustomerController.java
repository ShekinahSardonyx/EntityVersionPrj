package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Booking;
import com.cg.entity.Payment;
import com.cg.service.BookingService;
import com.cg.service.CustomerService;
import com.cg.service.PaymentService;

@RestController
public class AdminCustomerController {

	@Autowired
	public PaymentService paymentService;

	@Autowired
	public BookingService bookingService;

	@Autowired
	public CustomerService customerService;

	@PostMapping("/addPayment/{payment}")
	public String addPayment(@RequestBody Payment payment) {
		return paymentService.addPayment(payment);
	}
	
	@PostMapping("/addbooking")
	public Booking addBooking(@RequestBody  Booking b) {
		return bookingService.addBooking(b);
	}

	@DeleteMapping("/CancelBooking/{id}")
	public String cancelBooking(@PathVariable("id") int bookingId) {
		return bookingService.cancelBooking(bookingId);
	}

	@DeleteMapping("/deletePayment/{paymentId}")
	public String deletePayment(@PathVariable("PaymentId")int paymentId){
		return paymentService.cancelPayment(paymentId);
	}
}
