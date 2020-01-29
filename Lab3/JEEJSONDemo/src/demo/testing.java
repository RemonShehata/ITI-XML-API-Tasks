/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.json.*;

/**
 *
 * @author Mohsen Diab
 */
public class testing {

    public testing() {
        JsonReader reader;
        try {
            reader = Json.createReader(new FileReader("src/demo/message2.json"));
            JsonStructure jsonst = reader.read();
            navigateTree(jsonst, null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(testing.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public static void main(String[] args) {
        
        new testing();
    }
    
public void navigateTree(JsonValue tree, String key) {
  switch(tree.getValueType()) { 
    case OBJECT:
          JsonObject object = (JsonObject) tree; 
          for (String name : object.keySet()) {
              //System.out.println("Obbject");
              navigateTree(object.get(name), name);} break; 
    case ARRAY: 
          JsonArray array = (JsonArray) tree; 
         // System.out.println("Array");
         // System.out.println(key);
          for (JsonValue val : array) 
              navigateTree(val, null); break; 
    case STRING: 
          JsonString st = (JsonString) tree;
         // System.out.println("String");
          System.out.println(key);
          System.out.println(st.getString()); break; 
    case NUMBER: 
          JsonNumber num = (JsonNumber) tree; 
         // System.out.println("number");
          System.out.println(key);
          System.out.println(num.toString()); break; 
    case TRUE: case FALSE: case NULL: System.out.println(tree.getValueType().toString()); break; } }
    
    
}
