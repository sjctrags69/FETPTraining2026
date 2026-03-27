package org.fujitsu.training.codes.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sales {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    private Double sales;

    @JsonProperty("sales")
    public String getFormattedSales() {
        return String.format("$%.2f", sales);
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getSales() {
        return sales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}