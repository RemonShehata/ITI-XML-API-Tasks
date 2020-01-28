/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxbdemo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author remon
 */
public class SAXBDemo extends HandlerBase {

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        super.fatalError(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        super.processingInstruction(target, data); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        super.ignorableWhitespace(ch, start, length); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
        String temp = new String(ch, start, length);
        System.out.println("Text:  " + temp);
    }

    @Override
    public void endElement(String name) throws SAXException {
        super.endElement(name); //To change body of generated methods, choose Tools | Templates.
        System.out.println("End element: " + name);
    }

    @Override
    public void startElement(String name, AttributeList attributes) throws SAXException {
        super.startElement(name, attributes); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Start element: " + name);
        
        if(attributes != null){
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute No#" + i + " " + attributes.getName(i) 
                + " : " + attributes.getValue(i));
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("end of document");
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("start of document");
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        super.setDocumentLocator(locator); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName) {
        super.unparsedEntityDecl(name, publicId, systemId, notationName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notationDecl(String name, String publicId, String systemId) {
        super.notationDecl(name, publicId, systemId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
        return super.resolveEntity(publicId, systemId); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File("D:\\ITI\\Labs\\XML API\\Lab2\\SAX\\MyConfig.xml"), new SAXBDemo());

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SAXBDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SAXBDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SAXBDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
