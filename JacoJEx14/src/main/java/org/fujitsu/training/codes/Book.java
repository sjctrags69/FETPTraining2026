package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

	@XmlAttribute
	private String id;

	@XmlElement
	private String title;

	@XmlElement
	private String editor;

	@XmlElement
	private String publisher;

	public Book() {
	}

	public Book(String id, String title, String editor, String publisher) {
		this.id = id;
		this.title = title;
		this.editor = editor;
		this.publisher = publisher;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getEditor() {
		return editor;
	}

	public String getPublisher() {
		return publisher;
	}
}