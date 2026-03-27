package org.fujitsu.training.codes.itemc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "employee")
public class Sales {
	
	@JsonProperty(value = "lastname", required = true)
	private String lastName;
	
	@JsonProperty(value = "sales", required = true)
	private String sales;
	
	@JsonProperty(value = "country", required = true)
	private String country;
	
	@JsonProperty(value = "quarter", required = true)
	private String quarter;
	
	public Sales() {}

	public Sales(String lastName, Double sales, String country, String quarter) {
		super();
		this.lastName = lastName;
		this.sales = formatSales(sales);
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
	
	private String formatSales(Double value) {
		return String.format("\u0024%.2f", value);
	}
	@Override
	public String toString() {
		return String.format("%s %s %s %s", lastName, sales, country, quarter);
	}
}
