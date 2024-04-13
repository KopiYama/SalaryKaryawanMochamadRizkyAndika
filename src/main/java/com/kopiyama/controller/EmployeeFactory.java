package com.kopiyama.controller;

import com.kopiyama.model.*;

public class EmployeeFactory {

    public static Employee createEmployee(String name, String address, int age, String employeeId, double salary, String jobdesc, Placement placement) {
        return new Employee(name, address, age, employeeId, salary, jobdesc, placement);
    }

    public static Programmer createProgrammer(String name, String address, int age, String employeeId, double salary, String jobdesc, Placement placement, String programmingLanguage, int experiences) {
        return new Programmer(name, address, age, employeeId, salary, jobdesc, placement, programmingLanguage, experiences, 0.0);
    }

    public static ProjectLeader createProjectLeader(String name, String address, int age, String employeeId, double salary, String jobdesc, Placement placement, int totalProject) {
        return new ProjectLeader(name, address, age, employeeId, salary, jobdesc, placement, totalProject, 0.0);
    }

    public static Analyst createAnalyst(String name, String address, int age, String employeeId, double salary, String jobdesc, Placement placement) {
        return new Analyst(name, address, age, employeeId, salary, jobdesc, placement, 0.0);
    }
}
