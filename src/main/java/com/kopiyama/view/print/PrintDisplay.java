package com.kopiyama.view.print;

import com.kopiyama.model.*;

import java.util.List;

public class PrintDisplay {

    public static void displayAllEmployees(List<Employee> employeeList) {
        System.out.println("+------------+-----------------------------------+-------------------+-----+----------------------+-------------+");
        System.out.println("| EmployeeId |               Name                |      Address      | Age |       Jobdesc        |  Placement  |");
        System.out.println("+------------+-----------------------------------+-------------------+-----+----------------------+-------------+");

        for (Employee employee : employeeList) {
            System.out.printf("| %-10s | %-33s | %-17s | %-3d | %-20s | %-11s |\n",
                    employee.getEmployeeId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getAge(),
                    employee.getJobdesc(),
                    employee.getPlacement().getPlacementName());
        }
        System.out.println("+------------+-----------------------------------+-------------------+-----+----------------------+-------------+");
    }
}
