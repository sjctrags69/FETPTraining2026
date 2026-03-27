package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "misc")
@XmlAccessorType(XmlAccessType.FIELD)
public class Misc extends Publication {
    
	@XmlAttribute(required = true)
    private String id;

    private Integer pages;

    public Misc() {
    	
    }
    
    public Misc(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() { 
    	return id;
    }
    
    public void setId(String id) {
    	this.id = id; 
    }

    public Integer getPages() { 
    	return pages; 
    }
    
    public void setPages(Integer pages) { 
    	this.pages = pages; 
    }
}
