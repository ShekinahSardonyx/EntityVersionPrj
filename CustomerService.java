package com.cg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.User;
import com.cg.repository.CustomerRepository;
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public String addCustomer(Customer customer) {
		User user = new User();
		if(user.getRole().equals("Customer")) {
			customerRepository.save(customer);
			return "Customer added successfully";
		}
		return "Not a customer";
		
	}
	
	public List<Customer> removeCustomer(int id) {
		customerRepository.deleteById(id);
		return customerRepository.findAll();
		
	}
	public Customer viewCustomer(int id) {
		return customerRepository.findById(id).get();
		
	}
	public Customer updateCustomer(int id,String mobNum) {
		Customer customer=customerRepository.findById(id).get();
		customer.setCustomerMobileNumber(mobNum);
		customerRepository.flush();
		return customer;
	}
	public List<Customer> viewAllCustomer(){
		return customerRepository.findAll();
		
	}
	public List<Customer> viewAllCustomersByLocation(String location){
		return customerRepository.getByCustomerAddress(location) ;
		
	}
	
	
}
