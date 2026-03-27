package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "journal")
@XmlAccessorType(XmlAccessType.FIELD)
public class Journal extends Publication {
   
	@XmlAttribute(required = true)
    private String id;

    @XmlAttribute(name = "pub_year")
    private Integer pubYear;

    private Integer number;

    public Journal() {
    	
    }
    
    public Journal(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() { 
    	return id; 
    }
    
    public void setId(String id) { 
    	this.id = id; 
    }

    public Integer getPubYear() { 
    	return pubYear; 
    }
    
    public void setPubYear(Integer pubYear) { 
    	this.pubYear = pubYear; 
    }

    public Integer getNumber() { 
    	return number; 
    }
    
    public void setNumber(Integer number) {
    	this.number = number; 
    }
}