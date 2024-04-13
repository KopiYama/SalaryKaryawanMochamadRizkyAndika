package com.kopiyama.model;

public class Employee extends Person{
    private String employeeId;
    private double salary;
    private String jobdesc;
    private Placement placement;

    public Employee() {
    }

    public Employee(String name, String address, int age, String employeeId, double salary, String jobdesc, Placement placement) {
        super(name, address, age);
        this.employeeId = employeeId;
        this.salary = salary;
        this.jobdesc = jobdesc;
        this.placement = placement;
        salaryCalculations();
    }

    public void salaryCalculations() {
        this.salary = placement.getPlacementUmk();
    }

    public void allowanceCalculation() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    @Override
    public String toString() {
        return "Employee : \n" +
                "Name = " + getName() + '\n' +
                "Address = " + getAddress() + '\n' +
                "Age = " + getAge() + '\n' +
                "Employee Id = " + getEmployeeId() + '\n' +
                "Salary = Rp" + getSalary() + '\n' +
                "Jobdesc = " + getJobdesc() + '\n' +
                "Placement = " + placement.getPlacementName() + '\n';
    }
}
