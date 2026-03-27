package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "journal")
public class Journal {
	private String id;
	private int pubYear;
	private String title;
	private Volume vol;
	
	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}
	@XmlElement(name = "volume")
	public Volume getVol() {
		return vol;
	}
	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}
	@XmlAttribute(name = "publ_year")
	public int getPubYear() {
		return pubYear;
	}
	public void setVol(Volume vol) {
		this.vol = vol;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}
	
}
