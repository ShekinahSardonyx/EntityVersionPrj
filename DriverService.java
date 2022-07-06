package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Driver;
import com.cg.repository.DriverRepository;
@Service
public class DriverService {

	@Autowired
	public DriverRepository driverRepository;
	
	public Driver addDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
	public List<Driver> removeDriver(int id){
		driverRepository.deleteById(id);
		return driverRepository.findAll();
	}
	
	public Driver updateDriver(int id, String mobNum) {
		Driver driver = driverRepository.findById(id).get();
		driver.setDriverMobileNumber(mobNum);
		driverRepository.flush();
		return driver;
	}
	
	public String AcceptOrRejectBooking(String message) {
		if(message.equals("Accept")) {
			return "Booking Accepted";
		}
		else {
			return "Booking Rejected";
		}
	}
	
}
