package demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;

public class Demo {

    public Demo() {
        try {
            JsonReader reader = Json.createReader(new FileReader("src/demo/message2.json"));
            JsonStructure jsonst = reader.read();

            if (jsonst.getValueType() == JsonStructure.ValueType.ARRAY) {
                List<Employee> employees = new ArrayList<>();
                JsonArray array = (JsonArray) jsonst;
                for (int i = 0; i < array.size(); i++) {
                    JsonObject object = (JsonObject) array.get(i);
                    Employee employee = new Employee();
                    employee.setId(object.getInt("id"));
                    employee.setName(object.getString("name"));
                    employee.setGender(object.getBoolean("gender"));
                    employee.setSalary(Float.parseFloat(object.get("salary").toString()));
                    JsonArray adressList = object.getJsonArray("addresses");
                    if (adressList != null) {
                        for (int h = 0; h < adressList.size(); h++) {
                            JsonObject addressValue = adressList.getJsonObject(h);
                            Address address = new Address();

                            address.setNumber(addressValue.getInt("number"));
                            address.setStreet(addressValue.getString("street"));
                            address.setRegion(addressValue.getString("region"));
                            employee.getAddresses().add(address);
                        }
                    }
                    employees.add(employee);
                    System.out.println(employee);
                }
            } else if (jsonst.getValueType() == JsonStructure.ValueType.OBJECT) {
                JsonObject object = (JsonObject) jsonst;
                Employee employee = new Employee(object);
//                employee.wrappe(object);
//                employee.setId(object.getInt("id"));
//                employee.setName(object.getString("name"));
//                employee.setGender(object.getBoolean("gender"));
//                employee.setSalary(Float.parseFloat(object.get("salary").toString()));
//                JsonArray adressList = object.getJsonArray("addresses");
//                if (adressList != null) {
//                    for (int i = 0; i < adressList.size(); i++) {
//                        JsonObject addressValue = adressList.getJsonObject(i);
//                        Address address = new Address();
//
//                        address.setNumber(addressValue.getInt("number"));
//                        address.setStreet(addressValue.getString("street"));
//                        address.setRegion(addressValue.getString("region"));
 //               List x = employee.getAddresses();      
 //               x.add(address);
//                    }
//                }
                System.out.println(employee);
            }

        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new Demo();
    }
}
