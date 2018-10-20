package com.test.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author Rajesh
 *
 */
@JsonIgnoreProperties
@Embeddable
public class PermanentAddVO {

	private String line1;
	private String line2;
	private String pincode;
	private String city;
	private String state;
	private String country;
	
	@Column(name = "P_ADDRESS_LINE1", nullable = false, length=100)
	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}
	@Column(name = "P_ADDRESS_LINE2", nullable = false, length=100)
	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}
	@Column(name = "P_ADDRESS_PIN_CODE", nullable = false, length=10)
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Column(name = "P_ADDRESS_CITY", nullable = false, length=50)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "P_ADDRESS_STATE", nullable = false, length=50)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "P_ADDRESS_COUNTRY", nullable = false, length=50)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
