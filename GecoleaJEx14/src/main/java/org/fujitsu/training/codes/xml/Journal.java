package org.fujitsu.training.codes.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "journal")
public class Journal {

	private String id;
	private String publYear;
	private String title;
	private Volume volume;

	@XmlAttribute(name = "id", required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute(name = "publ_year")
	public String getPublYear() {
		return publYear;
	}

	public void setPublYear(String publYear) {
		this.publYear = publYear;
	}

	@XmlElement(name = "title", required = true)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "volume")
	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}
}
