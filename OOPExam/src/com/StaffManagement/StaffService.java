package com.StaffManagement;

import com.StaffManagement.FileHandlers.Reader;
import com.StaffManagement.FileHandlers.Writer;
import java.util.*;
public class StaffService implements Service {
    public StaffService(Reader reader, Writer writer) {
    }

    static List<Employee> employees = new ArrayList<>();

    public static void writeEmployeeToList() {
        writer.write(employees, "employees.csv");
    }

    public static void addEmployee() {
        Employee emp = new Employee();
        getEmployeeInfoByID(emp);
        employees.add(emp);
    }

    public static void listEmployees() {
        reader.read("employees.csv");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public static void editEmployee(int targetId) {
        for (Employee emp : employees) {
            if (emp.getID() == targetId) {
                getEmployeeInfoByID(emp);
                return;
            }
        }

        System.out.println("Item with ID " + targetId + " not found.");
    }

    private static void getEmployeeInfoByID(Employee emp) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            String[] employeeInfo = input.split(",");
            emp.setID(Integer.parseInt(employeeInfo[0]));
            emp.setName(employeeInfo[1]);
            emp.setDepartment(employeeInfo[2]);
            emp.setRole(employeeInfo[3]);
            emp.setSalary(Double.parseDouble(employeeInfo[4]));
        } catch (InputMismatchException exception){
            exception.printStackTrace();
        }
        catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        catch (NumberFormatException ex){
            System.err.println("Wrong input");
        }
        catch (NoSuchElementException ex){
            System.err.println("Something went wrong");
        }
    }

    public static void getEmployeeInfoByID(int targetId) {
        for (Employee emp : employees) {
            if (emp.getID() == targetId) {
                System.out.println(emp);
                return;
            }
        }

        System.out.println("Employee with ID " + targetId + " not found.");
    }

    public static void getEmployeeInfoByDepartment(String department) {
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getDepartment().trim().equalsIgnoreCase(department)) {
                System.out.println(emp);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in the department: " + department);
        }
    }

    public static void getEmployeeInfoByName(String targetName) {
        boolean found = false;
        String trimmedPartialName = targetName.trim().toLowerCase();

        for (Employee emp : employees) {
            if (emp.getName().trim().equalsIgnoreCase(targetName) || emp.getName().toLowerCase().contains(trimmedPartialName)) {
                System.out.println(emp);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found with the name: " + targetName);
        }
    }

    public static void fireEmployee(int targetId) {
        for (Employee emp : employees) {
            if (emp.getID() == targetId) { // Make a better function
                emp.setRole("Fired");
                emp.setSalary(0);
                emp.setDepartment("Fired");
                return;
            }
        }
    }
}
