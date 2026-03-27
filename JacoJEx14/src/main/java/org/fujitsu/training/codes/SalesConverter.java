package org.fujitsu.training.codes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SalesConverter {

	private static final Logger log = LogManager.getLogger(SalesConverter.class);
	private static final String OUTPUT_PATH = "src/main/resources/files/sales.json";

	public void convertToJson(List<SalesRecord> records) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);

			new File("src/main/resources/files").mkdirs();
			mapper.writeValue(new File(OUTPUT_PATH), records);

			log.info("Written {} sales records to {}", records.size(), OUTPUT_PATH);
		} catch (IOException e) {
			log.error("Failed to write sales.json", e);
		}
	}

	public List<SalesRecord> readFromJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(new File(OUTPUT_PATH),
					mapper.getTypeFactory().constructCollectionType(List.class, SalesRecord.class));
		} catch (IOException e) {
			log.error("Failed to read sales.json", e);
			return List.of();
		}
	}
}