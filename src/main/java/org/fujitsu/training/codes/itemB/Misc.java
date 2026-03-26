package org.fujitsu.training.codes.itemB;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Misc {

    @XmlAttribute
    private String id;

    @XmlElement(name = "author")
    private List<String> authors;

    private String title;
    private int year;
    private int pages;

    public Misc() {}

    public Misc(String id, List<String> authors, String title, int year, int pages) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.year = year;
        this.pages = pages;
    }
}