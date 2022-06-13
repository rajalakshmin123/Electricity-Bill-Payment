package com.electricity.controller;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
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
import com.electricity.model.Connection;
import com.electricity.model.Customer;
import com.electricity.model.Tariff;
import com.electricity.service.BillingService;
import com.electricity.service.ConnectionService;
import com.electricity.service.ConsumerService;
import com.electricity.service.TariffService;

@RestController
@RequestMapping("/bill")
public class BillingController {
	Logger logger = LoggerFactory.getLogger(BillingController.class);

	@Autowired
	private BillingService billingservice;
	
	@Autowired
	ConnectionService connectionservice;
	
	@Autowired
	ConsumerService consumerservice;
	
	@Autowired
	TariffService tariffservice;
	
	@Autowired
	Billing bill;
	
	JSONObject response = new JSONObject();
	
	@RequestMapping(value="/generate",method=RequestMethod.POST)
	public ResponseEntity<JSONObject> generateBill(@RequestParam("connection_id") int connection_id,
				@RequestParam("units") int units){
		logger.info("\n......Api for generating the bill....");	
		try {
			Connection connection = connectionservice.findCustomerId(connection_id);
			response.keySet().clear();
			
			Date date = new Date( );
			Calendar c= Calendar.getInstance();
			c.add(Calendar.DATE, 30);
			Date due_date=c.getTime();
			
			Customer consumer = consumerservice.findCustomerDetailsById(connection.getCust_id());
			JSONObject calculatedbill = billingservice.billCalculation(units, connection.getTariff_id());
			Tariff tariff = tariffservice.findTariffDetailsId(connection.getTariff_id());
			
			bill.setBill_amount((float) calculatedbill.get("total_bill"));
			bill.setConnection_id(connection_id);
			bill.setCust_id(connection.getCust_id());
			bill.setGenerated_date(date);
			bill.setDue_date(due_date);
			bill.setUnits(units);
			bill.setStatus("not paid");
			bill.setEnergy_charge((float) calculatedbill.get("energy_charge"));
			bill.setFixedcharge((int) calculatedbill.get("fixedcharge"));
			bill.setMeter_rent((int) calculatedbill.get("meter_rent"));
			
			billingservice.saveBill(bill);
			
			response.put("Data", bill);
			return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/dues",method=RequestMethod.GET)
	public ResponseEntity<JSONObject> generateBill(){
		try {
			logger.info("\n......Api for finding the due bill....");	
			Date date = new Date( );
			Billing duebills = billingservice.findDueBills(date);
			response.keySet().clear();
			response.put("Data", bill);
			return new ResponseEntity<JSONObject>(response, HttpStatus.OK);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			response.put("response","Internal errors");
			return new ResponseEntity<JSONObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
