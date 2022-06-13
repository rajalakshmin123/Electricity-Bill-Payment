package com.electricity.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tariff")
public class Tariff {
	private int tariff_id;
    private String tariff_type;
    private String tariff_description;
	public int getTariff_id() {
		return tariff_id;
	}
	public void setTariff_id(int tariff_id) {
		this.tariff_id = tariff_id;
	}
	public String getTariff_type() {
		return tariff_type;
	}
	public void setTariff_type(String tariff_type) {
		this.tariff_type = tariff_type;
	}
	public String getTariff_description() {
		return tariff_description;
	}
	public void setTariff_description(String tariff_description) {
		this.tariff_description = tariff_description;
	}
	@Override
	public String toString() {
		return "Tariff [tariff_id=" + tariff_id + ", tariff_type=" + tariff_type + ", tariff_description="
				+ tariff_description + "]";
	}
}
