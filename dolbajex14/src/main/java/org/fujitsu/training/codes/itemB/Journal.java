package org.fujitsu.training.codes.itemB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "journal")
@XmlAccessorType(XmlAccessType.FIELD)
public class Journal extends Publication {

	private static final Logger LOGGER = LogManager.getLogger(Journal.class);

	@XmlAttribute(name = "publ_year")
	private Integer publicationYear;

	@XmlElement(name = "volume")
	private Integer volume;

	@XmlElement(name = "number")
	private Integer number;

	public Journal() {
		super();
		LOGGER.debug("Create Journal");
	}

	public Journal(String id, String title, Integer publicationYear, Integer volume, Integer number) {
		super(id, title);
		this.publicationYear = publicationYear;
		this.volume = volume;
		this.number = number;
		LOGGER.info("Create Journal {}", id);
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		LOGGER.info("Set publication year {}", publicationYear);
		this.publicationYear = publicationYear;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		LOGGER.info("Set volume {}", volume);
		this.volume = volume;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		LOGGER.info("Set number {}", number);
		this.number = number;
	}
}
