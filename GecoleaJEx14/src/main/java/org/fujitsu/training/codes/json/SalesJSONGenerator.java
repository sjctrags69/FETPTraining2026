package org.fujitsu.training.codes.json;

import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SalesJSONGenerator {
	 public boolean createSalesJSON(String filename, SalesList rec) {
			try {
				ObjectMapper encoder = new ObjectMapper();
				encoder.writeValue(new FileWriter(filename), rec);
				return true;
			} catch (StreamWriteException e) {

				e.printStackTrace();
			} catch (DatabindException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			return false;
	    }
}
