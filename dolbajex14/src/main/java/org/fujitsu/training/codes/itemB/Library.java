package org.fujitsu.training.codes.itemB;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {

	private static final Logger LOGGER = LogManager.getLogger(Library.class);

	@XmlElements({
			@XmlElement(name = "book", type = Book.class),
			@XmlElement(name = "journal", type = Journal.class),
			@XmlElement(name = "misc", type = Misc.class) })
	private List<Publication> publications = new ArrayList<>();

	public Library() {
		LOGGER.debug("Create Library");
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		LOGGER.info("Set publications size {}", publications == null ? 0 : publications.size());
		this.publications = publications;
	}

	public void addPublication(Publication publication) {
		LOGGER.info("Add publication {}", publication == null ? "null" : publication.getId());
		this.publications.add(publication);
	}
}
