package org.fujitsu.training.codes;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.fujitsu.training.codes.itema.Book;
import org.fujitsu.training.codes.itema.Journal;
import org.fujitsu.training.codes.itema.Library;
import org.fujitsu.training.codes.itema.LibraryXMLGenerator;
import org.fujitsu.training.codes.itema.Misc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLibraryXMLGenerator {
	private LibraryXMLGenerator lib;

	@BeforeEach
	public void setup() {
		lib = new LibraryXMLGenerator();
	}

	@AfterEach
	public void teardown() {
		lib = null;
	}

	@Test
	public void testMarshallPublications() {
		Journal journal = new Journal("TODS_1_2003", 2003, "ACM Transactions on Databases", 24, 1);
		Misc misc = new Misc("Dipl2002-12", "TR2002-01-04", "U. Known",
				"The Diploma Thesis that didn't appear", 2002,
				0);
		Book book = new Book("2003-Blanken", "Intelligent XML Search", 
				"Henk A. Blanken et al.", "Springer Verlag");
		String filename = "./src/main/resources/files/library.xml";
		Boolean actual = lib.marshallPublications(filename, book, journal, misc);
		assertTrue(actual);
	}

	@Test
	public void testUnmarshallPublications() {
		String filename = "./src/main/resources/files/library.xml";
		Library actual = lib.unmarshallPublications(filename);
		assertNotNull(actual);
	}

}
