package com.example.oop_semester_project;

public class Student {
    private String name;
    private String rollNo;
    private String roomNo;
    private String email;

    public String getEmail() {
        return email;
    }

    public Student(String name, String rollNo, String roomNo, String email) {
        this.name = name;
        this.rollNo = rollNo;
        this.roomNo = roomNo;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getRoomNo() {
        return roomNo;
    }
}
