package org.fujitsu.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLibrary {
    private LibraryXMLGenerator generator;

    @BeforeEach
    public void setup() {
        generator = new LibraryXMLGenerator();
    }

    @AfterEach
    public void teardown() {
        generator = null;
    }

    @Test
    public void testMarshallPublications() {
        Book book = new Book();
        book.setId("2003-Blanken");
        book.setTitle("Intelligent XML Search");
        book.getAuthors().add("Henk A. Blanken");
        book.setPublisher("Springer Verlag");
        book.setYear(2003);

        Journal journal = new Journal();
        journal.setId("TODS_1_2003");
        journal.setPubYear(2003);
        journal.setTitle("ACM Transactions on Databases");
        journal.setVolume(24);
        journal.setNumber(1);
        journal.setYear(2003);

        Misc misc = new Misc();
        misc.setId("TR2002-01-04");
        misc.setTitle("The Diploma Thesis that didn't appear");
        misc.getAuthors().add("U. Known");
        misc.setYear(2002);
        misc.setPages(0);

        String filename = "./src/main/resources/files/library.xml";

        generator.marshallPublications(filename, book, journal, misc);
    }

    @Test
    public void testUnmarshallPublications() {
        String filename = "./src/main/resources/files//library.xml";

        Library library = generator.unmarshallPublications(filename);
        System.out.println(library);
    }
}