package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



import com.cg.service.CustomerService;
import com.cg.service.PaymentService;

@RestController
public class CustomerController {
	@Autowired
    public CustomerService customerService;
	
	@Autowired
	public PaymentService paymentService;
	
	
}
