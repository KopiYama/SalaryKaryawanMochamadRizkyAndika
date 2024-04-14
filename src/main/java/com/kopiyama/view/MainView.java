package com.kopiyama.view;

import com.kopiyama.service.impl.DataEmployeeServiceImpl;
import com.kopiyama.view.print.AddEmployeeMenu;
import com.kopiyama.view.print.EditEmployeeDisplay;
import com.kopiyama.view.print.PrintDisplay;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    private DataEmployeeServiceImpl dataEmployeeService = new DataEmployeeServiceImpl();
    private AddEmployeeMenu addEmployeeMenu = new AddEmployeeMenu();
    private EditEmployeeDisplay editEmployeeDisplay = new EditEmployeeDisplay();

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
                    int positionChoice = addEmployeeMenu.displayPositionMenu();  // Get position choice from user
                    if (positionChoice != 0) {
                    }
                    break;
                case 2:
                    editEmployeeDisplay.displayEditEmployeeMenu();
                    break;
                case 3:
                    dataEmployeeService.displayAllEmployees();
                    break;
                case 4:
                    PrintDisplay.printPayrollData();
                    break;
                case 5:
                    System.out.println("Delete Employee");
                    // Method implementation needed
                    break;
                case 6:
                    System.out.println("Searching");
                    // Method implementation needed
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
