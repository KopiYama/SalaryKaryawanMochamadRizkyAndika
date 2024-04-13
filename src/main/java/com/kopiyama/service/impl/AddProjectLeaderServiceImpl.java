package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.model.ProjectLeader;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddProjectLeaderService;

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
        projectLeader.setEmployeeId(newId);
        RepositoryEmployee.addEmployee(projectLeader);
    }
}
