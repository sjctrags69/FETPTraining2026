package org.fujitsu.training.codes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONProcess {
	
	public boolean encodeJSON(String filename, Employee rec) {
		try {
			ObjectMapper encoder = new ObjectMapper();
			encoder.writeValue(new FileWriter(filename), rec);
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
	
	public Employee decodeJSON(String filename) {
		try {
			ObjectMapper encoder = new ObjectMapper();
			Employee rec = encoder.readValue(new FileReader(filename), Employee.class);
			return rec;
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
