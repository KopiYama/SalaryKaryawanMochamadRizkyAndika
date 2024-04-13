package com.kopiyama.model;

public class Programmer extends Employee{
    private String programmingLanguage;
    private int experiences;
    private double allowance;

    public Programmer() {
    }

    public Programmer(String name, String address, int age, String employeeId, double salary, String jobdesc, Placement placement, String programmingLanguage, int experiences, double allowance) {
        super(name, address, age, employeeId, salary, jobdesc, placement);
        this.programmingLanguage = programmingLanguage;
        this.experiences = experiences;
        this.allowance = allowance;
        salaryCalculations();
        allowanceCalculation();
    }

    @Override
    public void salaryCalculations() {
        setSalary(getPlacement().getPlacementUmk() * 1.5);
    }

    @Override
    public void allowanceCalculation() {
        if (experiences > 4) {
            allowance = getSalary() * 0.2;
        } else {
            allowance = getSalary() * 0.1;
        }
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public int getExperiences() {
        return experiences;
    }

    public void setExperiences(int experiences) {
        this.experiences = experiences;
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
        "Programming Language = " + programmingLanguage +
                "\nExperiences = " + experiences + " Tahun" +
                "\nAllowance = Rp" + allowance + '\n';
    }
}
