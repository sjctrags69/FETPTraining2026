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
		String filename = "./src/main/resources/files/employee.json";
		Employee rec = new Employee();
		rec.setId(101);
		rec.setFirstName("Juan");
		rec.setLastName("Luna");
		rec.setAge(60);
		rec.setSalary(600000.00);
		jp.encodeJSON(filename, rec);
	}
	
	@Test
	public void testDecodeJSON() {
		String filename = "./src/main/resources/files/employee.json";
		jp.decodeJSON(filename);
	}

}
