package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Vehicle;
import com.cg.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	

	Vehicle vehicle = new Vehicle();

	public String addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		return "Vehicle Added Successfully";
	}
	
	public Vehicle updateVehicle(int vId, String type) {
		
		Vehicle vehicle = vehicleRepository.findById(vId).get();
		vehicle.setType(type);
		return vehicle;
	}
	
	public List<Vehicle> deleteVehicle(int vId){
		
		vehicleRepository.deleteById(vId);
		return vehicleRepository.findAll();
	}
	
	public double fixedChargesForCar(LocalDate d1, LocalDate d2) {
		double perDayCost = 2000.0;
		int numOfDays = d2.compareTo(d1);
		return perDayCost*numOfDays;
	}
	
	public double fixedChargesForBike(LocalDate d1, LocalDate d2) {
		double perDayCost = 500.0;
		int numOfDays = d2.compareTo(d1);
		return perDayCost*numOfDays;
	}
	
	public double fixedChargesForBicycle(LocalDate d1, LocalDate d2) {
		double perDayCost = 200.0;
		int numOfDays = d2.compareTo(d1);
		return perDayCost*numOfDays;
	}
	
	public double chargesPerKm(String type) {
		double d1 =0.0;
		if(type.equals("Car")) {
			d1 = 40.0;
		}
		else if(type.equals("Bike")) {
			d1 = 20.0;
		}
		else if(type.equals("Bicycle")) {
			d1 = 10.0;
		}
		return d1;
	}
	
		
}
