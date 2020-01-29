/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.using.jee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonStructure;
import javax.json.JsonValue;

/**
 *
 * @author remon
 */
public class JSONUsingJEE {
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            JsonReader reader = Json.createReader(new FileReader("D:\\ITI\\Labs\\XML API\\Lab3\\message1.json"));
            JsonStructure jsonst = reader.read();

            System.out.println(jsonst);
            JsonObject ob = (JsonObject) jsonst;
            System.out.println(ob.keySet());
            System.out.println("\n\n");
            navigateTree(jsonst, null);

            System.out.println("\n\n");
            navigateTree(createJsonObject(), null);
            
            Person p = new Person();
            p.setName("Remon");
            p.setAge(25);
            p.setPhone("01222222");
            p.setId(1);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONUsingJEE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void navigateTree(JsonValue tree, String key) {
        switch (tree.getValueType()) {
            case OBJECT:
                JsonObject object = (JsonObject) tree;
                for (String name : object.keySet()) {
                    navigateTree(object.get(name), name);
                }
                break;

            case ARRAY:
                JsonArray array = (JsonArray) tree;
                for (JsonValue val : array) {
                    navigateTree(val, null);
                }
                break;

            case STRING:
                JsonString st = (JsonString) tree;
                System.out.println(st.getString());
                break;

            case NUMBER:
                JsonNumber num = (JsonNumber) tree;
                System.out.println(num.toString());
                break;

            case TRUE:
            case FALSE:
            case NULL:
                System.out.println(tree.getValueType().toString());
                break;
        }
    }

    private static JsonObject createJsonObject() {
        JsonObject obj = Json.createObjectBuilder()
                .add("firstName", "John")
                .add("lastName", "Smith")
                .add("age", 25)
                .add("address", Json.createObjectBuilder()
                        .add("streetAddress", "21 2nd Street")
                        .add("city", "new york")
                        .add("state", "NY")
                        .add("postalcode", "12222"))
                .add("phoneNumber", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "0100021455"))
                        .add(Json.createObjectBuilder()
                                .add("type", "work")
                                .add("number", "55555")))
                .build();
        return obj;
    }
}
