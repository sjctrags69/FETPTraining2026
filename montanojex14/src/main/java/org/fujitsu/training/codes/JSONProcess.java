package org.fujitsu.training.codes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONProcess {
	
	public boolean encodeJSON(String filename, List<Sales> rec) {
		try {
			ObjectMapper encoder = new ObjectMapper();
			encoder.writeValue(new FileWriter(filename), rec);
			return true;
		} catch(DatabindException e) {
			e.printStackTrace();
		} catch(StreamWriteException e) {
			e.printStackTrace();
		}  catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
