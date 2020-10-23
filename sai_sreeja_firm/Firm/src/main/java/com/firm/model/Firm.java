package com.firm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="firms")
public class Firm {
	@Id
	private int firmId;
	private String FirmName;
	private double salary;
	private double volume;
	private Date date;
	
	
	
	public Firm() {
		super();
	}
	public Firm(int firmId, String firmName, double salary, double volume, Date date) {
		super();
		this.firmId = firmId;
		this.firmName = firmName;
		this.salary = salary;
		this.volume = volume;
		this.date = date;
	}
	public int getFirmId() {
		return firmId;
	}
	public void setFirmId(int firmId) {
		this.firmId = firmId;
	}
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
