package com.kopiyama.service;

import com.kopiyama.model.Employee;

import java.util.List;

public interface SearchingService {
    List<Employee> searchByPlacement(String placement);
}
