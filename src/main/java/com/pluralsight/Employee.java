package com.pluralsight;

public class Employee {
    private int employeeID;
    private String name;
    private float hoursWorked;
    private float payRate;

    public Employee(int employeeID, String name, float hoursWorked, float payRate) {
        this.employeeID = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }
    public int getID() {
        return this.employeeID;
    }
    public String getName() {
        return this.name;
    }
    public float getHours() {
        return this.hoursWorked;
    }
    public float getPayRate() {
        return this.payRate;
    }
    public float getGrossPay() {
        return hoursWorked * payRate;
    }

}
