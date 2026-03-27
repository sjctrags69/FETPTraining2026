package org.fujitsu.training.codes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLibraryXMLGenerator {

	private static final String FILENAME = "target/library-output.xml";

	private LibraryXMLGenerator generator;
	private Book book;
	private Journal journal;
	private Misc misc;

	@BeforeEach
	public void setUp() {
		new File("target").mkdirs();

		generator = new LibraryXMLGenerator();

		book = new Book("2003-Blanken", "Intelligent XML Search", "Henk A. Blanken et al.", "Springer Verlag");

		journal = new Journal("TODS_1_2003", "2003", "ACM Transactions on Databases", "24");

		misc = new Misc("Dipl2002-12", List.of("U. Known"), "The Diploma Thesis that didn't appear", "2002", "0");
	}

	@AfterEach
	public void tearDown() {
		generator = null;
		book = null;
		journal = null;
		misc = null;
	}

	@Test
	public void testMarshallCreatesFile() {
		generator.marshallPublications(FILENAME, book, journal, misc);

		assertTrue(new File(FILENAME).exists());
	}

	@Test
	public void testMarshallContainsThreePublications() {
		generator.marshallPublications(FILENAME, book, journal, misc);

		Library result = generator.unmarshallPublications(FILENAME);

		assertNotNull(result);
		assertEquals(3, result.getPublications().size());
	}

	@Test
	public void testUnmarshallBook() {
		generator.marshallPublications(FILENAME, book);

		Library result = generator.unmarshallPublications(FILENAME);
		Book actual = (Book) result.getPublications().get(0);

		assertEquals("2003-Blanken", actual.getId());
		assertEquals("Intelligent XML Search", actual.getTitle());
		assertEquals("Henk A. Blanken et al.", actual.getEditor());
		assertEquals("Springer Verlag", actual.getPublisher());
	}

	@Test
	public void testUnmarshallJournal() {
		generator.marshallPublications(FILENAME, journal);

		Library result = generator.unmarshallPublications(FILENAME);
		Journal actual = (Journal) result.getPublications().get(0);

		assertEquals("TODS_1_2003", actual.getId());
		assertEquals("2003", actual.getPublYear());
		assertEquals("ACM Transactions on Databases", actual.getTitle());
		assertEquals("24", actual.getVolume());
	}

	@Test
	public void testUnmarshallMisc() {
		generator.marshallPublications(FILENAME, misc);

		Library result = generator.unmarshallPublications(FILENAME);
		Misc actual = (Misc) result.getPublications().get(0);

		assertEquals("Dipl2002-12", actual.getId());
		assertEquals("The Diploma Thesis that didn't appear", actual.getTitle());
		assertEquals("2002", actual.getYear());
		assertEquals("0", actual.getPages());
		assertTrue(actual.getAuthors().contains("U. Known"));
	}

	@Test
	public void testUnmarshallMiscMultipleAuthors() {
		Misc multiAuthor = new Misc("TR2002-01-04", List.of("Author One", "Author Two", "Author Three"),
				"Multi Author Paper", "2002", "10");

		generator.marshallPublications(FILENAME, multiAuthor);

		Library result = generator.unmarshallPublications(FILENAME);
		Misc actual = (Misc) result.getPublications().get(0);

		assertEquals(3, actual.getAuthors().size());
	}

	@Test
	public void testUnmarshallPreservesOrder() {
		generator.marshallPublications(FILENAME, book, journal, misc);

		Library result = generator.unmarshallPublications(FILENAME);
		List<Object> pubs = result.getPublications();

		assertTrue(pubs.get(0) instanceof Book);
		assertTrue(pubs.get(1) instanceof Journal);
		assertTrue(pubs.get(2) instanceof Misc);
	}
}