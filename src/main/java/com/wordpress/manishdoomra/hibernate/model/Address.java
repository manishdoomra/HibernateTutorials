package com.wordpress.manishdoomra.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	
	private String city;
	private String state;
	private String pinCode;
	
	public Address(){
		
	}
	
	public Address(String city, String state, String pinCode){
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	@Column(name="CITY_NAME")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="STATE_NAME")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="PINCODE")
	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pinCode="
				+ pinCode + "]";
	}
	
}
