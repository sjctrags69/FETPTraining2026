package org.fujitsu.training.codes.itemc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class SalesJSON {
	private static final Logger LOG = LogManager.getLogger("salesLogger");

	public boolean encodeJSON(String filename, Sales... sales) {
		LOG.info("Executing method encodeJSON() with parameters String {} and Sales {}", filename, sales);
		try {
			ObjectMapper encoder = new ObjectMapper();
			FileWriter writer = new FileWriter(filename);
			encoder.enable(SerializationFeature.INDENT_OUTPUT);
			encoder.writeValue(writer, sales);
			LOG.info("Ending method encodeJSON  in success with a return value {}", true);
			return true;
		} catch (StreamWriteException | DatabindException ex) {
			LOG.fatal(ex.getMessage());
		} catch (JacksonException ex) {
			LOG.fatal(ex.getMessage());
		} catch (IOException ex) {
			LOG.fatal(ex.getMessage());
		}
		LOG.info("Ending method encodeJSON  in failure with a return value {}", false);
		return false;
	}

	public Sales[] decodeJSON(String filename) {
		LOG.info("Executing method decodeJSON() with parameters String {}", filename);
		ObjectMapper encoder = new ObjectMapper();
		try {
			
			FileReader reader = new FileReader(filename);
			Sales[] emp = (Sales[]) encoder.readValue(reader, Sales[].class);
			LOG.info("Ending method decodeJSON in success with a return value Sales[] ");
			return emp;
		} catch (FileNotFoundException | StreamReadException | DatabindException ex) {
			LOG.fatal(ex.getMessage());
		} catch (JacksonException ex) {
			LOG.fatal(ex.getMessage());
		} catch (IOException ex) {
			LOG.fatal(ex.getMessage());
		}
		LOG.info("Ending method decodeJSON in failure with a return value null");
		return null;
	}
}
