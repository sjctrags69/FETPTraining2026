package org.fujitsu.training.codes.xml.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.fujitsu.training.codes.xml.Book;
import org.fujitsu.training.codes.xml.Journal;
import org.fujitsu.training.codes.xml.Library;
import org.fujitsu.training.codes.xml.LibraryXMLGenerator;
import org.fujitsu.training.codes.xml.Misc;
import org.fujitsu.training.codes.xml.Volume;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLibraryXMLGenerator {
	private Book book;
	private Volume volume;
	private Journal journal;
	private Misc misc;
	private Library library;
	private LibraryXMLGenerator process;

	@BeforeEach
	public void setup() {
		book = new Book();
		volume = new Volume();
		misc = new Misc();
		journal = new Journal();
		library = new Library();
		process = new LibraryXMLGenerator();
	}

	@AfterEach
	public void teardown() {
		book = null;
		volume = null;
		misc = null;
		journal = null;
		library = null;
		process = null;
	}

	@Test
	public void testMarshalPublications() {
		// ===== CREATE BOOK =====

		book.setId("2003-Blanken");
		book.setTitle("Intelligent XML Search");
		book.setEditor("Henk A. Blanken et al.");
		book.setPublisher("Springer Verlag");

		// ===== CREATE JOURNAL =====

		volume.setNumber(1);

		journal.setId("TODS_1_2003");
		journal.setPublYear("2003");
		journal.setTitle("ACM Transactions on Databases");
		journal.setVolume(volume);

		// ===== CREATE MISC =====

		misc.setId("Dipl2002-12");
		misc.setAuthor(Arrays.asList("U. Known"));
		misc.setTitle("The Diploma Thesis that didn’t appear");
		misc.setYear(2002);
		misc.setPages(0);

		// ===== ADD TO LIBRARY =====
		List<Object> list = new ArrayList<>();
		list.add(book);
		list.add(journal);
		list.add(misc);

		library.setPublications(list);

		// ===== MARSHALL =====

		boolean result = process.marshallPublications("./src/main/resources/files/library.xml", library);
		assertTrue(result);
	}

}
