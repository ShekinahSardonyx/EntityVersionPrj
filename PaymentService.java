package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Payment;
import com.cg.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository ;
	
	@Autowired
	private VehicleService vehicleService;
	
	public String addPayment(Payment payment)
	{
		paymentRepository.save(payment);
		return"payment added succesfully";
		
	}
	public String cancelPayment(int id) {
		paymentRepository.deleteById(id);
		return "payment cancelled sucessfully";
	}
	
	public Payment updatePaymentMode(int id, String paymentMode) {
		Payment p=paymentRepository.findById(id).get();
		p.setPaymentMode(paymentMode);;
		paymentRepository.flush();
		return p;
	}
	
	public Payment updatePaymentDate(int id, LocalDate paymentDate) {
		Payment p=paymentRepository.findById(id).get();
		p.setPaymentDate(paymentDate);
		paymentRepository.flush();
		return p;
	}
	
	public Payment updatePaymentStatus(int id, String paymentStatus) {
		Payment p=paymentRepository.findById(id).get();
		p.setPaymentStatus(paymentStatus);
		paymentRepository.flush();
		return p;
	}
	
	public Payment viewpayment( int id ) {
		return  paymentRepository.findById(id).get();	 
	}
	
	public List<Payment> viewAllPayments (){
		return paymentRepository.findAll();
		
	}
	
	public String getpaymentStatus(int paymentId) {
		
		String message ="";
		if(paymentRepository.existsById(paymentId)) {
			message ="Payment Done Successfully";
		}
		else {
			message="Payment Failed";
		}
		return message;
	}
	
	public double calculateMonthlyPayment(String type, String role, LocalDate d1, LocalDate d2) {
		
		double payment=0.0;
		
		if(type.equals("Car")) {
			double totalPayment = vehicleService.fixedChargesForCar(d1, d2);
			if(role.equals("Admin")) {
				payment = totalPayment * 0.75;
			}
			else if(role.equals("Driver")) {
				payment = totalPayment * 0.25;
			}
		}
		else if(type.equals("Bike")) {
			double totalPayment = vehicleService.fixedChargesForBike(d1, d2);
			
			if(role.equals("Admin")) {
				payment = totalPayment * 0.75;
			}
			else if(role.equals("Driver")) {
				payment = totalPayment * 0.25;
			}
		}
		
		else if(type.equals("Bicycle")) {
			double totalPayment = vehicleService.fixedChargesForBicycle(d1, d2);
			
			if(role.equals("Admin")) {
				payment = totalPayment * 0.75;
			}
			else if(role.equals("Driver")) {
				payment = totalPayment * 0.25;
			}
		}
		return payment;	
	}

	public double CalculateTotalPayment(String type, LocalDate d1, LocalDate d2) {
		double totalPayment=0.0;
		if(type.equals("Car")) {
			totalPayment = vehicleService.fixedChargesForCar(d1, d2);
		}
		else if(type.equals("Bike")) {
			totalPayment = vehicleService.fixedChargesForBike(d1, d2);
		}
		else if(type.equals("Bicycle")) {
			totalPayment = vehicleService.fixedChargesForBicycle(d1, d2);
		}
		return totalPayment;
	}
		
}

	