package org.fujitsu.training.codes.itemB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ Book.class, Journal.class, Misc.class })
public abstract class Publication {

	private static final Logger LOGGER = LogManager.getLogger(Publication.class);

	@XmlAttribute(name = "id", required = true)
	private String id;

	@XmlElement(name = "title", required = true)
	private String title;

	protected Publication() {
		LOGGER.debug("Create Publication");
	}

	protected Publication(String id, String title) {
		this.id = id;
		this.title = title;
		LOGGER.debug("Create Publication with id {}", id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		LOGGER.info("Set publication id {}", id);
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		LOGGER.info("Set publication title {}", title);
		this.title = title;
	}
}
