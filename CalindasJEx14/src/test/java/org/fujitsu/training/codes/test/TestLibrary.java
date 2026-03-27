package org.fujitsu.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.StringWriter;

import org.fujitsu.training.codes.itemB.Book;
import org.fujitsu.training.codes.itemB.Library;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

class TestLibrary {

    private static Library library;

    @BeforeAll
    static void setup() {
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            library = (Library) unmarshaller.unmarshal(new File("library.xml"));
            System.out.println("Unmarshalling completed successfully.");
        } catch (JAXBException e) {
            fail("Failed to unmarshal library.xml: " + e.getMessage());
        }
    }

    @AfterAll
    static void cleanup() {
        library = null;
        System.out.println("Cleanup completed. Library object set to null.");
    }

    @Test
    void testLibraryNotNull() {
        assertNotNull(library, "Library should not be null after unmarshalling");
    }

    @Test
    void testLibraryContainsBooks() {
        assertNotNull(library.getBooks(), "Library should contain a book list");
        assertTrue(library.getBooks().size() > 0, "Library should have at least one book");
    }

    @Test
    void testFirstBookData() {
        Book firstBook = library.getBooks().get(0);
        assertNotNull(firstBook.getTitle(), "Book title should not be null");
        assertNotNull(firstBook.getAuthor(), "Book author should not be null");
        assertTrue(firstBook.getYear() > 0, "Book year should be greater than 0");
    }

    @Test
    void testMarshalLibraryToXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(library, sw);

            String xmlOutput = sw.toString();
            assertNotNull(xmlOutput);
            assertTrue(xmlOutput.contains("<library>"), "Marshalled XML should contain <library> root");
        } catch (JAXBException e) {
            fail("Failed to marshal library to XML: " + e.getMessage());
        }
    }
}