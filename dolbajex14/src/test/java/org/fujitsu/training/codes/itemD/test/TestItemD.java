package org.fujitsu.training.codes.itemD.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fujitsu.training.codes.itemD.JacksonMapper;
import org.fujitsu.training.codes.itemD.SalesRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestItemD {

	private static final Logger LOGGER = LogManager.getLogger(TestItemD.class);
	private JacksonMapper mapper;

	@BeforeEach
	public void setup() {
		LOGGER.info("Setup TestItemD");
		mapper = new JacksonMapper();
	}

	@AfterEach
	public void teardown() {
		LOGGER.info("Teardown TestItemD");
		mapper = null;
	}

	@Order(1)
	@Test
	public void sunnyDayCreateSalesXmlFile() {
		LOGGER.info("Run sunnyDayCreateSalesXmlFile");

		// Given
		String filename = "sales-generated.xml";
		List<SalesRecord> records = buildSalesRecords();

		// When
		boolean result = mapper.createSalesXML(filename, records);

		// Then
		assertTrue(result);
	}

	@Order(2)
	@Test
	public void sunnyDayCreateSalesXmlWithCurrencyFormat() throws IOException {
		LOGGER.info("Run sunnyDayCreateSalesXmlWithCurrencyFormat");

		// Given
		String filename = "sales-generated-check.xml";
		Path outputPath = Paths.get("src", "main", "resources", "files", filename);
		List<SalesRecord> records = buildSalesRecords();

		// When
		boolean result = mapper.createSalesXML(filename, records);
		String json = Files.readString(outputPath, StandardCharsets.UTF_8);

		// Then
		assertTrue(result);
		assertTrue(json.contains("$16,753.00"));
		assertTrue(json.contains("$9,698.00"));
	}

	@Order(3)
	@Test
	public void rainyDayCreateSalesXmlInvalidFilename() {
		LOGGER.info("Run rainyDayCreateSalesXmlInvalidFilename");

		// Given
		String filename = "sales?.xml";
		List<SalesRecord> records = buildSalesRecords();

		// When
		boolean result = mapper.createSalesXML(filename, records);

		// Then
		assertFalse(result);
	}

	private List<SalesRecord> buildSalesRecords() {
		LOGGER.info("Build sales records in test");
		return List.of(
				new SalesRecord("Smith", formatSales(16753), "UK", "Qtr 3"),
				new SalesRecord("Johnson", formatSales(14808), "USA", "Qtr 4"),
				new SalesRecord("Williams", formatSales(10644), "UK", "Qtr 2"),
				new SalesRecord("Jones", formatSales(1390), "USA", "Qtr 3"),
				new SalesRecord("Brown", formatSales(4865), "USA", "Qtr 4"),
				new SalesRecord("Williams", formatSales(12438), "UK", "Qtr 1"),
				new SalesRecord("Johnson", formatSales(9339), "UK", "Qtr 2"),
				new SalesRecord("Smith", formatSales(18919), "USA", "Qtr 3"),
				new SalesRecord("Jones", formatSales(9213), "USA", "Qtr 4"),
				new SalesRecord("Jones", formatSales(7433), "UK", "Qtr 1"),
				new SalesRecord("Brown", formatSales(3255), "USA", "Qtr 2"),
				new SalesRecord("Williams", formatSales(14867), "USA", "Qtr 3"),
				new SalesRecord("Williams", formatSales(19302), "UK", "Qtr 4"),
				new SalesRecord("Smith", formatSales(9698), "USA", "Qtr 1"));
	}

	private String formatSales(double amount) {
		String formatted = String.format(Locale.US, "$%,.2f", amount);
		LOGGER.info("Formatted sales {} to {}", amount, formatted);
		return formatted;
	}
}
