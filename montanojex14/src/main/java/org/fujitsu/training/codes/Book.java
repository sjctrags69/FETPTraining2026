package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "book")
@XmlType(propOrder = {"title", "editor", "publisher"})
public class Book {
	private String id;
	private String title;
	private String editor;
	private String publisher;
	
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
	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}
	@XmlElement(name = "title", required = true)
	public String getTitle() {
		return title;
	}
	@XmlElement(name = "editor", required = true)
	public String getEditor() {
		return editor;
	}
	@XmlElement(name = "publisher", required = true)
	public String getPublisher() {
		return publisher;
	}
}
