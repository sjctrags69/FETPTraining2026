package org.fujitsu.training.codes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class LibraryXMLGenerator {

	public boolean marshallPublications(String filename, Object... objects) {
		try {
			Library library = new Library();

			List<Book> books = new ArrayList<>();
			List<Journal> journals = new ArrayList<>();
			List<Misc> miscs = new ArrayList<>();

			for (Object obj : objects) {
				if (obj instanceof Book) {
					books.add((Book) obj);
				} else if (obj instanceof Journal) {
					journals.add((Journal) obj);
				} else if (obj instanceof Misc) {
					miscs.add((Misc) obj);
				}
			}

			library.setBooks(books);
			library.setJournals(journals);
			library.setMiscs(miscs);

			JAXBContext context = JAXBContext.newInstance(Book.class, Journal.class, Misc.class, Library.class);
			Marshaller XMLcreator = context.createMarshaller();
			XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			FileWriter fw = new FileWriter(filename);
			XMLcreator.marshal(library, fw);
			fw.close();

			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public Library unmarshallPublications(String filename) {
		try {
			JAXBContext context = JAXBContext.newInstance(Book.class, Journal.class, Misc.class, Library.class);
			Unmarshaller parser = context.createUnmarshaller();
			Library library = (Library) parser.unmarshal(new FileReader(filename));
			return library;
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return null;
	}
}