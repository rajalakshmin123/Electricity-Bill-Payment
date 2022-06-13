package com.electricity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electricity.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String> {
	@Query(value = "SELECT cust_id, cust_name, address, state, city, pincode, email_id, password, status "
			+ "	FROM public.customer where cust_id = ?1",
			  nativeQuery = true)
	Customer findCustomerDetailsById(@Param("customer_id") int customer_id);
}
