package com.StaffManagement.FileHandlers;

import com.StaffManagement.Entity.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    public void write(List<Employee> employees, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Employee employee: employees) {
                writer.write(employee.toString() + "\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }
}
