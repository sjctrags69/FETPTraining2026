package org.fujitsu.training.codes.itemD;

public class SalesRecord {

	private String lastName;
	private String sales;
	private String country;
	private String quarter;

	public SalesRecord() {
	}

	public SalesRecord(String lastName, String sales, String country, String quarter) {
		this.lastName = lastName;
		this.sales = sales;
		this.country = country;
		this.quarter = quarter;
	}

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
}
