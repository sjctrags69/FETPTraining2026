package org.fujitsu.training.codes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@JsonRootName(value= "employee")
@XmlRootElement(name= "employee")
public class Employee {
	
	@JsonProperty(value= "id")
	private Integer id;
	@JsonProperty(value= "firstnam")
	private String firstName;
	@JsonProperty(value= "lastname")
	private String lastName;
	@JsonProperty(value= "age")
	private Integer age;
	@JsonProperty(value= "salary")
	private Double salary;
	
	@XmlAttribute(name= "id", required= true)
	public Integer getId() {
		return id;
	}
	
	@XmlElement(name= "firstname", nillable= false, required= true)
	public String getFirstName() {
		return firstName;
	}
	
	@XmlElement(name= "lastname", nillable= false, required= true)
	public String getLastName() {
		return lastName;
	}
	
	@XmlElement(name= "age", nillable= false, required= true)
	public Integer getAge() {
		return age;
	}
	@XmlElement(name= "salary", nillable= false, required= true)
	public Double getSalary() {
		return salary;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", id, firstName, lastName, age, salary);
	}
	
	
	

}
