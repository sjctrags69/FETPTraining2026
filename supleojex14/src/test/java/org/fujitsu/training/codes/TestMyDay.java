package org.fujitsu.training.codes;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class TestMyDay {
    
    @BeforeEach
    public void setup() {
        System.out.println("Start XML validation...");
    }
    
    @AfterEach
    public void teardown() {
        System.out.println("End XML validation...");
    }
    
    @Test
    public void testValidateDTD() throws Exception {
        validateDTD("./src/main/resources/files/myday2.xml");
        validateDTD("./src/main/resources/files/myday3.xml");
    }
    
    @Test
    public void testValidateXSD() throws Exception {
        validateXSD("./src/main/resources/files/myday1.xml", "./src/main/resources/files/myday.xsd");
    }
    
    private void validateDTD(String xmlFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);

        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setErrorHandler(new ThrowingErrorHandler());
        builder.parse(xmlFile);
        System.out.println("DTD valid: " + xmlFile);
    }
    
    private void validateXSD(String xmlFile, String xsdFile) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new java.io.File(xsdFile));
        javax.xml.validation.Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new java.io.File(xmlFile)));
        System.out.println("XSD valid: " + xmlFile);
    }
    
    private static class ThrowingErrorHandler implements ErrorHandler {
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