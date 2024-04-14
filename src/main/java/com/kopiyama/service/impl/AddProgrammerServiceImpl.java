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
        Set<Integer> usedIds = new HashSet<>();
        RepositoryEmployee.getAllEmployee().stream()
                .filter(e -> e instanceof Programmer && e.getEmployeeId().startsWith("Prog-"))
                .forEach(e -> usedIds.add(Integer.parseInt(e.getEmployeeId().substring(5))));

        int newId = 1;
        while (usedIds.contains(newId)) {
            newId++;
        }

        String programmerId = String.format("Prog-%03d", newId);
        programmer.setEmployeeId(programmerId);
        RepositoryEmployee.addEmployee(programmer);
    }
}
