package org.fujitsu.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestJSONProcess {
	private JSONProcess jp;
	
	@BeforeEach
	public void setup() {
		jp = new JSONProcess();
	}
	
	@AfterEach
	public void teardown() {
	    jp = null;	
	}
	
	@Test
	public void testEncodeJSON() {
		Employee rec = new Employee();
		rec.setId(101);
		rec.setFirstName("Juan");
		rec.setLastName("Luna");
		rec.setAge(77);
		rec.setSalary(50000.00);
		
		String filename = "./src/main/resources/files/employee.json";
		
		jp.encodeJSON(filename, rec);
		
	}

}
