package com.electricity.repository;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electricity.model.*;

public interface BillingRepo extends JpaRepository<Billing, String> {
	@Query(value = "SELECT * FROM public.billing where due_date= ; ?1",
			  nativeQuery = true)
	Billing findDueBills(@Param("due_date") Date due_date);
	
	@Query(value = "SELECT * FROM public.billing where cust_id= ; ?1",
			  nativeQuery = true)
	Billing findBillsByCustomerId(@Param("consumer_id") int cust_id);
	
	public static final String UPD_QUERY1 = "UPDATE public.billing set payment_date =?1, "
			+ "payment_time =?2, bill_amount =?3,paid_amount=?4, status='paid' where cust_id=?5";
	@Modifying
	@Query(UPD_QUERY1)
	@Transactional
	public int updateConsumerBill(Date payment_date,LocalTime time,float bill_amount,
			float paid_amount, int cust_id);
}
