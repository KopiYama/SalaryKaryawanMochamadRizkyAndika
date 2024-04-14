package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.model.ProjectLeader;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddProjectLeaderService;

public class AddProjectLeaderServiceImpl implements AddProjectLeaderService {

    @Override
    public void addProjectLeader(ProjectLeader projectLeader) {
        // Find the highest existing project leader ID
        int highestId = RepositoryEmployee.getAllEmployee().stream()
                .filter(emp -> emp instanceof ProjectLeader && emp.getEmployeeId().startsWith("PL-"))
                .mapToInt(emp -> Integer.parseInt(emp.getEmployeeId().substring(3)))
                .max()
                .orElse(0);  // Use 0 if no project leaders are found

        // Generate new project leader ID based on the highest ID found
        String newId = String.format("PL-%03d", highestId + 1);
        projectLeader.setEmployeeId(newId);
        RepositoryEmployee.addEmployee(projectLeader);  // Add to repository
    }
}
