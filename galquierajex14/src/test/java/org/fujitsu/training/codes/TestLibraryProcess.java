package org.fujitsu.training.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLibraryProcess {
	private LibraryProcess lp;
	
	@BeforeEach
	public void setup() {
		lp = new LibraryProcess();
	}
	
	@AfterEach
	public void teardown() {
		lp = null;
	}
	
	@Test
	public void testCreateLibraryXML() {
		Book book = new Book();
		book.setId("2003-Blanken");
		book.setTitle("Intelligent XML Search");
		book.setEditor("Henk A. Blanken et al.");
		book.setPublisher("Springer Verlag");
		
		Journal journal = new Journal();
		journal.setId("TODS_1_2003");
		journal.setPublYear(2003);
		journal.setTitle("ACM Transactions on Databases");
		journal.setVolume(24);
		journal.setNumber(1);
		
		Misc misc = new Misc();
		misc.setId("TR2002-01-04");
		misc.setAuthor("U. Known");
		misc.setTitle("The Diploma Thesis that didn’t appear");
		misc.setYear(2002);
		misc.setPages(0);
		
		List<Object> recs = new ArrayList<>(Arrays.asList(book, journal, misc));
		
		Library library = new Library();
		library.setPublications(recs);
		
		String filename = "./src/main/resources/files/library.xml";
		
		lp.createLibraryXML(filename, library);
	}
	
	@Test
	public void testParseLibraryXML() {
		String filename = "./src/main/resources/files/library.xml";
		
		Library recs = lp.parseLibraryXML(filename);
		
		if (recs != null && recs.getPublications() != null) {
			System.out.println(recs.getPublications().toString());
		}
	}
}