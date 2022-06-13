package com.electricity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.model.Customer;
import com.electricity.repository.CustomerRepo;

@Service
public class ConsumerService {
	@Autowired
	CustomerRepo customerrepo;
	
	public Customer findCustomerDetailsById(int customer_id) {
		return customerrepo.findCustomerDetailsById(customer_id);
	}
}
