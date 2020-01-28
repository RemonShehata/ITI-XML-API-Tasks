/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domtraverseinorder;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author remon
 */
public class DOMTraverseInOrder {

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
            Document document = docBuilder.parse("D:\\ITI\\Labs\\XML API\\Lab1\\BFamilyResult.xml");
            processNode(document);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOMTraverseInOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DOMTraverseInOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DOMTraverseInOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void processNode(Node node) {
        switch (node.getNodeType()) {
            case Node.ELEMENT_NODE:
                System.out.println("Element node : " + node.getNodeName());
                processChildNodes(node.getChildNodes());
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
                System.out.println("Attribute node : " + node.getAttributes() + "" + node.getNodeValue());
                processChildNodes(node.getChildNodes());
                break;
            case Node.DOCUMENT_NODE:
                System.out.println("Document node : " + node.getNodeName());
                processChildNodes(node.getChildNodes());
                break;
            case Node.COMMENT_NODE:
                System.out.println("Comment node : " + node.getTextContent());
                processChildNodes(node.getChildNodes());
                break;
            case Node.TEXT_NODE:
                if (!node.getNodeValue().trim().equals("")) {
                    System.out.println("Text node : " + node.getNodeValue());
                    processChildNodes(node.getChildNodes());
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
