package org.fujitsu.training.codes.itemB;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLibraryXMLGenerator {
	private LibraryXMLGenerator gen;

	@BeforeEach
	public void setup() {
		gen = new LibraryXMLGenerator();
	}

	@AfterEach
	public void teardown() {
		gen = null;
	}

	@Test
	public void testMarshallPublications() {
		String filename = "./src/main/resources/files/library.xml";

		Book book = new Book();
		book.setId("2003-Blanken");
		book.setTitle("Intelligent XML Search");
		book.setEditor("Henk A. Blanken et al.");
		book.setPublisher("Springer Verlag");

		Journal journal = new Journal();
		journal.setId("TODS_1_2003");
		journal.setPubl_year(2003);
		journal.setTitle("ACM Transactions on Databases");
		journal.setVolume(24);
		journal.setNumber(1);

		Misc misc = new Misc();
		misc.setDipId("Dipl2002-12");
		misc.setTrId("TR2002-01-04");
		misc.setAuthors(Arrays.asList("U. Known"));
		misc.setTitle("The Diploma Thesis that didn't appear");
		misc.setYear(2002);
		misc.setPages(0);

		Library library = new Library();
		library.setBooks(Arrays.asList(book));
		library.setJournals(Arrays.asList(journal));
		library.setMiscs(Arrays.asList(misc));

		gen.marshallPublications(filename, library);
	}

	@Test
	public void testUnmarshallPublications() {
		String filename = "./src/main/resources/files/library.xml";

		gen.unmarshallPublications(filename);
	}
}
