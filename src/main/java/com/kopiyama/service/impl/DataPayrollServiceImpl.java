package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.DataPayrollService;

import java.util.List;

public class DataPayrollServiceImpl implements DataPayrollService {

    @Override
    public List<Employee> getAllEmployeeData() {
        return RepositoryEmployee.getAllEmployee();
    }

    @Override
    public double calculateTotalPayroll() {
        double total = 0.0;
        for (Employee emp : RepositoryEmployee.getAllEmployee()) {
            total += emp.getSalary() + emp.getAllowance();
        }
        return total;
    }
}
