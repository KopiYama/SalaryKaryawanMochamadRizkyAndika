package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.model.Programmer;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddProgrammerService;

import java.util.HashSet;
import java.util.Set;

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
        // Find the highest existing programmer ID
        int highestId = RepositoryEmployee.getAllEmployee().stream()
                .filter(emp -> emp instanceof Programmer && emp.getEmployeeId().startsWith("Prog-"))
                .mapToInt(emp -> Integer.parseInt(emp.getEmployeeId().substring(5)))
                .max()
                .orElse(0);  // Use 0 if no programmers are found

        // Generate new programmer ID based on the highest ID found
        newId = String.format("Prog-%03d", highestId + 1); // Menggunakan kembali variabel yang sudah dideklarasikan
        programmer.setEmployeeId(newId);
        RepositoryEmployee.addEmployee(programmer);  // Add to repository
    }

}
