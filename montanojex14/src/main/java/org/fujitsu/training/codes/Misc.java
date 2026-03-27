package org.fujitsu.training.codes;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Misc {
	private String diplId;
	private String trId;
	private List<String> author;
	private String title;
	private int year;
	private int pages;
	
	@XmlAttribute(name = "diplId")
	public String getDiplId() {
		return diplId;
	}
	public void setDiplId(String diplId) {
		this.diplId = diplId;
	}
	@XmlAttribute(name = "trId")
	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	@XmlElement(name = "author")
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
	}
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name = "year")
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@XmlElement(name = "pages")
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
}
