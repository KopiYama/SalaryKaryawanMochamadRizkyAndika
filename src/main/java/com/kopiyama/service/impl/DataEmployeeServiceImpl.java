package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.DataEmployeeService;
import com.kopiyama.view.print.PrintDisplay;

import java.util.List;

public class DataEmployeeServiceImpl implements DataEmployeeService {

    @Override
    public void displayAllEmployees() {
        List<Employee> employees = RepositoryEmployee.getAllEmployee();
        PrintDisplay.printAllEmployees(employees);
        PrintDisplay.printReturnToMainMenu();
    }
}
