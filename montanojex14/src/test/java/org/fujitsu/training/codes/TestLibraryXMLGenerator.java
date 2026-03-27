package org.fujitsu.training.codes;

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
		String filename = "./src/main/resources/files/library.xml";
		Book book = new Book();
		
		book.setId("2003-Blanken");
		book.setTitle("Intelligent XML Search");
		book.setEditor("Henk A. Blanken et al.");
		book.setPublisher("Springer Verlag");
		
		Number num = new Number();
		num.setNum(1);
		
		List<Object> mixed = new ArrayList<>();
		mixed.add("24");         
		mixed.add(num);
		
		Volume vol = new Volume();
		vol.setContent(mixed);
		
		Journal journ = new Journal();
		journ.setId("TODS_1_2003");
		journ.setPubYear(2003);
		journ.setTitle("ACM Transactions on Databases");
		journ.setVol(vol);
		
		Misc misc = new Misc();
		List<String> auth = new ArrayList<>();
		misc.setDiplId("Dipl2002-12");
		misc.setTrId("TR2002-01-04");
		auth.add("U.Known");
		auth.add("K.Known");
		misc.setAuthor(auth);
		misc.setTitle("The Diploma Thesis that didn't appear");
		misc.setYear(2002);
		misc.setPages(0);
		
		Library lib = new Library();
		List<Object> elements = new ArrayList<>();
		elements.add(book);
		elements.add(journ);
		elements.add(misc);
		lib.setLib(elements);
		lg.marshallPublications(filename, lib);
	}
	
	@Test
	public void testUnmarshallPublications() {
		String filename = "./src/main/resources/files/library.xml";
		Library lib = lg.unmarshallPublications(filename);
		System.out.print(lib);
	}
}
