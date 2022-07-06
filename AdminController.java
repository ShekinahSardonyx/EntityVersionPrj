package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Admin;
import com.cg.entity.Booking;
import com.cg.entity.Customer;
import com.cg.entity.Payment;
import com.cg.entity.Vehicle;
import com.cg.service.AdminService;
import com.cg.service.BookingService;
import com.cg.service.CustomerService;
import com.cg.service.PaymentService;
import com.cg.service.VehicleService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private VehicleService vehicleService;
	
	
	@Autowired
    public CustomerService customerService;
	
	@Autowired
	public PaymentService paymentService;
	
	@Autowired
	private BookingService bookingService;
	
	
	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@PutMapping("/updateAdminPassword/{id}/{pwd}")
	public Admin updateAdminPassword(@PathVariable("id") int adminId, @PathVariable("pwd") String newPwd) {
		return adminService.updateAdminPassword(adminId, newPwd);
	}
	
	@PutMapping("/updateAdminName/{id}/{firstName}")
	public Admin updateAdminName(@PathVariable("id") int adminId, @PathVariable("firstName") String firstName) {
		return adminService.updateAdminName(adminId, firstName);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public List<Admin> deleteAdmin(@PathVariable("id") int adminId){
		return adminService.deleteAdmin(adminId);
	}
	
	@PostMapping("/addVehicle")
	public String addVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.addVehicle(vehicle);
	}
	
	@PutMapping("/updateVehicle/{id}/{type}")
	public Vehicle updateVehicle(@PathVariable("id") int vId, @PathVariable("type") String newType) {
		return vehicleService.updateVehicle(vId, newType);
	}
	
	@DeleteMapping("/deleteVehicle/{id}")
	public List<Vehicle> deleteVehicle(@PathVariable("id") int vId){
		return vehicleService.deleteVehicle(vId);
	}
    
    @PostMapping("/addCustomer/{customer}")
	public String addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
		
	}
	@PutMapping("/update/{customerId}/{customerMobileNumber}")
	public Customer updateCustomer(@PathVariable("customerId") int customerId,@PathVariable("customerMobileNumber") String customerMobileNumber){
		return customerService.updateCustomer(customerId, customerMobileNumber);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public List<Customer> deleteCustomer(@PathVariable ("customerId") int customerId) {
		return customerService.removeCustomer(customerId);
	}
	
	
	@GetMapping("/ViewAllCustomers")
	public List<Customer> ViewAllCustomers() {
		return customerService.viewAllCustomer();
	}
	
	@GetMapping("/getAllCustomersAddress")
	public List<Customer> getAllCustomers(String location){
		return customerService.viewAllCustomersByLocation(location);
	}
	

	@PutMapping("/update/{paymentId}/{mode}")
	public Payment updatePaymentMode(@PathVariable("paymentId")int paymentId, @PathVariable("mode") String mode){
		return paymentService.updatePaymentMode(paymentId, mode);
	}
	
	@PutMapping("/update/{paymentId}/{date}")
	public Payment updatePaymentDate(@PathVariable("paymentId")int paymentId, @PathVariable("date") LocalDate date){
		return paymentService.updatePaymentDate(paymentId, date);
	}
	
	@PutMapping("/update/{paymentId}/{status}")
	public Payment updatePaymentStatus(@PathVariable("paymentId")int paymentId, @PathVariable("status") String status){
		return paymentService.updatePaymentStatus(paymentId, status);
	}
	
	@GetMapping("/viewAllPayments")
	public List<Payment> ViewAllCustomer(){
		return paymentService.viewAllPayments();
   }

	@GetMapping("/calculateTotalPayment/{type}/{date1}/{date2}")
	public double calculateTotalPay(@PathVariable("type") String type , @PathVariable("date1") LocalDate date1, @PathVariable("date2") LocalDate date2) {
		return paymentService.CalculateTotalPayment(type, date1, date2);
	}
	
	
	@PutMapping("/updateByDate/{id}/{date}")
	public Booking updateBookingFromDate(@PathVariable ("id") int bookingId,@PathVariable("date") LocalDate bookingDate) {
		return bookingService.updateBookingFromDate(bookingId, bookingDate);
		
	}


	@PutMapping("/updateByTillDate/{id}/{date}")
	public Booking updateBookingTillDate(@PathVariable ("id") int bookingId,@PathVariable("date") LocalDate bookedTillDate) {
		return bookingService.updateBookingTillDate(bookingId, bookedTillDate);
		
	}

	@PutMapping("/updateDistance/{id}/{distance}")
	public Booking updatedistance(@PathVariable ("id") int bookingId,@PathVariable("distance") double distance) {
		return bookingService.updatedistance(bookingId, distance);
		
	}

	@PutMapping("/updateCost/{id}/{cost}")
	public Booking updatecost(@PathVariable ("id") int bookingId,@PathVariable("cost") double totalcost) {
		return bookingService.updatecost(bookingId, totalcost);
		
	}
	
    @GetMapping("/viewAllBooking")
    public List<Booking> viewAllBooking() {
    	return bookingService.viewAllBookings();
    }
    
    
    @GetMapping("/viewAllBookingByDate/{date}")
    public List<Booking> viewAllBookingByDate(@PathVariable ("date")LocalDate bookingDate) {
    	return bookingService.viewAllBookingByDate(bookingDate);
    }
    
}
