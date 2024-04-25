package com.StaffManagement;
import com.StaffManagement.interfaces.Manager;
import com.StaffManagement.interfaces.Service;
import com.StaffManagement.service.StaffManager;
import com.StaffManagement.service.StaffService;

import java.util.Scanner;

import static com.StaffManagement.interfaces.Service.reader;
import static com.StaffManagement.interfaces.Service.writer;

public class StaffManagementApp {
    public static void main(String[] args) {
        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);
        System.out.println("Welcome to Staff Management System");
        displayCommands();
        System.out.println("Enter a command: ");
        boolean isRunning = true;
        while (isRunning) {
                try (Scanner sc = new Scanner(System.in)){
                    String command = sc.nextLine();
                    manager.execute(command);
                } catch (Exception exception){
                    System.err.println("Something went wrong");
                }

        }
    }


    private static void displayCommands() {
        System.out.println("""
                You can use the following commands:
                Add Employee
                Edit [ID]
                List employees
                Search Department [Department]
                Search ID [ID]
                Fire [ID]
                Search Name [Name]
                Save & Exit
                """);
    }
}
