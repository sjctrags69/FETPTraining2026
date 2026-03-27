package org.fujitsu.training.codes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONProcess {
	public boolean encodeJSON(String filename, SalesList rec) {
		try {
			ObjectMapper encoder = new ObjectMapper();
			encoder.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(filename), rec);
			return true;
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public SalesList decodeJSON(String filename) {
		ObjectMapper decoder = new ObjectMapper();
		try {
			SalesList rec = decoder.readValue(new FileReader(filename), SalesList.class);
			return rec;
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}