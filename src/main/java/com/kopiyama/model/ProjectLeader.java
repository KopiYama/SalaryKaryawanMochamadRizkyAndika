package com.kopiyama.model;

public class ProjectLeader extends Employee{
    private int totalProject;
    private double allowance;

    public ProjectLeader() {
    }

    public ProjectLeader(String name, String address, int age, String employeeId, double salary, String jobdesc, Placement placement, int totalProject, double allowance) {
        super(name, address, age, employeeId, salary, jobdesc, placement);
        this.totalProject = totalProject;
        this.allowance = allowance;
        salaryCalculations();
        allowanceCalculation();
    }

    @Override
    public void salaryCalculations() {
        setSalary(getPlacement().getPlacementUmk() * 2);
    }

    @Override
    public void allowanceCalculation() {
        if (totalProject >= 2) {
            // Jika sedang menangani 2 project atau lebih, allowance 15% dari gaji
            allowance = getSalary() * 0.15;
        } else {
            // Jika sedang menangani kurang dari 2 project, allowance 5% dari gaji
            allowance = getSalary() * 0.05;
        }
    }

    public int getTotalProject() {
        return totalProject;
    }

    public void setTotalProject(int totalProject) {
        this.totalProject = totalProject;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Total Project = " + totalProject +
                "\nAllowance = Rp" + allowance + '\n';
    }
}
