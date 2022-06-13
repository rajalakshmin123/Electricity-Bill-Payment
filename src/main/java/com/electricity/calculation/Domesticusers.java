package com.electricity.calculation;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Domesticusers {
	private int fixedcharge;
	private float energy_charge;
	final private int meter_rent = 50;
	private float total_bill = 0;
	
	JSONObject response = new JSONObject();
	
	public JSONObject billCalculation(int units) {
		response.keySet().clear();

		if(units<50) {
			fixedcharge = 110;
			energy_charge = 50*2.5f;
		}
		else if(units<100) {
			fixedcharge = 120;
			energy_charge = (50*2.5f)+(100-units)*3.5f;
		}
		else if(units<150) {
			fixedcharge = 130;
			energy_charge = (50*2.5f)+(50*3.5f)+(150-units)*4.5f;
		}
		total_bill = fixedcharge+energy_charge+meter_rent;
		
		response.put("total_bill", total_bill);
		response.put("fixedcharge", fixedcharge);
		response.put("energy_charge", energy_charge);
		response.put("meter_rent",meter_rent);
		return response;
	}
}
