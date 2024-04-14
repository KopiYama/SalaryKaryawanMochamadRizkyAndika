package com.kopiyama.view.print;

import com.kopiyama.model.*;
import com.kopiyama.service.impl.*;
import com.kopiyama.service.PlacementService;
import com.kopiyama.util.Helper;

public class AddEmployeeMenu {

    private AddEmployeeServiceImpl employeeService = new AddEmployeeServiceImpl();
    private PlacementService placementService = new PlacementService();
    private AddProgrammerServiceImpl programmerService = new AddProgrammerServiceImpl();
    private AddProjectLeaderServiceImpl projectLeaderService = new AddProjectLeaderServiceImpl();
    private AddAnalystServiceImpl analystService = new AddAnalystServiceImpl();

    public int displayPositionMenu() {
        int choice = -1;
        do {
            System.out.println("\nSelect Position");
            System.out.println("1. Employee");
            System.out.println("2. Programmer");
            System.out.println("3. Project Leader");
            System.out.println("4. Analyst");
            System.out.println("0. Back to Main Menu");
            choice = Helper.ensureValidIntInput("Enter your choice: ");

            if (choice < 0 || choice > 4) {
                System.out.println("Invalid choice. Please enter a number between 0 and 4.");
                continue;
            }
            break;
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
                addProjectLeaderDetails();
                break;
            case 4:  // Analyst
                addAnalystDetails();
                break;
            default:
                System.out.println("Invalid position choice. Please try again.");
                break;
        }
    }

    private void addEmployeeDetails() {
        System.out.println("\nAdd New For Employee");
        String name = Helper.ensureValidNameInput("Add Name: ");
        String address = Helper.ensureValidStringInput("Add Address: ");
        int age = Helper.ensureValidIntInput("Add Age: ");
        String jobdesc = Helper.ensureValidStringInput("Add Jobdesc: ");
        String placementName = Helper.ensureValidPlacementInput("Add Placement: ");
        double umk = placementService.getUmkByPlacementName(placementName);

        Employee newEmployee = new Employee(name, address, age, "", umk, jobdesc, new Placement(placementName, umk));
        employeeService.addEmployee(newEmployee);
        System.out.println("\nAdd Employee Success");
    }

    private void addProgrammerDetails() {
        System.out.println("\nAdd New For Programmer");
        String name = Helper.ensureValidNameInput("Add Name: ");
        String address = Helper.ensureValidStringInput("Add Address: ");
        int age = Helper.ensureValidIntInput("Add Age: ");
        String jobdesc = Helper.ensureValidStringInput("Add Jobdesc: ");
        String progLanguage = Helper.ensureValidStringInput("Add Prog Language: ");
        int experiences = Helper.ensureValidIntInput("Experiences: ");
        String placementName = Helper.ensureValidPlacementInput("Add Placement: ");
        double umk = placementService.getUmkByPlacementName(placementName);

        Programmer newProgrammer = new Programmer(name, address, age, "", umk, jobdesc, new Placement(placementName, umk), progLanguage, experiences, 0.0);
        programmerService.addProgrammer(newProgrammer);
        System.out.println("\nAdd Programmer Success");
    }

    private void addProjectLeaderDetails() {
        System.out.println("\nAdd New Project Leader");
        String name = Helper.ensureValidNameInput("Add Name: ");
        String address = Helper.ensureValidStringInput("Add Address: ");
        int age = Helper.ensureValidIntInput("Add Age: ");
        String jobdesc = Helper.ensureValidStringInput("Add Jobdesc: ");
        int totalProjects = Helper.ensureValidIntInput("Add Total Projects: ");
        String placementName = Helper.ensureValidPlacementInput("Add Placement: ");
        double umk = placementService.getUmkByPlacementName(placementName);

        ProjectLeader newProjectLeader = new ProjectLeader(name, address, age, "", umk, jobdesc, new Placement(placementName, umk), totalProjects, 0.0);
        projectLeaderService.addProjectLeader(newProjectLeader);
        System.out.println("\nAdd Project Leader Success");
    }

    private void addAnalystDetails() {
        System.out.println("\nAdd New Analyst");
        String name = Helper.ensureValidNameInput("Add Name: ");
        String address = Helper.ensureValidStringInput("Add Address: ");
        int age = Helper.ensureValidIntInput("Add Age: ");
        String jobdesc = Helper.ensureValidStringInput("Add Jobdesc: ");
        String placementName = Helper.ensureValidPlacementInput("Add Placement: ");
        double umk = placementService.getUmkByPlacementName(placementName);

        Analyst newAnalyst = new Analyst(name, address, age, "", umk, jobdesc, new Placement(placementName, umk), 0.0);
        analystService.addAnalyst(newAnalyst);
        System.out.println("\nAdd Analyst Success");
    }
}
