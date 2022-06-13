package com.electricity.controller;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.model.Billing;
import com.electricity.service.BillingService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	Logger logger = LoggerFactory.getLogger(ConsumerController.class);
	
	JSONObject response = new JSONObject();

	@Autowired
	private BillingService billingservice;
	
	@RequestMapping(value="/fetchBill",method=RequestMethod.GET)
	public ResponseEntity<JSONObject> fetchBill(@RequestParam("consumer_id") int consumer_id){
		logger.info("\n......Api for fetching the bill....");	
		try {
			Billing bill = billingservice.findBillsByCustomerId(consumer_id);
			
			response.put("Data", bill);
			return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/payBill",method=RequestMethod.POST)
	public ResponseEntity<JSONObject> payBill(@RequestParam("consumer_id") int consumer_id,
			@RequestParam("amount") float paid_amount){
		logger.info("\n......Api for paying the bill....");	
		try {
			Billing bill = billingservice.findBillsByCustomerId(consumer_id);

			float total_amount = bill.getBill_amount();
			Date date = new Date();		
			LocalTime time = LocalTime.now();
			int rows=billingservice.updateConsumerBill(date, time, total_amount, paid_amount, consumer_id);
			if(rows==1) {
				response.put("Message", "Bill Paid Successfully");
				return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return null;
	}
}
