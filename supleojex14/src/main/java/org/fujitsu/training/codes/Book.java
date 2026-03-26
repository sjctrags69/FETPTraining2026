package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book extends Publication {
    
	@XmlAttribute(required = true)
    private String id;

    public Book() {
    	
    }
    
    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() { 
    	return id; 
    }
    
    public void setId(String id) {
    	this.id = id; 
    }
}