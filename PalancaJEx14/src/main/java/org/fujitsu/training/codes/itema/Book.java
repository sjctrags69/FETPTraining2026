package org.fujitsu.training.codes.itema;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book {
	private static final Logger LOG = LogManager.getLogger("libraryXMLLogger");
	private String id;
	private String title;
	private String editor;
	private String publisher;
	
	public Book() {
	}
	
	public Book(String id, String title, String editor, String publisher) {
		super();
		this.id = id;
		this.title = title;
		this.editor = editor;
		this.publisher = publisher;
		LOG.info("Instantiated Book() object");
	}

	@XmlAttribute(name = "id", required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "title", required = true, nillable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "editor", required = true, nillable = false)
	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	@XmlElement(name = "publisher", required = true, nillable = false)
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
