package com.StaffManagement;
public class Employee{
    private int ID;
    private String name;
    private String department;
    private String role;
    private double salary;

    public Employee(int ID, String name, String department, String role, double salary){
        this.ID = ID;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }
    public Employee(){}

    public String toString(){
        return ID + "," + name + "," + department + "," + role + "," + salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
