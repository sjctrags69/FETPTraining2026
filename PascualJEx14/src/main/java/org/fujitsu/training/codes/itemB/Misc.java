package org.fujitsu.training.codes.itemB;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "misc")
public class Misc {

	private String dipId;
	private String trId;
	private List<String> authors;
	private String title;
	private Integer year;
	private Integer pages;

	@XmlAttribute(name = "dipid", required = true)
	public String getDipId() {
		return dipId;
	}

	@XmlAttribute(name = "trid", required = true)
	public String getTrId() {
		return trId;
	}

	@XmlElement(name = "author", nillable = false, required = true)
	public List<String> getAuthors() {
		return authors;
	}
	
	@XmlElement(name = "title", nillable = false, required = true)
	public String getTitle() {
		return title;
	}

	@XmlElement(name = "year", nillable = false, required = true)
	public Integer getYear() {
		return year;
	}

	@XmlElement(name = "pages", nillable = false, required = true)
	public Integer getPages() {
		return pages;
	}

	public void setDipId(String dipId) {
		this.dipId = dipId;
	}

	public void setTrId(String trId) {
		this.trId = trId;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

}
