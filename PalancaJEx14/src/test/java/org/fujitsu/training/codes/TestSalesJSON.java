package org.fujitsu.training.codes;

import java.util.Arrays;

import org.fujitsu.training.codes.itemc.Sales;
import org.fujitsu.training.codes.itemc.SalesJSON;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSalesJSON {
	private SalesJSON sj;
	
	@BeforeEach
	public void setup() {
		sj = new SalesJSON();
	}
	
	@AfterEach
	public void teardown() {
		sj = null;
	}
	
	@Test
	public void testEncodeJSON() {
		Sales sales1 = new Sales("Smith", 16753.00, "UK", "Qtr 3");
		Sales sales2 = new Sales("Johnson", 16753.01, "USA", "Qtr 4");
		Sales sales3 = new Sales("Williams", 10644.00, "UK", "Qtr 2");
		Sales sales4 = new Sales("Jones", 1390.00, "USA", "Qtr 3");
		Sales sales5 = new Sales("Brown", 4865.00, "USA", "Qtr 4");
		Sales sales6 = new Sales("Williams", 12438.00, "UK", "Qtr 1");
		Sales sales7 = new Sales("Johnson", 9339.00, "UK", "Qtr 2");
		Sales sales8 = new Sales("Smith", 18919.00, "USA", "Qtr 3");
		Sales sales9 = new Sales("Jones", 9213.00, "USA", "Qtr 4");
		Sales sales10 =  new Sales("Jones", 7433.00, "UK", "Qtr 1");
		Sales sales11 =  new Sales("Brown", 3255.00, "USA", "Qtr 2");
		Sales sales12 = new Sales("Williams", 14867.00, "USA", "Qtr 3");
		Sales sales13 = new Sales("Williams", 19302.00, "UK", "Qtr 4");
		Sales sales14 = new Sales("Smith", 9698.00, "USA", "Qtr 1");
		String filename = "./src/main/resources/files/sales.json";
		sj.encodeJSON(filename, sales1, sales2, sales3, sales4,
				sales5, sales6, sales7, sales8, sales9,
				sales10, sales11, sales12, sales13, sales14);
	}
	
	@Test
	public void testDecodeJSON() {
		String filename = "./src/main/resources/files/sales.json";
		Sales[] rec = sj.decodeJSON(filename);
		System.out.println(Arrays.toString(rec));
	}
}
