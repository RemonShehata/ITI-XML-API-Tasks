/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxblab;

import demo.AddressType;
import demo.ObjectFactory;
import demo.PersonType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author remon
 */
public class JAXBLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        try {
            // TODO code application logic here

            JAXBContext context = JAXBContext.newInstance("demo");
            Unmarshaller unmarsh = context.createUnmarshaller();
            JAXBElement JAXPerson = (JAXBElement) unmarsh.unmarshal(new File("D:\\ITI\\Labs\\XML API\\Lab2\\JAXB\\demo.xml"));
            
            PersonType personType = (PersonType) JAXPerson.getValue();
            System.out.println("Person Name: " + personType.getName());
            
            AddressType address = (AddressType) personType.getAddress().get(0);
            System.out.println("First Address: " + address.getStreet() + " , Number: " + address.getNumber());
            
            AddressType secondAddress = (AddressType) personType.getAddress().get(1);
            System.out.println("First Address: " + secondAddress.getStreet() + " , Number: " + secondAddress.getNumber());
            
            // manipulate objects 
            personType.setName("Remon");
            
            ObjectFactory factory = new ObjectFactory();
            AddressType addr = factory.createAddressType();
            addr.setStreet("10th of ramadan");
            addr.setNumber(1);
            
            List addressList = personType.getAddress();
            addressList.add(addr);
            
            
            // objects to XML
            JAXBElement person = factory.createPerson(personType);
            Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marsh.marshal(person, new FileOutputStream(new File("D:\\ITI\\Labs\\XML API\\Lab2\\JAXB\\output.xml")));
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBLab.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JAXBLab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
