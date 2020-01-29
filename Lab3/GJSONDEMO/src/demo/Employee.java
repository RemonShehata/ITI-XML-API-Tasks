/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Java-ahmed
 */
public class Employee {

    private int id;
    private String name;
    private boolean gender;
    private float salary;
    private List<Address> addresses = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Employee Details *****\n");
        sb.append("ID=" + this.id + "\n");
        sb.append("Name=" + this.name + "\n");
        sb.append("Gender=" + this.gender + "\n");
        sb.append("Salary=" + this.salary + "\n");
        for (Address address : addresses) {
            sb.append(address);
        }
        sb.append("*****************************\n");
        return sb.toString();
    }
}
