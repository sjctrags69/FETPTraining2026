package org.fujitsu.training.codes;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "library")
public class Library {

	private List<Book> books;
	private List<Journal> journals;
	private List<Misc> miscs;

	@XmlElement(name = "book")
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@XmlElement(name = "journal")
	public List<Journal> getJournals() {
		return journals;
	}

	public void setJournals(List<Journal> journals) {
		this.journals = journals;
	}

	@XmlElement(name = "misc")
	public List<Misc> getMiscs() {
		return miscs;
	}

	public void setMiscs(List<Misc> miscs) {
		this.miscs = miscs;
	}
}