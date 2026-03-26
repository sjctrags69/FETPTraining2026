package org.fujitsu.training.codes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class LibraryXMLGenerator {

    public boolean marshallPublications(String filename, Publication... objects) {
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class, Book.class, Journal.class, Misc.class);
            Marshaller XMLcreator = context.createMarshaller();
            FileWriter fw = new FileWriter(filename);

            Library library = new Library();
            library.getEntries().addAll(Arrays.asList(objects));

            XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            XMLcreator.marshal(library, fw);
            return true;
        }
        catch (IOException e) {
        	System.err.println("JAXB marshalling failed for file: " + filename + " | " + e.getMessage());
        }
        catch (JAXBException e) {
        	System.err.println("JAXB error while writing XML file: " + filename + " | " + e.getMessage());
        }
        return false;
    }

    public Library unmarshallPublications(String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class, Book.class, Journal.class, Misc.class);
            Unmarshaller parser = context.createUnmarshaller();
            Library library = (Library) parser.unmarshal(new FileReader(filename));
            return library;
        }
        catch (FileNotFoundException e) {
        	System.err.println("File not found: " + filename + " | " + e.getMessage());
        }
        catch (JAXBException e) {
        	System.err.println("JAXB error while reading XML file: " + filename + " | " + e.getMessage());
        }
        return null;
    }
}