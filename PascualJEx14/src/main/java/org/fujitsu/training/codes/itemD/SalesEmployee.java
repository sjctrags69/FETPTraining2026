package org.fujitsu.training.codes.itemD;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@JsonRootName(value = "salesEmployee")
@XmlRootElement(name = "salesEmployee")
public class SalesEmployee {

	@JsonProperty(value = "id")
	private Integer id;
	@JsonProperty(value = "lastname")
	private String lastName;
	@JsonProperty(value = "sales")
	private String sales;
	@JsonProperty(value = "country")
	private String country;
	@JsonProperty(value = "quarter")
	private String quarter;

	@XmlAttribute(name = "id", required = true)
	public Integer getId() {
		return id;
	}

	@XmlElement(name = "lastname", nillable = false, required = true)
	public String getLastName() {
		return lastName;
	}

	@XmlElement(name = "sales", nillable = false, required = true)
	public String getSales() {
		return sales;
	}

	@XmlElement(name = "country", nillable = false, required = true)
	public String getCountry() {
		return country;
	}

	@XmlElement(name = "quarter", nillable = false, required = true)
	public String getQuarter() {
		return quarter;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
}

