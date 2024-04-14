package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.model.Placement;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.EditEmployeeService;
import com.kopiyama.service.PlacementService;

public class EditEmployeeServiceImpl implements EditEmployeeService {

    private PlacementService placementService;

    public EditEmployeeServiceImpl() {
        this.placementService = new PlacementService();
    }

    @Override
    public boolean editEmployeePlacement(String employeeId, String newPlacementName) {
        double newUmk = placementService.getUmkByPlacementName(newPlacementName);
        for (Employee emp : RepositoryEmployee.getAllEmployee()) {
            if (emp.getEmployeeId().equals(employeeId)) {
                // Create a new placement with the updated UMK
                Placement newPlacement = new Placement(newPlacementName, newUmk);
                emp.setPlacement(newPlacement);  // Set new placement

                // Recalculate salary and allowances
                emp.salaryCalculations();
                emp.allowanceCalculation();

                return true; // Success
            }
        }
        return false; // Employee not found
    }
}
