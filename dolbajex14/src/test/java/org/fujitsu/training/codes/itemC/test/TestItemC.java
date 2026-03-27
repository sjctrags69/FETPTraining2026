package org.fujitsu.training.codes.itemC.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fujitsu.training.codes.itemC.MyDayXMLValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestItemC {

	private static final Logger LOGGER = LogManager.getLogger(TestItemC.class);
	private MyDayXMLValidator validator;

	@BeforeEach
	public void setup() {
		LOGGER.info("Setup TestItemC");
		validator = new MyDayXMLValidator();
	}

	@AfterEach
	public void teardown() {
		LOGGER.info("Teardown TestItemC");
		validator = null;
	}

	@Order(1)
	@Test
	public void sunnyDayValidateMyday1WithDTD() {
		LOGGER.info("Run sunnyDayValidateMyday1WithDTD");

		// Given
		String xmlFilename = "myday1.xml";

		// When
		boolean result = validator.validateWithDTD(xmlFilename);

		// Then
		assertTrue(result);
	}

	@Order(2)
	@Test
	public void sunnyDayValidateMyday3WithXSD() {
		LOGGER.info("Run sunnyDayValidateMyday3WithXSD");

		// Given
		String xmlFilename = "myday3.xml";
		String xsdFilename = "myday.xsd";

		// When
		boolean result = validator.validateWithXSD(xmlFilename, xsdFilename);

		// Then
		assertTrue(result);
	}

	@Order(3)
	@Test
	public void rainyDayInvalidMydayWithDTD() throws IOException {
		LOGGER.info("Run rainyDayInvalidMydayWithDTD");

		// Given
		String xmlFilename = "myday-invalid.xml";
		Path outputPath = Paths.get("src", "main", "resources", "files", xmlFilename);
		Files.writeString(outputPath, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><a><date><day>5</day></date></a>",
				StandardCharsets.UTF_8);

		// When
		boolean result = validator.validateWithDTD(xmlFilename);

		// Then
		assertFalse(result);
	}
}
