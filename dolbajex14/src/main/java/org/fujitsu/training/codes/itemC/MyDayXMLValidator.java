package org.fujitsu.training.codes.itemC;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyDayXMLValidator {

	private static final Logger LOGGER = LogManager.getLogger(MyDayXMLValidator.class);
	private static final String DEFAULT_RESOURCE_FOLDER = "src/main/resources/files";

	public boolean validateWithDTD(String xmlFilename) {
		LOGGER.info("Validate with DTD {}", xmlFilename);
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(false);

			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setErrorHandler(new StrictErrorHandler());
			Document document = builder.parse(resolveFile(xmlFilename));
			LOGGER.info("DTD validation success {}", document.getDocumentElement().getNodeName());
			return true;
		} catch (ParserConfigurationException ex) {
			LOGGER.error("Parser config error", ex);
		} catch (SAXException ex) {
			LOGGER.error("SAX validation error", ex);
		} catch (IOException ex) {
			LOGGER.error("IO error during DTD validation", ex);
		}
		return false;
	}

	public boolean validateWithXSD(String xmlFilename, String xsdFilename) {
		LOGGER.info("Validate with XSD xml={} xsd={}", xmlFilename, xsdFilename);
		try {
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "file");
			schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "file");
			Schema schema = schemaFactory.newSchema(resolveFile(xsdFilename));
			Validator validator = schema.newValidator();
			validator.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "file");
			validator.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "file");
			validator.validate(new StreamSource(resolveFile(xmlFilename)));
			LOGGER.info("XSD validation success {}", xmlFilename);
			return true;
		} catch (SAXException ex) {
			LOGGER.error("XSD validation error", ex);
		} catch (IOException ex) {
			LOGGER.error("IO error during XSD validation", ex);
		}
		return false;
	}

	private File resolveFile(String filename) {
		File directFile = new File(filename);
		if (directFile.isAbsolute()) {
			LOGGER.info("Use absolute file {}", directFile.getPath());
			return directFile;
		}
		File resourceFile = new File(DEFAULT_RESOURCE_FOLDER, filename);
		LOGGER.info("Use resource file {}", resourceFile.getPath());
		return resourceFile;
	}

	private static class StrictErrorHandler implements ErrorHandler {

		@Override
		public void warning(SAXParseException exception) throws SAXException {
			throw exception;
		}

		@Override
		public void error(SAXParseException exception) throws SAXException {
			throw exception;
		}

		@Override
		public void fatalError(SAXParseException exception) throws SAXException {
			throw exception;
		}
	}
}
