package com.electricity.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="billing")
public class Billing {
	private int bill_no;
	private int cust_id;
	private int connection_id;
	private Date payment_date;
	private Time payment_time;
	private float bill_amount;
	private float paid_amount;
	private Date due_date;
	private String status;
	private int units;
	private Date generated_date;
	private int fixedcharge;
	private float energy_charge;
	private int meter_rent;
	
	public int getFixedcharge() {
		return fixedcharge;
	}
	public void setFixedcharge(int fixedcharge) {
		this.fixedcharge = fixedcharge;
	}
	public float getEnergy_charge() {
		return energy_charge;
	}
	public void setEnergy_charge(float energy_charge) {
		this.energy_charge = energy_charge;
	}
	public int getMeter_rent() {
		return meter_rent;
	}
	public void setMeter_rent(int meter_rent) {
		this.meter_rent = meter_rent;
	}
	public Date getGenerated_date() {
		return generated_date;
	}
	public void setGenerated_date(Date generated_date) {
		this.generated_date = generated_date;
	}
	public int getBill_no() {
		return bill_no;
	}
	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getConnection_id() {
		return connection_id;
	}
	public void setConnection_id(int connection_id) {
		this.connection_id = connection_id;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public Time getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(Time payment_time) {
		this.payment_time = payment_time;
	}
	public float getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(float bill_amount) {
		this.bill_amount = bill_amount;
	}
	public float getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(float paid_amount) {
		this.paid_amount = paid_amount;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	@Override
	public String toString() {
		return "Billing [bill_no=" + bill_no + ", cust_id=" + cust_id + ", connection_id=" + connection_id
				+ ", payment_date=" + payment_date + ", payment_time=" + payment_time + ", bill_amount=" + bill_amount
				+ ", paid_amount=" + paid_amount + ", due_date=" + due_date + ", status=" + status + ", units=" + units
				+ ", generated_date=" + generated_date + ", fixedcharge=" + fixedcharge + ", energy_charge="
				+ energy_charge + ", meter_rent=" + meter_rent + "]";
	}
	
}
