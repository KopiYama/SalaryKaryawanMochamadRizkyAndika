package com.kopiyama.view.print;

import com.kopiyama.service.impl.SearchingServiceImpl;
import com.kopiyama.model.Employee;

import java.util.List;
import java.util.Scanner;

public class SearchEmployeeMenu {

    private Scanner scanner = new Scanner(System.in);
    private SearchingServiceImpl searchingService = new SearchingServiceImpl();

    public void displaySearchMenu() {
        while (true) {
            System.out.println("\nSearching Data Karyawan");
            System.out.println("1. Search By Placement");
            System.out.println("0. Back To Main Menu");
            System.out.print("\nEnter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    searchByPlacement();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void searchByPlacement() {
        System.out.print("Masukan kota Penempatan: ");
        String placement = scanner.nextLine();
        List<Employee> results = searchingService.searchByPlacement(placement);
        if (results.isEmpty()) {
            System.out.println("No employees found for the given placement.");
        } else {
            PrintDisplay.printAllEmployees(results);
        }
    }
}
