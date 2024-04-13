package com.kopiyama.view;

import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.view.print.PrintDisplay;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Selamat Datang di Aplikasi Pendataan Karyawan PT. Secret Semut 79");
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Data Employee");
            System.out.println("4. Data Payroll");
            System.out.println("5. Delete Employee");
            System.out.println("6. Searching");
            System.out.print("0. Exit\n");
            System.out.print("Enter your choice: ");

            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new InputMismatchException();
                }

                choice = Integer.parseInt(input);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Add Employee");
                    //belum ada method
                    RepositoryEmployee.initializeDefaultData();
                    PrintDisplay.displayAllEmployees(RepositoryEmployee.getAllEmployee());
                    break;
                case 2:
                    System.out.println("Edit Employee");
                    //belum ada method
                    break;
                case 3:
                    System.out.println("Data Employee");
                    //belum ada method
                    break;
                case 4:
                    System.out.println("Data Payroll");
                    //belum ada method
                    break;
                case 5:
                    System.out.println("Delete Employee");
                    //belum ada method
                    break;
                case 6:
                    System.out.println("Searching");
                    //belum ada method
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }
}
