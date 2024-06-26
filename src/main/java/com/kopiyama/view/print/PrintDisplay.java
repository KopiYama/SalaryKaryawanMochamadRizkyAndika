package com.kopiyama.view.print;

import com.kopiyama.model.Employee;
import com.kopiyama.service.impl.DataPayrollServiceImpl;
import com.kopiyama.util.Helper;

import java.util.List;

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

    public static void printPayrollData() {
        DataPayrollServiceImpl payrollService = new DataPayrollServiceImpl();
        List<Employee> employees = payrollService.getAllEmployeeData();
        double totalPayroll = payrollService.calculateTotalPayroll();

        System.out.println("\nData Payroll");
        System.out.println("+--------------+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.println("| Employee ID  | Name                 | Job Description      | Placement            | Allowance            | Salary               |");
        System.out.println("+--------------+----------------------+----------------------+----------------------+----------------------+----------------------+");
        for (Employee emp : employees) {
            System.out.printf("| %-12s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    emp.getEmployeeId(),
                    emp.getName(),
                    emp.getJobdesc(),
                    emp.getPlacement().getPlacementName(),
                    String.format("Rp%.2f", emp.getAllowance()),
                    String.format("Rp%.2f", emp.getSalary()));
        }
        System.out.println("+--------------+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.printf("| Total Payroll                                                                                            | Rp%-5.2f        |\n", totalPayroll);
        System.out.println("+--------------+----------------------+----------------------+----------------------+----------------------+----------------------+");
        printReturnToMainMenu();
    }

    public static void printReturnToMainMenu() {
        int choice = Helper.ensureValidIntInput("\n0. Back to main menu\nEnter your choice: ");
        while (choice != 0) {
            System.out.println("Invalid choice. Please enter 0 to return to the main menu.");
            choice = Helper.ensureValidIntInput("Enter your choice: ");
        }
    }
}
