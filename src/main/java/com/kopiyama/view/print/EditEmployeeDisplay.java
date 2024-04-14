package com.kopiyama.view.print;

import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.impl.EditEmployeeServiceImpl;
import java.util.Scanner;

public class EditEmployeeDisplay {

    private Scanner scanner = new Scanner(System.in);
    private EditEmployeeServiceImpl editEmployeeService = new EditEmployeeServiceImpl();

    public void displayEditEmployeeMenu() {
        // Use PrintDisplay to show all employees
        PrintDisplay.printAllEmployees(RepositoryEmployee.getAllEmployee());

        // Prompt user for input on the same line
        System.out.print("Enter Employee Id: ");
        String empId = scanner.nextLine();
        System.out.print("Enter New Placement: ");
        String newPlacement = scanner.nextLine();

        // Attempt to update employee placement
        if (editEmployeeService.editEmployeePlacement(empId, newPlacement)) {
            System.out.println("\nEdit Employee Success");
        } else {
            System.out.println("\nEmployee not found or error updating.");
        }
    }
}
