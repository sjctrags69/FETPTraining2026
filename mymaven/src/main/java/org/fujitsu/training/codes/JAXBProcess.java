package org.fujitsu.training.codes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class JAXBProcess {
	
	public boolean createXML(String filename, Employee rec) {
		try {
			JAXBContext context =JAXBContext.newInstance(Employee.class);
			Marshaller XMLcreator = context.createMarshaller();
			XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			FileWriter fw = new FileWriter(filename);
			XMLcreator.marshal(rec, fw);
			return true;
		} catch (IOException e ) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean createEmployeesXML(String filename, Employees emps) {
		try {
			JAXBContext context =JAXBContext.newInstance(Employee.class, Employees.class);
			Marshaller XMLcreator = context.createMarshaller();
			XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			FileWriter fw = new FileWriter(filename);
			XMLcreator.marshal(emps, fw);
			return true;
		} catch (IOException e ) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Employee parseXML(String filename) {
		try {
			JAXBContext context =JAXBContext.newInstance(Employee.class);
			Unmarshaller parser = context.createUnmarshaller();
			Employee rec = (Employee) parser.unmarshal(new FileReader(filename));
			return rec;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Employees parseEmployeesXML(String filename) {
		try {
			JAXBContext context =JAXBContext.newInstance(Employees.class);
			Unmarshaller parser = context.createUnmarshaller();
			Employees recs = (Employees) parser.unmarshal(new FileReader(filename));
			return recs;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
