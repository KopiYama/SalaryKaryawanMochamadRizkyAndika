package com.kopiyama.service.impl;

import com.kopiyama.model.Analyst;
import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddAnalystService;

import java.util.HashSet;
import java.util.Set;

public class AddAnalystServiceImpl implements AddAnalystService {

    @Override
    public void addAnalyst(Analyst analyst) {
        Set<Integer> usedIds = new HashSet<>();
        RepositoryEmployee.getAllEmployee().stream()
                .filter(e -> e instanceof Analyst && e.getEmployeeId().startsWith("Al-"))
                .forEach(e -> usedIds.add(Integer.parseInt(e.getEmployeeId().substring(3))));

        int newId = 1;
        while (usedIds.contains(newId)) {
            newId++;
        }

        String analystId = String.format("Al-%03d", newId);
        analyst.setEmployeeId(analystId);
        RepositoryEmployee.addEmployee(analyst);
    }
}
