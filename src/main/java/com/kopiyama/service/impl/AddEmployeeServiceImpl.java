package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.model.Placement;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddEmployeeService;

public class AddEmployeeServiceImpl implements AddEmployeeService {

    @Override
    public void addEmployee(Employee employee) {
        int employeeCount = 0;
        for (Employee emp : RepositoryEmployee.getAllEmployee()) {
            if (emp.getEmployeeId().startsWith("Emp-")) {
                employeeCount++;
            }
        }
        String newId = String.format("Emp-%03d", employeeCount + 1);
        employee.setEmployeeId(newId);

        // Pastikan placement adalah instance baru jika memungkinkan
        Placement newPlacement = new Placement(employee.getPlacement().getPlacementName(), employee.getPlacement().getPlacementUmk());
        employee.setPlacement(newPlacement);

        RepositoryEmployee.addEmployee(employee);
    }
}
