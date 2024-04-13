package com.kopiyama.view.print;

import com.kopiyama.model.Employee;
import com.kopiyama.model.Placement;
import com.kopiyama.model.Programmer;
import com.kopiyama.model.ProjectLeader;
import com.kopiyama.service.impl.AddEmployeeServiceImpl;
import com.kopiyama.service.PlacementService;
import com.kopiyama.service.impl.AddProgrammerServiceImpl;
import com.kopiyama.service.impl.AddProjectLeaderServiceImpl;

import java.util.Scanner;

public class AddEmployeeMenu {

    private Scanner scanner = new Scanner(System.in);
    private AddEmployeeServiceImpl employeeService = new AddEmployeeServiceImpl();
    private PlacementService placementService = new PlacementService();
    private AddProgrammerServiceImpl programmerService = new AddProgrammerServiceImpl();
    private AddProjectLeaderServiceImpl projectLeaderService = new AddProjectLeaderServiceImpl();


    public int displayPositionMenu() {
        int choice = -1;
        do {
            System.out.println("\nSelect Position");
            System.out.println("1. Employee");
            System.out.println("2. Programmer");
            System.out.println("3. Project Leader");
            System.out.println("4. Analyst");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice < 0 || choice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (true);

        if (choice > 0 && choice <= 4) {
            handleEmployeeCreation(choice);
        }
        return choice;
    }

    private void handleEmployeeCreation(int positionChoice) {
        switch (positionChoice) {
            case 1:  // Employee
                addEmployeeDetails();
                break;
            case 2:  // Programmer
                addProgrammerDetails();
                break;
            case 3:  // Project Leader
                addProjectLeaderDetails();  // Metode ini harus Anda buat
                break;
            case 4:  // Analyst
                //addAnalystDetails();  // Metode ini harus Anda buat
                break;
            default:
                System.out.println("Invalid position choice. Please try again.");
                break;
        }
    }

    private void addEmployeeDetails() {
        System.out.println("\nAdd New For Employee");
        System.out.print("Add Name: ");
        String name = scanner.nextLine();
        System.out.print("Add Address: ");
        String address = scanner.nextLine();
        System.out.print("Add Age: ");
        int age = Integer.parseInt(scanner.nextLine());  // Ensure valid integer input
        System.out.print("Add Jobdesc: ");
        String jobdesc = scanner.nextLine();
        System.out.print("Add Placement: ");
        String placementName = scanner.nextLine();
        double umk = placementService.getUmkByPlacementName(placementName);

        Employee newEmployee = new Employee(name, address, age, "", umk, jobdesc, new Placement(placementName, umk));
        employeeService.addEmployee(newEmployee);
        System.out.println("\nAdd Employee Success");
    }

    private void addProgrammerDetails() {
        System.out.println("\nAdd New For Programmer");
        System.out.print("Add Name: ");
        String name = scanner.nextLine();
        System.out.print("Add Address: ");
        String address = scanner.nextLine();
        System.out.print("Add Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Jobdesc: ");
        String jobdesc = scanner.nextLine();
        System.out.print("Add Prog Language: ");
        String progLanguage = scanner.nextLine();
        System.out.print("Experiences: ");
        int experiences = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Placement: ");
        String placementName = scanner.nextLine();
        double umk = placementService.getUmkByPlacementName(placementName);

        Programmer newProgrammer = new Programmer(name, address, age, "", umk, jobdesc, new Placement(placementName, umk), progLanguage, experiences, 0.0);
        programmerService.addProgrammer(newProgrammer);
        System.out.println("\nAdd Programmer Success");
    }

    private void addProjectLeaderDetails() {
        System.out.println("\nAdd New Project Leader");
        System.out.print("Add Name: ");
        String name = scanner.nextLine();
        System.out.print("Add Address: ");
        String address = scanner.nextLine();
        System.out.print("Add Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Jobdesc: ");
        String jobdesc = scanner.nextLine();
        System.out.print("Add Total Projects: ");
        int totalProjects = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Placement: ");
        String placementName = scanner.nextLine();
        double umk = placementService.getUmkByPlacementName(placementName);

        ProjectLeader newProjectLeader = new ProjectLeader(name, address, age, "", umk, jobdesc, new Placement(placementName, umk), totalProjects, 0.0);
        projectLeaderService.addProjectLeader(newProjectLeader);
        System.out.println("Add Project Leader Success");
    }
}
