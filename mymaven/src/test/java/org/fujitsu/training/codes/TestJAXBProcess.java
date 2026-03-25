package org.fujitsu.training.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestJAXBProcess {
	private JAXBProcess jp;
	
	@BeforeEach
	public void setup() {
		jp = new JAXBProcess();
	}
	
	@AfterEach
	public void teardown() {
		jp = null;
	}
	
	@Test
	public void testCreateEmployeeXML() {
		Employee rec = new Employee();
		rec.setId(101);
		rec.setFirstName("Juan");
		rec.setLastName("Luna");
		rec.setAge(77);
		rec.setSalary(50000.00);
		
		String filename = "./src/main/resources/files/employee.xml";
		
		jp.createEmployeeXML(filename, rec);
	}
	
	@Test
	public void testCreateEmployeesXML() {
		Employee rec1 = new Employee();
		rec1.setId(101);
		rec1.setFirstName("Juan");
		rec1.setLastName("Luna");
		rec1.setAge(77);
		rec1.setSalary(50000.00);
		
		Employee rec2 = new Employee();
		rec2.setId(102);
		rec2.setFirstName("Maria");
		rec2.setLastName("Clara");
		rec2.setAge(54);
		rec2.setSalary(30000.00);
		
		
		
		String filename = "./src/main/resources/files/employees.xml";
		
		List<Employee> recs = 
				new ArrayList<>(Arrays.asList(rec1, rec2));
		
		Employees emps = new Employees();
		emps.setEmployees(recs);
		
		jp.createEmployeesXML(filename, emps);
		
		
	}
	
	@Test
	public void testParseEmployeeXML() {
		String filename = "./src/main/resources/files/employee.xml";
		Employee rec = jp.parseEmployeeXML(filename);
		System.out.println(rec);
	}

}
