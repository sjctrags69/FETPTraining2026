package org.fujitsu.training.codes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONProcess {

	public boolean encodeJSON(String filename, Sales records) {
		try {
			ObjectMapper encoder = new ObjectMapper();
			encoder.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(filename), records);
			return true;
		} catch (DatabindException ex) {
			ex.printStackTrace();
		} catch (StreamWriteException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public Sales decodeJSON(String filename) {
		ObjectMapper encoder = new ObjectMapper();
		try {
			Sales records = encoder.readValue(new FileReader(filename), Sales.class);
			return records;
		} catch (StreamReadException ex) {
			ex.printStackTrace();
		} catch (DatabindException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}