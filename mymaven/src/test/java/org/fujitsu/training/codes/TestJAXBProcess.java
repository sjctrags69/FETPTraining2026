package org.fujitsu.training.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestJAXBProcess {
	private JAXBProcess jb;
	
	@BeforeEach
	public void setup() {
		jb = new JAXBProcess();
	}
	
	@AfterEach
	public void teardown() {
		jb = null;
	}
	
	@Test
	public void testCreateEmployeeXML() {
		Employee rec = new Employee();
		rec.setId(101);
		rec.setFirstName("Juan");
		rec.setLastName("Luna");
		rec.setAge(60);
		rec.setSalary(600000.00);
		String filename = "./src/main/resources/files/employee.xml";
		
		jb.createXML(filename, rec);
	}
	
	@Test
	public void testParseEmployeeXML() {
		String filename = "./src/main/resources/files/employee.xml";
		Employee rec = jb.parseXML(filename);
		System.out.print(rec);
	}
	
	@Test
	public void testCreateEmployeesXML() {
		Employee rec1 = new Employee();
		rec1.setId(101);
		rec1.setFirstName("Juan");
		rec1.setLastName("Luna");
		rec1.setAge(60);
		rec1.setSalary(600000.00);
		
		Employee rec2 = new Employee();
		rec2.setId(102);
		rec2.setFirstName("Maria");
		rec2.setLastName("lara");
		rec2.setAge(59);
		rec2.setSalary(700000.00);
		
		String filename = "./src/main/resources/files/employees.xml";
		
		List<Employee> recs = new ArrayList<>(Arrays.asList(rec1, rec2));
		Employees emps = new Employees();
		emps.setEmployees(recs);
		jb.createEmployeesXML(filename, emps);
	}
	
	/*
	@Test
	public void testParseEmployeesXML() {
		Employee rec1 = new Employee();
		rec1.setId(101);
		rec1.setFirstName("Juan");
		rec1.setLastName("Luna");
		rec1.setAge(60);
		rec1.setSalary(600000.00);
		
		Employee rec2 = new Employee();
		rec2.setId(101);
		rec2.setFirstName("Juan");
		rec2.setLastName("Luna");
		rec2.setAge(60);
		rec2.setSalary(600000.00);
		
		String filename = "./src/main/resources/files/employees.xml";
		
		List<Employee> recs = new ArrayList<>(Arrays.asList(rec1, rec2));
		Employees emps = new Employees();
		emps.setEmployees(recs);
		jb.createEmployeesXML(filename, emps);
	}
	*/

}
