package com.kopiyama.view.print;

import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.impl.DeleteEmployeeServiceImpl;

import java.util.Scanner;

public class DeleteEmployeeView {

    private Scanner scanner = new Scanner(System.in);
    private DeleteEmployeeServiceImpl deleteEmployeeService = new DeleteEmployeeServiceImpl();

    public void displayDeleteEmployeeMenu() {
        // Tampilkan semua karyawan
        System.out.println("\nDelete Employee");
        PrintDisplay.printAllEmployees(RepositoryEmployee.getAllEmployee());

        // Mintakan ID karyawan yang akan dihapus
        System.out.print("Enter Employee Id: ");
        String employeeId = scanner.nextLine();

        if (deleteEmployeeService.deleteEmployee(employeeId)) {
            System.out.println("\nDelete Employee success");
        } else {
            System.out.println("\nEmployee not found or error deleting.");
        }
    }
}
