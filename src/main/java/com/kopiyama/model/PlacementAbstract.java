package com.kopiyama.model;

public abstract class PlacementAbstract {
    protected String placementName;
    protected double placementUmk;

    public PlacementAbstract() {
    }

    public PlacementAbstract(String placementName, double placementUmk) {
        this.placementName = placementName;
        this.placementUmk = placementUmk;
    }

    public String getPlacementName() {
        return placementName;
    }

    public void setPlacementName(String placementName) {
        this.placementName = placementName;
    }

    public double getPlacementUmk() {
        return placementUmk;
    }

    public void setPlacementUmk(double placementUmk) {
        this.placementUmk = placementUmk;
    }

    @Override
    public String toString() {
        return "Placement : \n" +
                "Placement Name = " + placementName + '\n' +
                "Placement UMK = Rp" + placementUmk + '\n';
    }
}
