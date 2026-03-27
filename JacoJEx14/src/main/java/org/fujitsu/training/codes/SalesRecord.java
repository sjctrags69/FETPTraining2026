package org.fujitsu.training.codes;

public class SalesRecord {

	private String lastName;
	private String sales;
	private String country;
	private String quarter;

	public SalesRecord() {
	}

	public SalesRecord(String lastName, double sales, String country, String quarter) {
		this.lastName = lastName;
		this.sales = String.format("$%.2f", sales);
		this.country = country;
		this.quarter = quarter;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSales() {
		return sales;
	}

	public String getCountry() {
		return country;
	}

	public String getQuarter() {
		return quarter;
	}
}