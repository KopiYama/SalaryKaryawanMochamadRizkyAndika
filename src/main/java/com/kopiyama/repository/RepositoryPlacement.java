package com.kopiyama.repository;

import com.kopiyama.model.Placement;

import java.util.ArrayList;
import java.util.List;

public class RepositoryPlacement {
    private static List<Placement> placementList = new ArrayList<>();

    // Static initializer block to populate default data
    static {
        initializeDefaultData();
    }

    private static void initializeDefaultData() {
        placementList.add(new Placement("Garut", 1961085.00));
        placementList.add(new Placement("Bandung", 3742276.00));
        placementList.add(new Placement("Jakarta", 4453935.00));
        placementList.add(new Placement("Bekasi", 4782935.00));
        placementList.add(new Placement("Bogor", 4330249.00));
    }

    public static List<Placement> getAllPlacements() {
        return placementList;
    }
}
