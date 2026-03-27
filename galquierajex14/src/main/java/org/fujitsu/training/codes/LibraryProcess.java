package org.fujitsu.training.codes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class LibraryProcess {
	public boolean createLibraryXML(String filename, Library rec) {
		try {
			JAXBContext context = JAXBContext.newInstance(Library.class, Book.class, Journal.class, Misc.class);
			Marshaller XMLCreator = context.createMarshaller();
			FileWriter fw = new FileWriter(filename);
			XMLCreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLCreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			XMLCreator.marshal(rec, fw);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Library parseLibraryXML(String filename) {
		try {
			JAXBContext context = JAXBContext.newInstance(Library.class, Book.class, Journal.class, Misc.class);
			Unmarshaller parser = context.createUnmarshaller();
			Library rec = (Library) parser.unmarshal(new FileReader(filename));
			return rec;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}