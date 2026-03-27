package org.fujitsu.training.codes.itemD;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProcessSalesJSON {
	private ProcessSalesJSON psj;

	@BeforeEach
	public void setup() {
		psj = new ProcessSalesJSON();
	}

	@AfterEach
	public void teardown() {
		psj = null;
	}

	@Test
	public void testEncodeSalesEmployeesJSON() {

		String filename = "./src/main/resources/files/sales.json";

		SalesEmployee emp1 = new SalesEmployee();
		emp1.setId(1);
		emp1.setLastName("Smith");
		emp1.setSales(String.format("$%.2f", 16753.00));
		emp1.setCountry("UK");
		emp1.setQuarter("Qtr 3");

		SalesEmployee emp2 = new SalesEmployee();
		emp2.setId(2);
		emp2.setLastName("Johnson");
		emp2.setSales(String.format("$%.2f", 14808.00));
		emp2.setCountry("USA");
		emp2.setQuarter("Qtr 4");

		SalesEmployee emp3 = new SalesEmployee();
		emp3.setId(3);
		emp3.setLastName("Williams");
		emp3.setSales(String.format("$%.2f", 10644.00));
		emp3.setCountry("UK");
		emp3.setQuarter("Qtr 2");

		SalesEmployee emp4 = new SalesEmployee();
		emp4.setId(4);
		emp4.setLastName("Jones");
		emp4.setSales(String.format("$%.2f", 1390.00));
		emp4.setCountry("USA");
		emp4.setQuarter("Qtr 3");

		SalesEmployee emp5 = new SalesEmployee();
		emp5.setId(5);
		emp5.setLastName("Brown");
		emp5.setSales(String.format("$%.2f", 4865.00));
		emp5.setCountry("USA");
		emp5.setQuarter("Qtr 4");

		SalesEmployee emp6 = new SalesEmployee();
		emp6.setId(6);
		emp6.setLastName("Williams");
		emp6.setSales(String.format("$%.2f", 12438.00));
		emp6.setCountry("UK");
		emp6.setQuarter("Qtr 1");

		SalesEmployee emp7 = new SalesEmployee();
		emp7.setId(7);
		emp7.setLastName("Johnson");
		emp7.setSales(String.format("$%.2f", 9339.00));
		emp7.setCountry("UK");
		emp7.setQuarter("Qtr 2");

		SalesEmployee emp8 = new SalesEmployee();
		emp8.setId(8);
		emp8.setLastName("Smith");
		emp8.setSales(String.format("$%.2f", 18919.00));
		emp8.setCountry("USA");
		emp8.setQuarter("Qtr 3");

		SalesEmployee emp9 = new SalesEmployee();
		emp9.setId(9);
		emp9.setLastName("Jones");
		emp9.setSales(String.format("$%.2f", 9213.00));
		emp9.setCountry("USA");
		emp9.setQuarter("Qtr 4");

		SalesEmployee emp10 = new SalesEmployee();
		emp10.setId(10);
		emp10.setLastName("Jones");
		emp10.setSales(String.format("$%.2f", 7433.00));
		emp10.setCountry("UK");
		emp10.setQuarter("Qtr 1");

		SalesEmployee emp11 = new SalesEmployee();
		emp11.setId(11);
		emp11.setLastName("Brown");
		emp11.setSales(String.format("$%.2f", 3255.00));
		emp11.setCountry("USA");
		emp11.setQuarter("Qtr 2");

		SalesEmployee emp12 = new SalesEmployee();
		emp12.setId(12);
		emp12.setLastName("Williams");
		emp12.setSales(String.format("$%.2f", 14867.00));
		emp12.setCountry("USA");
		emp12.setQuarter("Qtr 3");

		SalesEmployee emp13 = new SalesEmployee();
		emp13.setId(13);
		emp13.setLastName("Williams");
		emp13.setSales(String.format("$%.2f", 19302.00));
		emp13.setCountry("UK");
		emp13.setQuarter("Qtr 4");

		SalesEmployee emp14 = new SalesEmployee();
		emp14.setId(14);
		emp14.setLastName("Smith");
		emp14.setSales(String.format("$%.2f", 9698.00));
		emp14.setCountry("USA");
		emp14.setQuarter("Qtr 1");

		SalesEmployees salesEmps = new SalesEmployees();
		salesEmps.setSalesEmployees(Arrays.asList(
				emp1, emp2, emp3, emp4, emp5, emp6, emp7,
				emp8, emp9, emp10, emp11, emp12, emp13, emp14));

		psj.encodeSalesEmployeesJSON(filename, salesEmps);
	}

	@Test
	public void testDecodeSalesEmployeesJSON() {
		String filename = "./src/main/resources/files/sales.json";

		psj.decodeSalesEmployeesJSON(filename);
	}
}
