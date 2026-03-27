package org.fujitsu.training.codes.itemD;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class ProcessSalesJAXB {
	
	public boolean createXML(String filename, SalesEmployee rec) {
		try {
			JAXBContext context = JAXBContext.newInstance(SalesEmployee.class);
			Marshaller XMLcreator = context.createMarshaller();
			XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			FileWriter fw = new FileWriter(filename);
			XMLcreator.marshal(rec, fw);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean createEmployeesXML(String filename, SalesEmployees emps) {
		try {
			JAXBContext context = JAXBContext.newInstance(SalesEmployee.class, SalesEmployees.class);
			Marshaller XMLcreator = context.createMarshaller();
			XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			FileWriter fw = new FileWriter(filename);
			XMLcreator.marshal(emps, fw);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
	}

	public SalesEmployees parseSalesXML(String filename) {
		try {
			JAXBContext context = JAXBContext.newInstance(SalesEmployee.class, SalesEmployees.class);
			Unmarshaller parser = context.createUnmarshaller();
			SalesEmployees recs = (SalesEmployees) parser.unmarshal(new FileReader(filename));
			return recs;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
