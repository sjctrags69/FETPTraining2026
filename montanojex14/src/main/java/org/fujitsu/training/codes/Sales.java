package org.fujitsu.training.codes;

import java.text.NumberFormat;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "sale")
public class Sales {
    private String lastName;
    private double salesAmount;
    private String country;
    private String quarter;
    
    public Sales(String lastName, double salesAmount, String country, String quarter) {
        this.lastName = lastName;
        this.salesAmount = salesAmount;
        this.country = country;
        this.quarter = quarter;
    }
    
    @JsonProperty(value = "lastname")
	public String getLastName() {
		return lastName;
	}
	@JsonProperty(value = "sales")
	public String getSalesAmount() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		return formatter.format(salesAmount);
	}
	@JsonProperty(value = "country")
	public String getCountry() {
		return country;
	}
	@JsonProperty(value = "quarter")
	public String getQuarter() {
		return quarter;
	}
}