package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Journal {

    @XmlAttribute
    private String id;

    @XmlAttribute(name = "publ_year")
    private String publYear;

    @XmlElement
    private String title;

    @XmlElement
    private String volume;

    public Journal() {}

    public Journal(String id, String publYear, String title, String volume) {
        this.id       = id;
        this.publYear = publYear;
        this.title    = title;
        this.volume   = volume;
    }

    public String getId() {
        return id;
    }

    public String getPublYear() {
        return publYear;
    }

    public String getTitle() {
        return title;
    }

    public String getVolume() {
        return volume;
    }
}