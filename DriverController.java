package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Driver;
import com.cg.service.BookingService;
import com.cg.service.DriverService;
import com.cg.service.PaymentService;

@RestController
public class DriverController {

	@Autowired 
	public DriverService driverService;
	@Autowired
	public BookingService bookingService;
	@Autowired
	public PaymentService paymentService;
	
	@PostMapping("/addDriver")
	public Driver addDriver(@RequestBody Driver driver) {
		return driverService.addDriver(driver);
	}
	@PutMapping("/updateDriverNum/{id}/{PhNo}")
	public Driver updateDriver(@PathVariable("id") int id,@PathVariable("PhNo") String phonenNum) {
		return driverService.updateDriver(id, phonenNum);
	}
	
	@DeleteMapping("/deleteDriver/{id}")
	public List<Driver> deleteDriver(@PathVariable("id") int id){
		return driverService.removeDriver(id);
	}
	
	
	@GetMapping("/acceptOrReject/{typeResponse}")
	public String AcceptOrRejectBooking(@PathVariable("typeResponse") String Response) {
		return driverService.AcceptOrRejectBooking(Response);
	}
	
}
