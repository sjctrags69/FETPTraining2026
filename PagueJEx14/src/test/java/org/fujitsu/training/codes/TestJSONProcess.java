package org.fujitsu.training.codes;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestJSONProcess {

	private JSONProcess sjp;
	
	@BeforeEach
	public void setup() {
		sjp = new JSONProcess();
	}
	
	@AfterEach
	public void teardown() {
		sjp = null;
	}
	
	@Test
	public void testEncodeJSON() {
		List<Sale> recs = new ArrayList<>();
		
		Sale rec1 = new Sale();
		rec1.setLastName("Smith");
		rec1.setSales("$16,753.00");
		rec1.setCountry("UK");
		rec1.setQuarter("Qtr 3");
		recs.add(rec1);
		
		Sale rec2 = new Sale();
		rec2.setLastName("Johnson");
		rec2.setSales("$14,808.00");
		rec2.setCountry("USA");
		rec2.setQuarter("Qtr 4");
		recs.add(rec2);
		
		Sale rec3 = new Sale();
		rec3.setLastName("Williams");
		rec3.setSales("$10,644.00");
		rec3.setCountry("UK");
		rec3.setQuarter("Qtr 2");
		recs.add(rec3);
		
		Sale rec4 = new Sale();
		rec4.setLastName("Jones");
		rec4.setSales("$1,390.00");
		rec4.setCountry("USA");
		rec4.setQuarter("Qtr 3");
		recs.add(rec4);
		
		Sale rec5 = new Sale();
		rec5.setLastName("Brown");
		rec5.setSales("$4,865.00");
		rec5.setCountry("USA");
		rec5.setQuarter("Qtr 4");
		recs.add(rec5);
		
		Sale rec6 = new Sale();
		rec6.setLastName("Williams");
		rec6.setSales("$12,438.00");
		rec6.setCountry("UK");
		rec6.setQuarter("Qtr 1");
		recs.add(rec6);
		
		Sale rec7 = new Sale();
		rec7.setLastName("Johnson");
		rec7.setSales("$9,339.00");
		rec7.setCountry("UK");
		rec7.setQuarter("Qtr 2");
		recs.add(rec7);
		
		Sale rec8 = new Sale();
		rec8.setLastName("Smith");
		rec8.setSales("$18,919.00");
		rec8.setCountry("USA");
		rec8.setQuarter("Qtr 3");
		recs.add(rec8);
		
		Sale rec9 = new Sale();
		rec9.setLastName("Jones");
		rec9.setSales("$9,213.00");
		rec9.setCountry("USA");
		rec9.setQuarter("Qtr 4");
		recs.add(rec9);
		
		Sale rec10 = new Sale();
		rec10.setLastName("Jones");
		rec10.setSales("$7,433.00");
		rec10.setCountry("UK");
		rec10.setQuarter("Qtr 1");
		recs.add(rec10);
		
		Sale rec11 = new Sale();
		rec11.setLastName("Brown");
		rec11.setSales("$3,255.00");
		rec11.setCountry("USA");
		rec11.setQuarter("Qtr 2");
		recs.add(rec11);
		
		Sale rec12 = new Sale();
		rec12.setLastName("Williams");
		rec12.setSales("$14,867.00");
		rec12.setCountry("USA");
		rec12.setQuarter("Qtr 3");
		recs.add(rec12);
		
		Sale rec13 = new Sale();
		rec13.setLastName("Williams");
		rec13.setSales("$19,302.00");
		rec13.setCountry("UK");
		rec13.setQuarter("Qtr 4");
		recs.add(rec13);
		
		Sale rec14 = new Sale();
		rec14.setLastName("Smith");
		rec14.setSales("$9,698.00");
		rec14.setCountry("USA");
		rec14.setQuarter("Qtr 1");
		recs.add(rec14);
		
		Sales records = new Sales();
		records.setSales(recs);
		
		String filename = "./src/main/resources/files/sales.json";
		assertTrue(sjp.encodeJSON(filename, records));
	}
	
	@Test
	public void testDecodeJSON() {
		String filename = "./src/main/resources/files/sales.json";
		Sales records = sjp.decodeJSON(filename);
		System.out.println(records);
		assertNotNull(records);
	}
}