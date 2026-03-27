package org.fujitsu.training.codes;

import java.util.ArrayList;
import java.util.List;

public class SalesTable {
    private List<Sales> sales = new ArrayList<>();

    public List<Sales> getSales() { 
    	return sales; 
    }
    
    public void setSales(List<Sales> sales) { 
    	this.sales = sales; 
    }
}