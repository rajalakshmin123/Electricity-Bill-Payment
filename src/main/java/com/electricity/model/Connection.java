package com.electricity.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="connection")
public class Connection {
	private int connection_id;
    private int cust_id;
    private String meter_id;
    private int tariff_id;
    
	public int getTariff_id() {
		return tariff_id;
	}
	public void setTariff_id(int tariff_id) {
		this.tariff_id = tariff_id;
	}
	public int getConnection_id() {
		return connection_id;
	}
	public void setConnection_id(int connection_id) {
		this.connection_id = connection_id;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getMeter_id() {
		return meter_id;
	}
	public void setMeter_id(String meter_id) {
		this.meter_id = meter_id;
	}
	@Override
	public String toString() {
		return "Connection [connection_id=" + connection_id + ", cust_id=" + cust_id + ", meter_id=" + meter_id
				+ ", tariff_id=" + tariff_id + "]";
	}
	
}
