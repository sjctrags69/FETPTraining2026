package org.fujitsu.training.codes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sale {

	@JsonProperty(value = "lastname")
	private String lastName;
	
	@JsonProperty(value = "sales")
	private String sales;
	
	@JsonProperty(value = "country")
	private String country;
	
	@JsonProperty(value = "quarter")
	private String quarter;
	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", lastName, sales, country, quarter);
	}
}