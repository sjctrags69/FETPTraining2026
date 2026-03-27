package org.fujitsu.training.codes;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {

    @XmlElements({
        @XmlElement(name = "book", type = Book.class),
        @XmlElement(name = "journal", type = Journal.class),
        @XmlElement(name = "misc", type = Misc.class)
    })
    
    private List<Publication> entries = new ArrayList<>();

    public List<Publication> getEntries() { 
    	return entries;
    }
    
    public void setEntries(List<Publication> entries) {
    	this.entries = entries;
    }
}