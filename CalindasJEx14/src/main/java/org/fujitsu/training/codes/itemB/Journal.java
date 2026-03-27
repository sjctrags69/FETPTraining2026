package org.fujitsu.training.codes.itemB;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Journal {

    @XmlAttribute
    private String id;

    @XmlAttribute(name = "publ_year")
    private String publYear;

    private String title;

    private Volume volume;

    public Journal() {}

    public Journal(String id, String publYear, String title, Volume volume) {
        this.id = id;
        this.publYear = publYear;
        this.setTitle(title);
        this.setVolume(volume);
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}
}