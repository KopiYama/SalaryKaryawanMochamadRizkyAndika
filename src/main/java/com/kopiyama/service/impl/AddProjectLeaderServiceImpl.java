package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.model.ProjectLeader;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddProjectLeaderService;

import java.util.HashSet;
import java.util.Set;

public class AddProjectLeaderServiceImpl implements AddProjectLeaderService {

    @Override
    public void addProjectLeader(ProjectLeader projectLeader) {
        int projectLeaderCount = 0;
        for (Employee emp : RepositoryEmployee.getAllEmployee()) {
            if (emp instanceof ProjectLeader) {
                projectLeaderCount++;
            }
        }
        String newId = String.format("PL-%03d", projectLeaderCount + 1);
        // Find the highest existing project leader ID
        int highestId = RepositoryEmployee.getAllEmployee().stream()
                .filter(emp -> emp instanceof ProjectLeader && emp.getEmployeeId().startsWith("PL-"))
                .mapToInt(emp -> Integer.parseInt(emp.getEmployeeId().substring(3)))
                .max()
                .orElse(0);  // Use 0 if no project leaders are found

        // Generate new project leader ID based on the highest ID found
        newId = String.format("PL-%03d", highestId + 1); // Menggunakan kembali variabel yang sudah dideklarasikan
        projectLeader.setEmployeeId(newId);
        RepositoryEmployee.addEmployee(projectLeader);
    }

}
