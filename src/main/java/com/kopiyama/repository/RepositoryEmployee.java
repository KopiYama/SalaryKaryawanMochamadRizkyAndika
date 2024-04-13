package com.kopiyama.repository;

import com.kopiyama.controller.EmployeeFactory;
import com.kopiyama.model.*;

import java.util.ArrayList;
import java.util.List;

public class RepositoryEmployee {
    private static List<Employee> employeeList = new ArrayList<>();

    public static void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public static List<Employee> getAllEmployee() {
        return employeeList;
    }

    public static void initializeDefaultData() {
        Placement placement1 = new Placement("Garut", 1961085.00);
        Placement placement2 = new Placement("Bandung", 3742276.00);
        Placement placement3 = new Placement("Jakarta", 4453935.00);
        Placement placement4 = new Placement("Bekasi", 4782935.00);
        Placement placement5 = new Placement("Bogor", 4330249.00);

        addEmployee(EmployeeFactory.createEmployee("Susi", "Bandung", 27, "Emp-001", placement3.getPlacementUmk(), "Admin", placement3));
        addEmployee(EmployeeFactory.createEmployee("Anto", "Bandung", 35, "Emp-002", placement2.getPlacementUmk(), "Office Boy", placement2));
        addEmployee(EmployeeFactory.createEmployee("Riman", "Jakarta", 28, "Emp-003", placement2.getPlacementUmk(), "Human Resource Dev", placement2));

        addEmployee(EmployeeFactory.createProgrammer("Budi", "Bandung", 25, "Prog-001", placement3.getPlacementUmk(), "Back End Dev", placement3, "Java", 2));
        addEmployee(EmployeeFactory.createProgrammer("Ani", "Bandung", 30, "Prog-002", placement2.getPlacementUmk(), "Front End Dev", placement2, "React Js", 6));
        addEmployee(EmployeeFactory.createProgrammer("Ujang", "Bandung", 28, "Prog-003", placement2.getPlacementUmk(), "Full Stack Dev", placement2, "Kotlin", 4));

        addEmployee(EmployeeFactory.createProjectLeader("Ahmad", "Bandung", 25, "PL-001", placement1.getPlacementUmk(), "Project Leader", placement1, 2));
        addEmployee(EmployeeFactory.createProjectLeader("Dani", "Bandung", 30, "PL-002", placement4.getPlacementUmk(), "Scrum Master", placement4, 1));
        addEmployee(EmployeeFactory.createProjectLeader("Cecep", "Jakarta", 28, "PL-003", placement5.getPlacementUmk(), "Project Owner", placement5, 4));

        addEmployee(EmployeeFactory.createAnalyst("Indah", "Garut", 25, "Al-001", placement3.getPlacementUmk(), "Analyst", placement3));
        addEmployee(EmployeeFactory.createAnalyst("Puspa", "Bandung", 30, "Al-002", placement4.getPlacementUmk(), "Analyst", placement4));
        addEmployee(EmployeeFactory.createAnalyst("Sari", "Jakarta", 28, "Al-003", placement5.getPlacementUmk(), "Analyst", placement5));
    }
}
