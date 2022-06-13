package com.electricity.service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricity.calculation.Domesticusers;
import com.electricity.model.Billing;
import com.electricity.repository.BillingRepo;

@Service
public class BillingService {
	@Autowired
	BillingRepo billingrepo;
	
	@Autowired
	Domesticusers domesticuser;
	
	public JSONObject billCalculation(int units,int tariff_id) {
		return domesticuser.billCalculation(units);
	}
	public void saveBill(Billing bill) {
		billingrepo.save(bill);
	}
	
	public Billing findDueBills(Date due_date) {
		return billingrepo.findDueBills(due_date);
	}
	
	public Billing findBillsByCustomerId(int consumer_id) {
		return billingrepo.findBillsByCustomerId(consumer_id);
	}

	public int updateConsumerBill(Date payment_date,LocalTime time,float bill_amount,
			float paid_amount, int cust_id) {
		return billingrepo.updateConsumerBill(payment_date, time, bill_amount, paid_amount, cust_id);
	}
}
