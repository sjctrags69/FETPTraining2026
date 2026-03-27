package org.fujitsu.training.codes;

import java.util.List;

public class SalesList {
	private List<Sale> sales;

	public SalesList() {
	}

	public SalesList(List<Sale> sales) {
		this.sales = sales;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
}