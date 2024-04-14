package com.kopiyama.service.impl;

import com.kopiyama.model.Employee;
import com.kopiyama.repository.RepositoryEmployee;
import com.kopiyama.service.SearchingService;

import java.util.List;
import java.util.stream.Collectors;

public class SearchingServiceImpl implements SearchingService {

    @Override
    public List<Employee> searchByPlacement(String placement) {
        return RepositoryEmployee.getAllEmployee().stream()
                .filter(emp -> emp.getPlacement().getPlacementName().equalsIgnoreCase(placement))
                .collect(Collectors.toList());
    }
}
