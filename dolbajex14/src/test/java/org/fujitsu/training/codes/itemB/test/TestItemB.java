package org.fujitsu.training.codes.itemB.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fujitsu.training.codes.itemB.Book;
import org.fujitsu.training.codes.itemB.Journal;
import org.fujitsu.training.codes.itemB.Library;
import org.fujitsu.training.codes.itemB.LibraryXMLGenerator;
import org.fujitsu.training.codes.itemB.Misc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestItemB {

	private static final Logger LOGGER = LogManager.getLogger(TestItemB.class);
	private LibraryXMLGenerator generator;

	@BeforeEach
	public void setup() {
		LOGGER.info("Setup TestItemB");
		generator = new LibraryXMLGenerator();
	}

	@AfterEach
	public void teardown() {
		LOGGER.info("Teardown TestItemB");
		generator = null;
	}

	@Order(1)
	@Test
	public void sunnyDayMarshallCreatesLibraryXml() throws IOException {
		LOGGER.info("Run sunnyDayMarshallCreatesLibraryXml");

		// Given
		String filename = "library-sunny-1.xml";
		Path outputPath = Paths.get("src", "main", "resources", "files", filename);
		Files.deleteIfExists(outputPath);

		Book book = new Book("2003-Blanken", "Intelligent XML Search", "Henk A. Blanken et al.", "Springer Verlag");
		Journal journal = new Journal("TODS_1_2003", "ACM Transactions on Databases", 2003, 24, 1);
		Misc misc = new Misc("Dipl2002-12", "The Diploma Thesis that did not appear", 2002, 0);
		misc.getAuthors().add("U. Known");

		// When
		generator.marshallPublications(filename, book, journal, misc);

		// Then
		assertTrue(Files.exists(outputPath));

		String xml = Files.readString(outputPath, StandardCharsets.UTF_8);
		assertTrue(xml.contains("<library>"));
		assertTrue(xml.contains("<book"));
		assertTrue(xml.contains("<journal"));
		assertTrue(xml.contains("<misc"));
	}

	@Order(2)
	@Test
	public void sunnyDayUnmarshallReadsAllEntries() throws IOException {
		LOGGER.info("Run sunnyDayUnmarshallReadsAllEntries");

		// Given
		String filename = "library-sunny-2.xml";
		Path outputPath = Paths.get("src", "main", "resources", "files", filename);
		Files.deleteIfExists(outputPath);
		Book book = new Book("2003-Blanken", "Intelligent XML Search", "Henk A. Blanken et al.", "Springer Verlag");
		Journal journal = new Journal("TODS_1_2003", "ACM Transactions on Databases", 2003, 24, 1);
		Misc misc = new Misc("Dipl2002-12", "The Diploma Thesis that did not appear", 2002, 0);
		misc.getAuthors().add("U. Known");
		generator.marshallPublications(filename, book, journal, misc);

		// When
		Library library = generator.unmarshallPublications(filename);

		// Then
		assertNotNull(library);
		assertNotNull(library.getPublications());
		assertEquals(3, library.getPublications().size());
	}

	@Order(3)
	@Test
	public void rainyDayUnmarshallMissingFileThrowsException() {
		LOGGER.info("Run rainyDayUnmarshallMissingFileThrowsException");

		// Given
		String filename = "missing-library-file.xml";

		// Then
		assertThrows(RuntimeException.class, () -> {
			// When
			generator.unmarshallPublications(filename);
		});
	}

	@Order(4)
	@Test
	public void rainyDayUnmarshallInvalidXmlThrowsException() throws IOException {
		LOGGER.info("Run rainyDayUnmarshallInvalidXmlThrowsException");

		// Given
		String filename = "library-rainy-invalid.xml";
		Path outputPath = Paths.get("src", "main", "resources", "files", filename);
		Files.writeString(outputPath, "<library><book id=\"1\"><title>Broken", StandardCharsets.UTF_8);

		// Then
		assertThrows(RuntimeException.class, () -> {
			// When
			generator.unmarshallPublications(filename);
		});
	}
}
