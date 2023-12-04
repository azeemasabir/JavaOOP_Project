package com.example.oop_semester_project;

public class Fee {
  private  String name;
  private  String rollNo;
  private  String status;
  private  String feePending;

    public Fee(String name, String rollNo, String status, String feePending) {
        this.name = name;
        this.rollNo = rollNo;
        this.status = status;
        this.feePending = feePending;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getStatus() {
        return status;
    }


    public String getFeePending() {
        return feePending;
    }

}
