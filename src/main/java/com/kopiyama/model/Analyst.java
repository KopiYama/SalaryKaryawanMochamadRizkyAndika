package com.kopiyama.model;

public class Analyst extends Employee{
    private double allowance;

    public Analyst() {
    }

    public Analyst(String name, String address, int age, String employeeId, double salary, String jobdesc, Placement placement, double allowance) {
        super(name, address, age, employeeId, salary, jobdesc, placement);
        this.allowance = allowance;
        salaryCalculations();
        allowanceCalculation();
    }

    @Override
    public void salaryCalculations() {
        setSalary(getPlacement().getPlacementUmk() * 1.6);
    }

    @Override
    public void allowanceCalculation() {
        allowance = getSalary() * 0.05;
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
                "Allowance = Rp" + allowance + '\n';
    }
}
