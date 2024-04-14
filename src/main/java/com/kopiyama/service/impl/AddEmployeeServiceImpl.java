package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddEmployeeService;

import java.util.HashSet;
import java.util.Set;

public class AddEmployeeServiceImpl implements AddEmployeeService {

    @Override
    public void addEmployee(Employee employee) {
        Set<Integer> usedIds = new HashSet<>();
        RepositoryEmployee.getAllEmployee().stream()
                .filter(e -> e.getEmployeeId().startsWith("Emp-"))
                .forEach(e -> usedIds.add(Integer.parseInt(e.getEmployeeId().substring(4))));

        int newId = 1;
        while (usedIds.contains(newId)) {
            newId++;
        }

        String employeeId = String.format("Emp-%03d", newId);
        employee.setEmployeeId(employeeId);
        RepositoryEmployee.addEmployee(employee);
    }
}
