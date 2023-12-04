package com.example.oop_semester_project;

public class HostelStaff {
    private String name;
    private String staffID;
    private String contactInfo;

    public HostelStaff( String name, String staffID, String contactInfo) {
        this.name = name;
        this.staffID = staffID;
        this.contactInfo = contactInfo;
    }
    public String getName() {
        return name;
    }


    public String getStaffID() {
        return staffID;
    }

    public String getContactInfo() {
        return contactInfo;
    }

}
