package org.fujitsu.training.codes.itemB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book extends Publication {

	private static final Logger LOGGER = LogManager.getLogger(Book.class);

	@XmlElement(name = "editor")
	private String editor;

	@XmlElement(name = "publisher")
	private String publisher;

	public Book() {
		super();
		LOGGER.debug("Create Book");
	}

	public Book(String id, String title, String editor, String publisher) {
		super(id, title);
		this.editor = editor;
		this.publisher = publisher;
		LOGGER.info("Create Book {}", id);
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		LOGGER.info("Set editor {}", editor);
		this.editor = editor;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		LOGGER.info("Set publisher {}", publisher);
		this.publisher = publisher;
	}
}
