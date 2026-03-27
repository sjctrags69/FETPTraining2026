package org.fujitsu.training.codes.itemB;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "journal")
public class Journal {

	private String id;
	private Integer publ_year;
	private String title;
	private Integer volume;
	private Integer number;

	@XmlAttribute(name = "id", required = true)
	public String getId() {
		return id;
	}

	@XmlAttribute(name = "publ_year", required = true)
	public Integer getPubl_year() {
		return publ_year;
	}
	
	@XmlElement(name = "title", nillable = false, required = true)
	public String getTitle() {
		return title;
	}

	@XmlElement(name = "volume", nillable = false, required = true)
	public Integer getVolume() {
		return volume;
	}

	@XmlElement(name = "number", nillable = true, required = true)
	public Integer getNumber() {
		return number;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setPubl_year(Integer publ_year) {
		this.publ_year = publ_year;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
