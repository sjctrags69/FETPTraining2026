package org.fujitsu.training.codes.itemD;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProcessSalesJSON {

	public boolean encodeJSON(String filename, SalesEmployee rec) {
		try {
			ObjectMapper encoder = new ObjectMapper();
			encoder.writeValue(new FileWriter(filename), rec);
			return true;
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public SalesEmployee decodeJSON(String filename) {
		try {
			ObjectMapper decoder = new ObjectMapper();
			SalesEmployee rec = decoder.readValue(new FileReader(filename), SalesEmployee.class);
			return rec;
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean encodeSalesEmployeesJSON(String filename, SalesEmployees emps) {
		try {
			ObjectMapper encoder = new ObjectMapper();
			encoder.writeValue(new FileWriter(filename), emps);
			return true;
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public SalesEmployees decodeSalesEmployeesJSON(String filename) {
		try {
			ObjectMapper decoder = new ObjectMapper();
			SalesEmployees recs = decoder.readValue(new FileReader(filename), SalesEmployees.class);
			return recs;
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
