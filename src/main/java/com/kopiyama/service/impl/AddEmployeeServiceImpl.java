package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddEmployeeService;

public class AddEmployeeServiceImpl implements AddEmployeeService {

    @Override
    public void addEmployee(Employee employee) {
        int highestId = RepositoryEmployee.getAllEmployee().stream()
                .filter(emp -> emp.getEmployeeId().startsWith("Emp-"))
                .mapToInt(emp -> Integer.parseInt(emp.getEmployeeId().substring(4)))
                .max().orElse(0);
        String newId = String.format("Emp-%03d", highestId + 1);
        employee.setEmployeeId(newId);
        RepositoryEmployee.addEmployee(employee);
    }
}
