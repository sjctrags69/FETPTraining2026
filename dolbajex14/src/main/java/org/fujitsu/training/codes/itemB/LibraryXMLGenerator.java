package org.fujitsu.training.codes.itemB;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class LibraryXMLGenerator {

	private static final Logger LOGGER = LogManager.getLogger(LibraryXMLGenerator.class);
	private static final String DEFAULT_RESOURCE_FOLDER = "src/main/resources/files";

	public void marshallPublications(String filename, Object... objects) {
		LOGGER.info("Start marshalling to {}", filename);
		try (FileWriter writer = new FileWriter(resolveFile(filename))) {
			Library library = new Library();
			List<Publication> publications = Arrays.stream(objects)
					.filter(Publication.class::isInstance)
					.map(Publication.class::cast)
					.collect(Collectors.toList());
			publications.forEach(library::addPublication);

			JAXBContext context = JAXBContext.newInstance(Library.class, Book.class, Journal.class, Misc.class);
			Marshaller xmlCreator = context.createMarshaller();
			xmlCreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			xmlCreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			xmlCreator.marshal(library, writer);
			LOGGER.info("Finished marshalling {} entries", publications.size());
		} catch (NullPointerException ex) {
			LOGGER.error("Null value error during marshalling", ex);
			throw new RuntimeException("Failed to marshall publications", ex);
		} catch (IllegalArgumentException ex) {
			LOGGER.error("Invalid argument during marshalling", ex);
			throw new RuntimeException("Failed to marshall publications", ex);
		} catch (SecurityException ex) {
			LOGGER.error("Security error during marshalling", ex);
			throw new RuntimeException("Failed to marshall publications", ex);
		} catch (IOException ex) {
			LOGGER.error("File write error during marshalling", ex);
			throw new RuntimeException("Failed to marshall publications", ex);
		} catch (JAXBException ex) {
			LOGGER.error("JAXB error during marshalling", ex);
			throw new RuntimeException("Failed to marshall publications", ex);
		} catch (RuntimeException ex) {
			LOGGER.error("Unexpected runtime error during marshalling", ex);
			throw new RuntimeException("Failed to marshall publications", ex);
		}
	}

	public Library unmarshallPublications(String filename) {
		LOGGER.info("Start unmarshalling from {}", filename);
		try (FileReader reader = new FileReader(resolveFile(filename))) {
			JAXBContext context = JAXBContext.newInstance(Library.class, Book.class, Journal.class, Misc.class);
			Unmarshaller parser = context.createUnmarshaller();
			Library library = Optional.ofNullable((Library) parser.unmarshal(reader))
					.orElseThrow(() -> new RuntimeException("Failed to unmarshall publications"));
			int count = library.getPublications() == null ? 0 : library.getPublications().size();
			LOGGER.info("Finished unmarshalling {} entries", count);
			if (library.getPublications() != null) {
				library.getPublications().forEach(publication -> LOGGER.info(
						"Entry type: {}, id: {}, title: {}",
						publication.getClass().getSimpleName(),
						publication.getId(),
						publication.getTitle()));
			}
			return library;
		} catch (NullPointerException ex) {
			LOGGER.error("Null value error during unmarshalling", ex);
			throw new RuntimeException("Failed to unmarshall publications", ex);
		} catch (IllegalArgumentException ex) {
			LOGGER.error("Invalid argument during unmarshalling", ex);
			throw new RuntimeException("Failed to unmarshall publications", ex);
		} catch (ClassCastException ex) {
			LOGGER.error("Unexpected XML root type during unmarshalling", ex);
			throw new RuntimeException("Failed to unmarshall publications", ex);
		} catch (SecurityException ex) {
			LOGGER.error("Security error during unmarshalling", ex);
			throw new RuntimeException("Failed to unmarshall publications", ex);
		} catch (IOException ex) {
			LOGGER.error("File read error during unmarshalling", ex);
			throw new RuntimeException("Failed to unmarshall publications", ex);
		} catch (JAXBException ex) {
			LOGGER.error("JAXB error during unmarshalling", ex);
			throw new RuntimeException("Failed to unmarshall publications", ex);
		} catch (RuntimeException ex) {
			LOGGER.error("Unexpected runtime error during unmarshalling", ex);
			throw new RuntimeException("Failed to unmarshall publications", ex);
		}
	}

	private File resolveFile(String filename) {
		File directFile = new File(filename);
		if (directFile.isAbsolute()) {
			LOGGER.info("Use absolute file {}", directFile.getPath());
			return directFile;
		}
		File resourceFile = new File(DEFAULT_RESOURCE_FOLDER, filename);
		LOGGER.info("Use resource file {}", resourceFile.getPath());
		return resourceFile;
	}
}
