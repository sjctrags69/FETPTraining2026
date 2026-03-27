package org.fujitsu.training.codes;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "library")
public class Library {
	private List<Object> lib;
	
	@XmlElements({
        @XmlElement(name = "book", type = Book.class),
        @XmlElement(name = "journal", type = Journal.class),
        @XmlElement(name = "misc", type = Misc.class)
    })
	public List<Object> getLib() {
		return lib;
	}
	public void setLib(List<Object> lib) {
		this.lib = lib;
	}
}
