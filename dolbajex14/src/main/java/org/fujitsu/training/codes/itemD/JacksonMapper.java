package org.fujitsu.training.codes.itemD;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonMapper {

	private static final Logger LOGGER = LogManager.getLogger(JacksonMapper.class);
	private static final String DEFAULT_RESOURCE_FOLDER = "src/main/resources/files";

	public boolean createSalesXML(String filename, List<SalesRecord> records) {
		LOGGER.info("Create sales xml {}", filename);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter().writeValue(resolveFile(filename), records);
			LOGGER.info("Created sales xml with {} records", records.size());
			return true;
		} catch (IOException ex) {
			LOGGER.error("IO error while creating sales xml", ex);
		} catch (RuntimeException ex) {
			LOGGER.error("Runtime error while creating sales xml", ex);
		}
		return false;
	}

	private File resolveFile(String filename) {
		File directFile = new File(filename);
		if (directFile.isAbsolute()) {
			LOGGER.info("Use absolute file {}", directFile.getPath());
			return directFile;
		}
		File resourceFile = new File(DEFAULT_RESOURCE_FOLDER, filename);
		LOGGER.info("Use resource file {}", resourceFile.getPath());
		return resourceFile;
	}
}
