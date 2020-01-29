package demo;

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

public class Demo {

    public Demo() {
        Employee emp = new Employee();
        Class x = Employee.class;
         x = emp.getClass();
         Gson gson;
        try {
            // gson = new Gson();
            gson = new GsonBuilder().setPrettyPrinting().create();
//            Employee employee = gson.fromJson(new FileReader("src/demo/message1.json"), Employee.class);
//            System.out.println(employee);
//            employee.setName("mohsen");
//            System.out.println(gson.toJson(employee));




Type listType = new TypeToken<ArrayList<Employee>>() {}.getType();
            List<Employee> employees = 
                    gson.fromJson(new FileReader("src/demo/message2.json"), listType);
            for (Employee employee : employees) {
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
