package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "journal")
@XmlType(propOrder = {"title", "volume", "number"})
public class Journal {
	private String id;
	private Integer publYear;
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
	
	@XmlAttribute(name = "publYear", required = true)
	public Integer getPublYear() {
		return publYear;
	}
	public void setPublYear(Integer publYear) {
		this.publYear = publYear;
	}
	
	@XmlElement(name = "title", nillable = false, required = true)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlElement(name = "volume", nillable = false, required = true)
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	
	@XmlElement(name = "number", nillable = false, required = true)
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
}
