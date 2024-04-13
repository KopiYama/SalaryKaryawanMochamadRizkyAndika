package com.kopiyama;

import com.kopiyama.model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Placement placement1 = new Placement("Garut", 1961085.00);

        Employee employee1 = new Employee("Rizky", "Garut", 23, "Emp-001", placement1.getPlacementUmk(), "HRD", placement1);
        Programmer programmer1 = new Programmer("Rizky", "Garut", 23, "Prog-001", placement1.getPlacementUmk(), "Back End Dev", placement1, "Java", 5, 0.0);
        ProjectLeader projectLeader1 = new ProjectLeader("Rizky", "Garut", 23, "PL-001", placement1.getPlacementUmk(), "Prject Leader", placement1, 3, 0.0);
        Analyst analyst1 = new Analyst("Rizky", "Garut", 23, "Anl-001", placement1.getPlacementUmk(), "Analyst", placement1, 0.0);

        System.out.println(placement1);
        System.out.println(employee1);
        System.out.println(programmer1);
        System.out.println(projectLeader1);
        System.out.println(analyst1);
    }
}