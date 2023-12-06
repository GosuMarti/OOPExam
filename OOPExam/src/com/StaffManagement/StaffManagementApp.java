package com.StaffManagement;
import com.StaffManagement.Interfaces.Manager;
import com.StaffManagement.Interfaces.Service;
import com.StaffManagement.Services.StaffManager;
import com.StaffManagement.Services.StaffService;

import java.util.Scanner;

import static com.StaffManagement.Interfaces.Service.reader;
import static com.StaffManagement.Interfaces.Service.writer;

public class StaffManagementApp {
    public static void main(String[] args) {
        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Staff Management System");
        displayCommands();
        System.out.println("Enter a command: ");
        boolean isRunning = true;
        while (isRunning) {
                String command = sc.nextLine();
                manager.execute(command);
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
