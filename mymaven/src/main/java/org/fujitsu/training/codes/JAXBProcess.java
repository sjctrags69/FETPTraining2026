package org.fujitsu.training.codes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class JAXBProcess {
	
	public boolean createEmployeeXML(String filename, Employee rec) {
		try {
			JAXBContext context =
					   JAXBContext.newInstance(Employee.class);
			Marshaller XMLcreator = context.createMarshaller();
			XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			FileWriter fw = new FileWriter(filename);
			
			XMLcreator.marshal(rec, fw);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean createEmployeesXML(String filename, 
			Employees emps) {
		try {
			JAXBContext context =
				JAXBContext.newInstance(Employee.class, Employees.class);
			Marshaller XMLcreator = context.createMarshaller();
			XMLcreator.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			XMLcreator.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			FileWriter fw = new FileWriter(filename);
			
			XMLcreator.marshal(emps, fw);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public Employee parseEmployeeXML(String filename) {
		try {
			JAXBContext context =
					   JAXBContext.newInstance(Employee.class);
			Unmarshaller parser = context.createUnmarshaller();
			Employee rec = (Employee) parser.unmarshal(new FileReader(filename));
			return rec;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}
