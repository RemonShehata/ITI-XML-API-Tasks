/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domtraverse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author remon
 */
public class DOMTraverse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
            Document document = docBuilder.parse("D:\\ITI\\Labs\\XML API\\Lab1\\BFamilyResult.xml");
            processNode(document);

        } catch (ParserConfigurationException | IOException ex) {
            Logger.getLogger(DOMTraverse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.xml.sax.SAXException ex) {
            Logger.getLogger(DOMTraverse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void processNode(Node node) {
        switch (node.getNodeType()) {
            case Node.ELEMENT_NODE:
                processChildNodes(node.getChildNodes());
                System.out.println("Element node : " + node.getNodeName());
                if (node.hasAttributes()) {

                    // get attributes names and values
                    NamedNodeMap nodeMap = node.getAttributes();

                    for (int j = 0; j < nodeMap.getLength(); j++) {

                        Node tempNode = nodeMap.item(j);
                        System.out.println("Attribute Name : " + tempNode.getNodeName());
                        System.out.println("Attribute Value : " + tempNode.getNodeValue());

                    }
                }
                break;
            case Node.ATTRIBUTE_NODE:
                processChildNodes(node.getChildNodes());
                System.out.println("Attribute node : " + node.getAttributes());
                break;
            case Node.DOCUMENT_NODE:
                processChildNodes(node.getChildNodes());
                System.out.println("Document node : " + node.getNodeName());
                break;
            case Node.COMMENT_NODE:
                processChildNodes(node.getChildNodes());
                System.out.println("Comment node : " + node.getTextContent());
                break;
            case Node.TEXT_NODE:
                if (!node.getNodeValue().trim().equals("")) {
                    processChildNodes(node.getChildNodes());
                    System.out.println("Text node : " + node.getNodeValue());
                }
                break;

        }
    }

    private static void processChildNodes(NodeList nodeList) {
        if (nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                processNode(nodeList.item(i));
            }
        }
    }
}
