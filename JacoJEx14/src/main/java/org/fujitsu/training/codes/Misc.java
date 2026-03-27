package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Misc {

    @XmlAttribute
    private String id;

    @XmlElement(name = "author")
    private List<String> authors = new ArrayList<>();

    @XmlElement
    private String title;

    @XmlElement
    private String year;

    @XmlElement
    private String pages;

    public Misc() {}

    public Misc(String id, List<String> authors, String title, String year, String pages) {
        this.id      = id;
        this.authors = authors;
        this.title   = title;
        this.year    = year;
        this.pages   = pages;
    }

    public String getId() {
        return id;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getPages() {
        return pages;
    }
}