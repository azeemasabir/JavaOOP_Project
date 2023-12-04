package com.example.oop_semester_project;

public class HostelWorkingEmployee {
    private String employeeRole;
    private String employeeName;
    private String employeeID;
    private String employeeContact;


    public HostelWorkingEmployee(String employeeRole, String employeeName, String employeeID, String employeeContact) {
        this.employeeRole = employeeRole;
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.employeeContact = employeeContact;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }
}
