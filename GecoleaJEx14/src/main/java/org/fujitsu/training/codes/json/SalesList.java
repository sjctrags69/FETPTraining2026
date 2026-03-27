package org.fujitsu.training.codes.json;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("salesList")
public class SalesList {

    private List<Sales> sales;

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
}
