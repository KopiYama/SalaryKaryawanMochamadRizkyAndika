package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.model.Programmer;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddProgrammerService;

public class AddProgrammerServiceImpl implements AddProgrammerService {

    @Override
    public void addProgrammer(Programmer programmer) {
        // Find the highest existing programmer ID
        int highestId = RepositoryEmployee.getAllEmployee().stream()
                .filter(emp -> emp instanceof Programmer && emp.getEmployeeId().startsWith("Prog-"))
                .mapToInt(emp -> Integer.parseInt(emp.getEmployeeId().substring(5)))
                .max()
                .orElse(0);  // Use 0 if no programmers are found

        // Generate new programmer ID based on the highest ID found
        String newId = String.format("Prog-%03d", highestId + 1);
        programmer.setEmployeeId(newId);
        RepositoryEmployee.addEmployee(programmer);  // Add to repository
    }
}
