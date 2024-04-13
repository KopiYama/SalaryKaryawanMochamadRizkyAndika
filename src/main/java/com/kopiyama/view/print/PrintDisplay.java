package com.kopiyama.view.print;

import com.kopiyama.model.Employee;

import java.util.List;
import java.util.Scanner;

public class PrintDisplay {

    public static void printAllEmployees(List<Employee> employees) {
        System.out.println("+------------+--------------------------------+--------------------------------+-----+--------------------------+----------------+");
        System.out.println("| Employee ID|             Name               |            Address             | Age |         Jobdesc          |   Placement    |");
        System.out.println("+------------+--------------------------------+--------------------------------+-----+--------------------------+----------------+");
        for (Employee employee : employees) {
            System.out.printf("| %-10s | %-30s | %-30s | %-3d | %-24s | %-14s |\n",
                    employee.getEmployeeId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getAge(),
                    employee.getJobdesc(),
                    employee.getPlacement().getPlacementName());
        }
        System.out.println("+------------+--------------------------------+--------------------------------+-----+--------------------------+----------------+");
    }

    public static void printReturnToMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n0. Back to main menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        while (choice != 0) {
            System.out.println("Invalid choice. Please enter 0 to return to the main menu.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
        }
    }
}
