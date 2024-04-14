package com.kopiyama.view.print;

import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.impl.EditEmployeeServiceImpl;
import com.kopiyama.util.Helper;

public class EditEmployeeDisplay {

    private EditEmployeeServiceImpl editEmployeeService = new EditEmployeeServiceImpl();

    public void displayEditEmployeeMenu() {
        // Use PrintDisplay to show all employees
        PrintDisplay.printAllEmployees(RepositoryEmployee.getAllEmployee());

        // Prompt user for input using Helper class for validation
        String empId = Helper.ensureValidStringInput("Enter Employee Id: ");
        String newPlacement = Helper.ensureValidPlacementInput("Enter New Placement: ");

        // Attempt to update employee placement
        if (editEmployeeService.editEmployeePlacement(empId, newPlacement)) {
            System.out.println("\nEdit Employee Success");
        } else {
            System.out.println("\nEmployee not found or error updating.");
        }
    }
}
