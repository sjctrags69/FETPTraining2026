package org.fujitsu.training.codes.itema;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import jakarta.xml.bind.UnmarshalException;
import jakarta.xml.bind.Unmarshaller;

public class LibraryXMLGenerator {
	private static final Logger LOG = LogManager.getLogger("libraryXMLLogger");

	public boolean marshallPublications(String filename, Object... objects) {
		LOG.info("Executing method marshallPublications() with parameters String {} and params arg Object {}", filename, objects);
		try {
			Library library = new Library();
			List<Object> inputs = new ArrayList<>(Arrays.asList(objects));
			library.setPublications(inputs);		
			JAXBContext context = 
					JAXBContext.newInstance(Library.class, Misc.class, Journal.class, Book.class);
			Marshaller XMLcreator = context.createMarshaller();
			XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			FileWriter fw = new FileWriter(filename);
			XMLcreator.marshal(library, fw);
			LOG.info("Ending method marshallPublications with a return value {} in success", true);
			return true;
		} catch (PropertyException | IllegalArgumentException ex) {
			LOG.fatal(ex.getMessage());
		} catch (IOException ex) {
			LOG.fatal(ex.getMessage());
		} catch (JAXBException ex) {
			LOG.fatal(ex.getMessage());
		}
		LOG.info("Ending method marshallPublications with a return value {} in failure", false);
		return false;
	}

	public Library unmarshallPublications(String filename) {
		LOG.info("Executing method unmarshallPublications() with a parameter String {}", filename);
		try {
			JAXBContext context = 
					JAXBContext.newInstance(Library.class, Misc.class, Journal.class, Book.class);

			Unmarshaller parser = context.createUnmarshaller();
			Library rec = (Library) parser.unmarshal(new FileReader(filename));
			LOG.info("Ending method unmarshallPublications() in failure with a return value {}", rec);
			return rec;
		} catch (UnmarshalException | IllegalArgumentException | FileNotFoundException ex) {
			LOG.fatal(ex.getMessage());
		} catch (JAXBException ex) {
			LOG.fatal(ex.getMessage());
		}
		LOG.info("Ending method unmarshallPublications() in failure with a return value null");
		return null;
	}
}
