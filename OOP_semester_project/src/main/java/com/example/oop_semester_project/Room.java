package com.example.oop_semester_project;

public class Room {
    String RoomNo;
    String category;
    String status;
    String facility;

    public Room(String roomNo, String category, String status, String facility) {
        RoomNo = roomNo;
        this.category = category;
        this.status = status;
        this.facility = facility;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public String getFacility() {
        return facility;
    }
}
