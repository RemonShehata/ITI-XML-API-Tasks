/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.manipulation;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

/**
 *
 * @author remon
 */
public class XMLParser {

    public static void parse() {
        try {
            File f = new File("D:\\ITI\\Labs\\XML API\\Lab1\\simpleContact.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document document = docBuilder.parse(f);

            document.getDocumentElement().normalize();
            System.out.println("Root element name :- " + document.getDocumentElement().getNodeName());

            NodeList nodelist = document.getElementsByTagName("contacts");

            for (int i = 0; i < nodelist.getLength(); i++) {
                Node node = nodelist.item(i);

                System.out.println("\t" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Attribute : " + element.getAttribute("gender"));
                    System.out.println("First Name : " + element.getElementsByTagName("FirstName").item(0).getTextContent());
                    System.out.println("Last Name :" + element.getElementsByTagName("LastName").item(0).getTextContent());
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
