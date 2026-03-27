package org.fujitsu.training.codes.itema;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "misc")
public class Misc {
	private static final Logger LOG = LogManager.getLogger("libraryXMLLogger");
	private String id;
	private String altid;
	private String author;
	private String title;
	private Integer year;
	private Integer pages;

	public Misc() {
	}

	public Misc(String id, String altid, String author, String title, Integer year, Integer pages) {
		super();
		this.id = id;
		this.altid = altid;
		this.author = author;
		this.title = title;
		this.year = year;
		this.pages = pages;
		LOG.info("Instantiated Misc() object");
	}

	@XmlAttribute(name = "id", required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "altid", required = true)
	public String getAltid() {
		return altid;
	}

	public void setAltid(String altid) {
		this.altid = altid;
	}

	@XmlElement(name = "author", required = true, nillable = false)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlElement(name = "title", required = true, nillable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "year", required = true, nillable = false)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@XmlElement(name = "pages", required = true, nillable = false)
	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return String.format("Misc [id=%s, altid=%s, author=%s, title=%s, year=%s, pages=%s]", 
				id, altid, author, title,
				year, pages);
	}
}
