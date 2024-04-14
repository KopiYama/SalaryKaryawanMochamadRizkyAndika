package com.kopiyama.view.print;

import com.kopiyama.service.impl.SearchingServiceImpl;
import com.kopiyama.model.Employee;
import com.kopiyama.util.Helper;

import java.util.List;

public class SearchEmployeeMenu {

    private SearchingServiceImpl searchingService = new SearchingServiceImpl();

    public void displaySearchMenu() {
        while (true) {
            System.out.println("\nSearching Data Karyawan");
            System.out.println("1. Search By Placement");
            System.out.println("0. Back To Main Menu");
            int choice = Helper.ensureValidIntInput("\nEnter your choice: ");

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
        String placement = Helper.ensureValidPlacementInput("\nMasukan kota Penempatan: ");
        List<Employee> results = searchingService.searchByPlacement(placement);
        if (results.isEmpty()) {
            System.out.println("No employees found for the given placement.");
        } else {
            PrintDisplay.printAllEmployees(results);
        }
    }
}
