package org.fujitsu.training.codes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sales {

	@JsonProperty(value = "sales")
	private List<Sale> sales;

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
}