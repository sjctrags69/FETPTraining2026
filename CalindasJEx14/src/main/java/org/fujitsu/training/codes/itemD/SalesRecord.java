package org.fujitsu.training.codes.itemD;

public class SalesRecord {

    private String name;
    private String sales;
    private String country;
    private String quarter;

    public SalesRecord(String name, double sales, String country, String quarter) {
        this.name = name;
        this.sales = String.format("$%.2f", sales);
        this.country = country;
        this.quarter = quarter;
    }

    public String getName() { return name; }
    public String getSales() { return sales; }
    public String getCountry() { return country; }
    public String getQuarter() { return quarter; }
}