package org.fujitsu.training.codes;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LibraryXMLGenerator {

	private static final Logger log = LogManager.getLogger(LibraryXMLGenerator.class);

	public void marshallPublications(String filename, Object... objects) {
		try {
			Library library = new Library();
			library.getPublications().addAll(Arrays.asList(objects));

			JAXBContext context = JAXBContext.newInstance(Library.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(library, new File(filename));

			log.info("Marshalled {} publication(s) to {}", objects.length, filename);
		} catch (JAXBException e) {
			log.error("Error marshalling publications", e);
		}
	}

	public Library unmarshallPublications(String filename) {
		Library library = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Library.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			library = (Library) unmarshaller.unmarshal(new File(filename));

			log.info("Unmarshalled {} publication(s) from {}", library.getPublications().size(), filename);
			logDetails(library.getPublications());
		} catch (JAXBException e) {
			log.error("Error unmarshalling publications", e);
		}
		return library;
	}

	private void logDetails(List<Object> publications) {
		for (Object pub : publications) {
			if (pub instanceof Book) {
				Book book = (Book) pub;
				log.info("Book     | id: {} | title: {} | editor: {} | publisher: {}", book.getId(), book.getTitle(),
						book.getEditor(), book.getPublisher());
			} else if (pub instanceof Journal) {
				Journal journal = (Journal) pub;
				log.info("Journal  | id: {} | publ_year: {} | title: {} | volume: {}", journal.getId(),
						journal.getPublYear(), journal.getTitle(), journal.getVolume());
			} else if (pub instanceof Misc) {
				Misc misc = (Misc) pub;
				log.info("Misc     | id: {} | authors: {} | title: {} | year: {} | pages: {}", misc.getId(),
						misc.getAuthors(), misc.getTitle(), misc.getYear(), misc.getPages());
			}
		}
	}
}