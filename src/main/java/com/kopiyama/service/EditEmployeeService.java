package com.kopiyama.service;

import com.kopiyama.model.Employee;

public interface EditEmployeeService {
    boolean editEmployeePlacement(String employeeId, String newPlacementName);
}
