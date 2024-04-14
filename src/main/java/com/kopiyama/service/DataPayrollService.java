package com.kopiyama.service;

import com.kopiyama.model.Employee;

import java.util.List;

public interface DataPayrollService {
    List<Employee> getAllEmployeeData();
    double calculateTotalPayroll();
}
