/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.manipulation;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


/**
 *
 * @author remon
 */
public class CreateXMLUsingJava {

    public static void create() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder doc = factory.newDocumentBuilder();
            Document document = doc.newDocument();
            
            Element rootElem = document.createElement("Father");
            Element personal = document.createElement("Personal");
            Attr fname = document.createAttribute("FName");
            fname.setValue("Ahmed");
            Attr fage = document.createAttribute("FAge");
            fage.setValue("17");
            
            document.appendChild(rootElem);
            rootElem.appendChild(personal);
            personal.setAttributeNode(fname);
            personal.setAttributeNode(fage);
            personal.appendChild(document.createTextNode("Father text node"));
            
            Element children = document.createElement("Children");
            rootElem.appendChild(children);
            
            Element child = document.createElement("Child");
            child.appendChild(document.createTextNode("Child text node"));
            Attr cname = document.createAttribute("CName");
            cname.setValue("Mohamed");
            Attr cage = document.createAttribute("CAge");
            cage.setValue("5");
            
            children.appendChild(child);
            child.setAttributeNode(cname);
            child.setAttributeNode(cage);
            
            
            TransformerFactory transforFactory = TransformerFactory.newInstance();
            Transformer transformer = transforFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("D:\\ITI\\Labs\\XML API\\Lab1\\DOM Manipulation\\family.xml"));
            
            transformer.transform(domSource, streamResult);
            
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException ex) {
            Logger.getLogger(CreateXMLUsingJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
