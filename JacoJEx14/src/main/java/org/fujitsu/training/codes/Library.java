package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {

    @XmlElements({
        @XmlElement(name = "book",    type = Book.class),
        @XmlElement(name = "journal", type = Journal.class),
        @XmlElement(name = "misc",    type = Misc.class)
    })
    private List<Object> publications = new ArrayList<>();

    public List<Object> getPublications() {
        return publications;
    }

    public void setPublications(List<Object> publications) {
        this.publications = publications;
    }
}