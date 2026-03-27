package org.fujitsu.training.codes.itema;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Journal")
public class Journal {
	private static final Logger LOG = LogManager.getLogger("libraryXMLLogger");
	private String id;
	private Integer publYear;
	private String title;
	private Integer volume;
	private Integer number;
	
	public Journal() {
	}

	public Journal(String id, Integer publYear, String title, Integer volume, Integer number) {
		super();
		this.id = id;
		this.publYear = publYear;
		this.title = title;
		this.volume = volume;
		this.number = number;
		LOG.info("Instantiated Journal() object");
	}

	@XmlAttribute(name = "id", required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "publ_year", required = true)
	public Integer getPublYear() {
		return publYear;
	}

	public void setPublYear(Integer publYear) {
		this.publYear = publYear;
	}

	@XmlElement(name = "title", required = true, nillable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "volume", required = true, nillable = false)
	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	@XmlElement(name = "number", required = true, nillable = false)
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("Journal [id=%s, publYear=%s, title=%s, volume=%s, number=%s]", 
				id, publYear, title,
				volume, number);
	}
}