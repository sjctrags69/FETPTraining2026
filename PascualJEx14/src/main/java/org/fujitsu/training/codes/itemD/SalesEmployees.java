package org.fujitsu.training.codes.itemD;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "salesEmployees")
public class SalesEmployees {

	private List<SalesEmployee> salesEmployees;

	@XmlElement(name = "salesEmployee")
	public List<SalesEmployee> getSalesEmployees() {
		return salesEmployees;
	}

	public void setSalesEmployees(List<SalesEmployee> salesEmployees) {
		this.salesEmployees = salesEmployees;
	}
}
