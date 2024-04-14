package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.DeleteEmployeeService;

public class DeleteEmployeeServiceImpl implements DeleteEmployeeService {

    @Override
    public boolean deleteEmployee(String employeeId) {
        for (Employee emp : RepositoryEmployee.getAllEmployee()) {
            if (emp.getEmployeeId().equals(employeeId)) {
                RepositoryEmployee.getAllEmployee().remove(emp);
                return true;  // Karyawan berhasil dihapus
            }
        }
        return false;  // Karyawan dengan ID tersebut tidak ditemukan
    }
}
