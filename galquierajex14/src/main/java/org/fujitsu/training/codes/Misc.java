package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "misc")
@XmlType(propOrder = {"author", "title", "year", "pages"})
public class Misc {
	private String id;
	private String author;
	private String title;
	private Integer year;
	private Integer pages;

	@XmlAttribute(name = "id", required = true)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "author", nillable = false, required = false)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String string) {
		this.author = string;
	}

	@XmlElement(name = "title", nillable = false, required = true)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "year", nillable = false, required = false)
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	@XmlElement(name = "pages", nillable = false, required = false)
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
}