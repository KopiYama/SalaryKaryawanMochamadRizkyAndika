package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.model.Programmer;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddProgrammerService;

public class AddProgrammerServiceImpl implements AddProgrammerService {

    @Override
    public void addProgrammer(Programmer programmer) {
        int programmerCount = 0;
        // Get all employees and count only those who are programmers
        for (Employee emp : RepositoryEmployee.getAllEmployee()) {
            if (emp instanceof Programmer) {  // Check if the employee is an instance of Programmer
                programmerCount++;
            }
        }
        // Generate new programmer ID
        String newId = String.format("Prog-%03d", programmerCount + 1);
        programmer.setEmployeeId(newId);
        RepositoryEmployee.addEmployee(programmer);  // Add to repository
    }
}
