package org.fujitsu.training.codes.itemB;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "misc")
@XmlAccessorType(XmlAccessType.FIELD)
public class Misc extends Publication {

	private static final Logger LOGGER = LogManager.getLogger(Misc.class);

	@XmlElement(name = "author")
	private List<String> authors = new ArrayList<>();

	@XmlElement(name = "year")
	private Integer year;

	@XmlElement(name = "pages")
	private Integer pages;

	public Misc() {
		super();
		LOGGER.debug("Create Misc");
	}

	public Misc(String id, String title, Integer year, Integer pages) {
		super(id, title);
		this.year = year;
		this.pages = pages;
		LOGGER.info("Create Misc {}", id);
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		LOGGER.info("Set authors size {}", authors == null ? 0 : authors.size());
		this.authors = authors;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		LOGGER.info("Set year {}", year);
		this.year = year;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		LOGGER.info("Set pages {}", pages);
		this.pages = pages;
	}
}
