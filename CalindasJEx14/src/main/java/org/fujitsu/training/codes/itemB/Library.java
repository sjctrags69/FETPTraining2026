package org.fujitsu.training.codes.itemB;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "library")
public class Library {

    private List<Book> books;

    public Library() {
    }

    @XmlElementWrapper(name = "books") 
    @XmlElement(name = "book")          
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}