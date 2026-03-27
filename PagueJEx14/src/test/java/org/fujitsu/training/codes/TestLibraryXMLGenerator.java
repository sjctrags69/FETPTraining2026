package org.fujitsu.training.codes;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLibraryXMLGenerator {

	private LibraryXMLGenerator lg;
	
	@BeforeEach
	public void setup() {
		lg = new LibraryXMLGenerator();
	}
	
	@AfterEach
	public void teardown() {
		lg = null;
	}
	
	@Test
	public void testMarshallPublications() {
		Book book = new Book();
		book.setId("2003-Blanken");
		book.setTitle("Intelligent XML Search");
		book.setEditor("Henk A. Blanken et al.");
		book.setPublisher("Springer Verlag");
		
		Journal journal = new Journal();
		journal.setId("TODS_1_2003");
		journal.setPublYear("2003");
		journal.setTitle("ACM Transactions on Databases");
		journal.setVolume(24);
		journal.setNumber(1);
		
		Misc misc = new Misc();
		misc.setId("Dipl2002-12");
		
		List<String> authors = new ArrayList<>();
		authors.add("U. Known");
		misc.setAuthor(authors);
		
		misc.setTitle("The Diploma Thesis that didn't appear");
		misc.setYear(2002);
		misc.setPages(0);
		
		String filename = "./src/main/resources/files/library.xml";
		
		assertTrue(lg.marshallPublications(filename, book, journal, misc));
	}
	
	@Test
	public void testUnmarshallPublications() {
		String filename = "./src/main/resources/files/library.xml";
		Library lib = lg.unmarshallPublications(filename);
		
		System.out.println(lib);
		assertNotNull(lib);
	}
}