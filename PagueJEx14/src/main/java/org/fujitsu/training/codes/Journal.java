package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class Journal {

	private String id;
	private String publYear;
	private String title;
	private Integer volume;
	private Integer number;

	@XmlAttribute(name = "id", required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "publ_year", required = false)
	public String getPublYear() {
		return publYear;
	}

	public void setPublYear(String publYear) {
		this.publYear = publYear;
	}

	@XmlElement(name = "title", nillable = false, required = true)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "volume", nillable = false, required = false)
	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	@XmlElement(name = "number", nillable = false, required = false)
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", id, publYear, title, volume, number);
	}
}