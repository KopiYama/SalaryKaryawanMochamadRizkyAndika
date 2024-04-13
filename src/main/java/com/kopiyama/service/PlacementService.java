package com.kopiyama.service;

import com.kopiyama.model.Placement;
import com.kopiyama.repository.RepositoryPlacement;

public class PlacementService {

    public double getUmkByPlacementName(String placementName) {
        for (Placement placement : RepositoryPlacement.getAllPlacements()) {
            if (placement.getPlacementName().equalsIgnoreCase(placementName)) {
                return placement.getPlacementUmk();
            }
        }
        throw new IllegalArgumentException("Placement not found");
    }
}
