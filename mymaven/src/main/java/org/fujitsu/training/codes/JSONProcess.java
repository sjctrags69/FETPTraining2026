package org.fujitsu.training.codes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONProcess {
	
	public boolean encodeJSON(String filename, Employee rec) {
		try {
			ObjectMapper encoder = new ObjectMapper();
			encoder.writeValue(new FileWriter(filename), rec);
			return true;
		} catch (DatabindException e) {
			e.printStackTrace();
		}catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public Employee decodeJSON(String filename) {
		try {
			ObjectMapper decoder = new ObjectMapper();
			Employee rec = decoder.readValue(new FileReader(filename), Employee.class);
			return rec;
		} catch (DatabindException e) {
			e.printStackTrace();
		}catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
