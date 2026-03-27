package org.fujitsu.training.codes.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class LibraryXMLGenerator {

    public boolean marshallPublications(String filename, Library rec) {
        try {
            JAXBContext context = JAXBContext.newInstance(
                    Library.class, Book.class, Journal.class, Misc.class);

            Marshaller XMLCreator = context.createMarshaller();
            XMLCreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            XMLCreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            FileWriter fw = new FileWriter(filename);
            XMLCreator.marshal(rec, fw);

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
            JAXBContext context = JAXBContext.newInstance(
                    Library.class, Book.class, Journal.class, Misc.class);

            Unmarshaller parser = context.createUnmarshaller();

            Library rec = (Library) parser.unmarshal(new FileReader(filename));
            return rec;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}