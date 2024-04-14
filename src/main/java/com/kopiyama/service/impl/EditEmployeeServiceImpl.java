package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.model.Placement;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.EditEmployeeService;

public class EditEmployeeServiceImpl implements EditEmployeeService {

    @Override
    public boolean editEmployeePlacement(String employeeId, String newPlacementName) {
        for (Employee emp : RepositoryEmployee.getAllEmployee()) {
            if (emp.getEmployeeId().equals(employeeId)) {
                // Assuming Placement constructor and getters/setters are properly defined
                emp.setPlacement(new Placement(newPlacementName, emp.getPlacement().getPlacementUmk()));
                return true; // Return true if the employee was found and edited
            }
        }
        return false; // Return false if no employee with the given ID was found
    }
}
