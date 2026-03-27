package org.fujitsu.training.codes;

import java.util.Arrays;
import java.util.List;

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
		List<Sales> sales = Arrays.asList(
	            new Sales("Smith", 16753.00, "UK", "Qtr 3"),
	            new Sales("Johnson", 14808.00, "USA", "Qtr 4"),
	            new Sales("Williams", 10644.00, "UK", "Qtr 2"),
	            new Sales("Jones", 1390.00, "USA", "Qtr 3"),
	            new Sales("Brown", 4865.00, "USA", "Qtr 4"),
	            new Sales("Williams", 12438.00, "UK", "Qtr 1"),
	            new Sales("Johnson", 9339.00, "UK", "Qtr 2"),
	            new Sales("Smith", 18919.00, "USA", "Qtr 3"),
	            new Sales("Jones", 9213.00, "USA", "Qtr 4"),
	            new Sales("Jones", 7433.00, "UK", "Qtr 1"),
	            new Sales("Brown", 3255.00, "USA", "Qtr 2"),
	            new Sales("Williams", 14867.00, "USA", "Qtr 3"),
	            new Sales("Williams", 19302.00, "UK", "Qtr 4"),
	            new Sales("Smith", 9698.00, "USA", "Qtr 1")
	        );
		
		String filename = "./src/main/resources/files/sales.json";
		
		jp.encodeJSON(filename, sales);
	}
}
