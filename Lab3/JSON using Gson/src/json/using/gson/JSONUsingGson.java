/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.using.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author remon
 */
public class JSONUsingGson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Person p = new Person();
        p.setName("Remon");
        p.setAge(25);
        p.setPhone("01222222");
        p.setId(1);

        String s = gson.toJson(p);
        System.out.println(s);

        Person p2  = gson.fromJson(s, Person.class);
        System.out.println(p2);

        try {
            
            Employee employee = gson.fromJson(new FileReader("D:\\ITI\\Labs\\XML API\\Lab3\\message1.json"), Employee.class);
            System.out.println(employee);
            employee.setName("John");
            System.out.println(gson.toJson(employee));

//            Type listType = new TypeToken<ArrayList<Employee>>() {
//            }.getType();
//            List<Employee> employees
//                    = gson.fromJson(new FileReader("D:\\ITI\\Labs\\XML API\\Lab3\\message2.json"), listType);
//            for (Employee employee : employees) {
//                System.out.println(employee);
//            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONUsingGson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
