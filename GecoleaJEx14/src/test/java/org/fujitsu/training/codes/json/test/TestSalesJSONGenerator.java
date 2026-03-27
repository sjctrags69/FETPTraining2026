package org.fujitsu.training.codes.json.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.fujitsu.training.codes.json.Sales;
import org.fujitsu.training.codes.json.SalesJSONGenerator;
import org.fujitsu.training.codes.json.SalesList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSalesJSONGenerator {

	private Sales s1;
	private Sales s2;
	private Sales s3;
	private Sales s4;
	private SalesList salesList;
	private SalesJSONGenerator generator;

	@BeforeEach
	public void setup() {
		s1 = new Sales();
		s2 = new Sales();
		s3 = new Sales();
		s4 = new Sales();
		salesList = new SalesList();
		generator = new SalesJSONGenerator();
	}

	@AfterEach
	public void teardown() {
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		salesList = null;
		generator = null;
	}

	@Test
	public void createSalesJSON() {

		s1.setId(1);
		s1.setName("Smith");
		s1.setSales(16753.00);

		s2.setId(2);
		s2.setName("Johnson");
		s2.setSales(14808.00);

		s3.setId(3);
		s3.setName("Williams");
		s3.setSales(10644.00);

		s4.setId(4);
		s4.setName("Jones");
		s4.setSales(1390.00);

		salesList.setSales(Arrays.asList(s1, s2, s3, s4));

		boolean success = generator.createSalesJSON("./src/main/resources/files/sales.json", salesList);

		assertTrue(success);
	}
}
