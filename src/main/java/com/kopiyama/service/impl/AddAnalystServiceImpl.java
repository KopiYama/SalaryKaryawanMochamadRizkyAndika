package com.kopiyama.service.impl;

import com.kopiyama.model.Analyst;
import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.AddAnalystService;

public class AddAnalystServiceImpl implements AddAnalystService {

    @Override
    public void addAnalyst(Analyst analyst) {
        int analystCount = 0;
        // Iterate over all employees to count current analysts
        for (Employee emp : RepositoryEmployee.getAllEmployee()) {
            if (emp instanceof Analyst) {
                analystCount++;
            }
        }
        // Format the new ID based on the count
        String newId = String.format("Al-%03d", analystCount + 1);
        analyst.setEmployeeId(newId);
        RepositoryEmployee.addEmployee(analyst);
    }
}
