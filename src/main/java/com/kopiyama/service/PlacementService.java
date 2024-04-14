package com.kopiyama.service;

import com.kopiyama.model.Employee;
import com.kopiyama.model.Placement;
import com.kopiyama.repository.RepositoryEmployee;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlacementService {

    public double getUmkByPlacementName(String placementName) {
        Set<Placement> uniquePlacements = extractUniquePlacements();
        for (Placement placement : uniquePlacements) {
            if (placement.getPlacementName().equalsIgnoreCase(placementName)) {
                return placement.getPlacementUmk();
            }
        }
        throw new IllegalArgumentException("Placement not found");
    }

    private Set<Placement> extractUniquePlacements() {
        Set<Placement> uniquePlacements = new HashSet<>();
        List<Employee> employees = RepositoryEmployee.getAllEmployee();
        for (Employee emp : employees) {
            uniquePlacements.add(emp.getPlacement());
        }
        return uniquePlacements;
    }
}
