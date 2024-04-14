package com.kopiyama.service.impl;

import com.kopiyama.model.Analyst;
import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddAnalystService;

public class AddAnalystServiceImpl implements AddAnalystService {

    @Override
    public void addAnalyst(Analyst analyst) {
        // Find the highest existing analyst ID
        int highestId = RepositoryEmployee.getAllEmployee().stream()
                .filter(emp -> emp instanceof Analyst && emp.getEmployeeId().startsWith("Al-"))
                .mapToInt(emp -> Integer.parseInt(emp.getEmployeeId().substring(3)))
                .max()
                .orElse(0);  // Use 0 if no analysts are found

        // Generate new analyst ID based on the highest ID found
        String newId = String.format("Al-%03d", highestId + 1);
        analyst.setEmployeeId(newId);
        RepositoryEmployee.addEmployee(analyst);  // Add to repository
    }
}
