package org.fujitsu.training.codes.itemB;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book {

	private String id;
	private String title;
	private String editor;
	private String publisher;

	@XmlAttribute(name = "id", required = true)
	public String getId() {
		return id;
	}

	@XmlElement(name = "title", nillable = false, required = true)
	public String getTitle() {
		return title;
	}

	@XmlElement(name = "editor", nillable = false, required = true)
	public String getEditor() {
		return editor;
	}

	@XmlElement(name = "publisher", nillable = false, required = true)
	public String getPublisher() {
		return publisher;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
