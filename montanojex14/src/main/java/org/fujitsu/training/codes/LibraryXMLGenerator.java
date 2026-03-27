package org.fujitsu.training.codes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class LibraryXMLGenerator {
	public boolean marshallPublications(String filename, Library lib) {
		try {
			JAXBContext context = JAXBContext.newInstance(Library.class);
			Marshaller XMLcreator = context.createMarshaller();
			XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLcreator.setProperty(Marshaller.JAXB_FRAGMENT, true);
			XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			FileWriter fw = new FileWriter(filename);
			fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
	        fw.write("<!DOCTYPE library SYSTEM \"library.dtd\">\n");
			XMLcreator.marshal(lib, fw);
			return true;
		} catch(IOException ex) {
			ex.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Library unmarshallPublications(String filename) {
		try {
			JAXBContext context = JAXBContext.newInstance(Library.class);
			Unmarshaller parser = context.createUnmarshaller();
			Library lib = (Library) parser.unmarshal(new FileReader(filename));
			return lib;
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
