package com.StaffManagement.Services;

import com.StaffManagement.Interfaces.Manager;
import com.StaffManagement.Interfaces.Service;

import java.util.Arrays;
import static java.lang.System.exit;
public class StaffManager implements Manager {
    public StaffManager(Service service) {
    }
    @Override
    public void execute(String command){
        String[] inputParts = command.split(" ");
        if(command.equalsIgnoreCase("Add Employee")){
            StaffService.addEmployee();
            StaffService.writeEmployeeToList();
        } else if (inputParts[0].equalsIgnoreCase("Edit")){
            int targetId = Integer.parseInt(inputParts[1]);
            StaffService.editEmployee(targetId);
        } else if (inputParts[0].equalsIgnoreCase("Search") && inputParts[1].equalsIgnoreCase("ID")) {
            int targetId = Integer.parseInt(inputParts[2]);
            StaffService.getEmployeeInfoByID(targetId);
        } else if (inputParts[0].equalsIgnoreCase("Search") && inputParts[1].equalsIgnoreCase("Name")) {
            try {
                String targetName;
                if (inputParts.length >= 3) {
                    targetName = String.join(" ", Arrays.copyOfRange(inputParts, 2, inputParts.length));
                    StaffService.getEmployeeInfoByName(targetName);
                } else {
                    System.out.println("Please provide a name for the search.");
                }
            } catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        } else if (inputParts[0].equalsIgnoreCase("Search") && inputParts[1].equalsIgnoreCase("Department")) {
            String department = inputParts[2];
            StaffService.getEmployeeInfoByDepartment(department);
        } else if (command.equalsIgnoreCase("List employees")) {
            StaffService.listEmployees();
        } else if (inputParts[0].equalsIgnoreCase("Fire")) {
            int targetId = Integer.parseInt(inputParts[1]);
            StaffService.fireEmployee(targetId);
        } else if (command.equalsIgnoreCase("Save & Exit")){
            exit(0);
        } else {
            System.out.println("Enter a valid command: ");
        }
    }
}
