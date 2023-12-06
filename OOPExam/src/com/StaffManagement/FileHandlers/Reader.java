package com.StaffManagement.FileHandlers;

import com.StaffManagement.Entity.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public List<Employee> read(String filename){
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br =  new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                try {
                    int id = Integer.parseInt(values[0]);
                    double salary = Double.parseDouble(values[4]);

                    if (values[1].isEmpty() || values[2].isEmpty() || values[3].isEmpty()) {
                        System.err.println("Invalid data format.");
                        continue;
                    }

                    employees.add(new Employee(id, values[1], values[2], values[3], salary));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid numeric format.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
