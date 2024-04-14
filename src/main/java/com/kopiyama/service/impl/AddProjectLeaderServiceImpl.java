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
        Set<Integer> usedIds = new HashSet<>();
        RepositoryEmployee.getAllEmployee().stream()
                .filter(e -> e instanceof ProjectLeader && e.getEmployeeId().startsWith("PL-"))
                .forEach(e -> usedIds.add(Integer.parseInt(e.getEmployeeId().substring(3))));

        int newId = 1;
        while (usedIds.contains(newId)) {
            newId++;
        }

        String projectLeaderId = String.format("PL-%03d", newId);
        projectLeader.setEmployeeId(projectLeaderId);
        RepositoryEmployee.addEmployee(projectLeader);
    }
}
