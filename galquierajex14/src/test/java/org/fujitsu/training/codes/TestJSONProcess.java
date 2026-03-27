package org.fujitsu.training.codes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestJSONProcess {
	private JSONProcess jp;
	private SalesList salesList;

	@BeforeEach
	public void setup() {
		jp = new JSONProcess();

		DecimalFormat df = new DecimalFormat("$#,##0.00");
		List<Sale> list = new ArrayList<Sale>();

		list.add(new Sale("Smith", df.format(16753.00), "UK", "Qtr 3"));
		list.add(new Sale("Johnson", df.format(14808.00), "USA", "Qtr 4"));
		list.add(new Sale("Williams", df.format(10644.00), "UK", "Qtr 2"));
		list.add(new Sale("Jones", df.format(1390.00), "USA", "Qtr 3"));
		list.add(new Sale("Brown", df.format(4865.00), "USA", "Qtr 4"));
		list.add(new Sale("Williams", df.format(12438.00), "UK", "Qtr 1"));
		list.add(new Sale("Johnson", df.format(9339.00), "UK", "Qtr 2"));
		list.add(new Sale("Smith", df.format(18919.00), "USA", "Qtr 3"));
		list.add(new Sale("Jones", df.format(9213.00), "USA", "Qtr 4"));
		list.add(new Sale("Jones", df.format(7433.00), "UK", "Qtr 1"));
		list.add(new Sale("Brown", df.format(3255.00), "USA", "Qtr 2"));
		list.add(new Sale("Williams", df.format(14867.00), "USA", "Qtr 3"));
		list.add(new Sale("Williams", df.format(19302.00), "UK", "Qtr 4"));
		list.add(new Sale("Smith", df.format(9698.00), "USA", "Qtr 1"));

		salesList = new SalesList(list);
	}

	@AfterEach
	public void teardown() {
		jp = null;
		salesList = null;
	}

	@Test
	public void testEncodeJSON() {
		boolean result = jp.encodeJSON("sales.json", salesList);
		Assertions.assertTrue(result);
	}

	@Test
	public void testDecodeJSON() {
		jp.encodeJSON("sales.json", salesList);

		SalesList decoded = jp.decodeJSON("sales.json");

		Assertions.assertNotNull(decoded);
		Assertions.assertNotNull(decoded.getSales());
		Assertions.assertEquals(14, decoded.getSales().size());

		Assertions.assertEquals("Smith", decoded.getSales().get(0).getLastName());
		Assertions.assertEquals("$16,753.00", decoded.getSales().get(0).getSales());
		Assertions.assertEquals("UK", decoded.getSales().get(0).getCountry());
		Assertions.assertEquals("Qtr 3", decoded.getSales().get(0).getQuarter());
	}
}