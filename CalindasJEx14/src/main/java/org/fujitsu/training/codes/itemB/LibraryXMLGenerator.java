package org.fujitsu.training.codes.itemB;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class LibraryXMLGenerator {

    public static void marshalPublications(String filename, Library library) {
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(library, new File(filename));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


	public static Library unmarshalPublications(String filename) {
	    try {
	        JAXBContext context = JAXBContext.newInstance(Library.class);
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	
	        return (Library) unmarshaller.unmarshal(new File(filename));
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}