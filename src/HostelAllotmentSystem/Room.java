package HostelAllotmentSystem;
import java.util.ArrayList;
public class Room {
        private static final int MAX_CAPACITY = 3;
    private static final int MAX_CAPACITY_SINGLE = 1;
    private static final int MAX_CAPACITY_DOUBLE = 2;
    private static final int MAX_CAPACITY_SHARED = 3;

        private int roomNumber;
        private boolean isOccupied;
        private ArrayList<Student> occupants;
        private Facility[] facilities;
    private RoomType roomType;

        public Room(int roomNumber,RoomType roomType) {
            this.roomNumber = roomNumber;
            this.isOccupied = false;
            this.occupants = new ArrayList<>();
            this.facilities = new Facility[MAX_CAPACITY];
            this.roomType = roomType;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public boolean isOccupied() {
            return isOccupied;
        }

        public ArrayList<Student> getOccupants() {
            return occupants;
      }
    public Facility[] getFacilities() {
        return facilities;
    }
    public RoomType getRoomType() {
        return roomType;
    }


    public void setFacilities(Facility[] facilities) {
        if (facilities.length <= MAX_CAPACITY) {
            this.facilities = facilities;
        } else {
            System.out.println("Error: Too many facilities provided.");
        }
    }

    public String getFacilitiesAsString() {
        if (facilities[0] == null) {
            return "None";
        } else {
            StringBuilder facilitiesString = new StringBuilder();
            for (Facility facility : facilities) {
                facilitiesString.append(facility).append(", ");
            }
            return facilitiesString.substring(0, facilitiesString.length() - 2);
        }
    }

    public void assignStudent(Student student, int enrollDay, int enrollMonth, int enrollYear) {
        int maxCapacity = getMaxCapacity();

        if (isOccupied) {
            System.out.println("Room " + roomNumber + " is already occupied.");
        } else if (occupants.size() >= maxCapacity) {
            System.out.println("Room " + roomNumber + " is at maximum capacity.");
        } else if (enrollYear <= 0 || enrollMonth <= 0 || enrollDay <= 0) {
            System.out.println("Invalid enrollment date for Student " + student.getStudentName());
        } else {
            occupants.add(student);
            student.enroll(enrollDay, enrollMonth, enrollYear);
            isOccupied = true;
            System.out.println("Student " + student.getStudentName() + " assigned to Room " + roomNumber);
        }
    }

    private int getMaxCapacity() {
        switch (roomType) {
            case SINGLE:
                return 1;
            case DOUBLE:
                return 2;
            case SHARED:
                return 3;
            default:
                return 0; // Handle other cases as needed
        }
    }
    public void vacateRoom(int day, int month, int year) {
        for (Student student : occupants) {
            student.leave(day, month, year);
        }
        occupants.clear();
        isOccupied = false;
        System.out.println("Room " + roomNumber + " vacated.");
    }
    public void showDetails() {
        System.out.println("Room Details:");
        if (isOccupied) {
            System.out.println("Occupants:");

            for (Student student : occupants) {
                student.showDetails();
            }
        }
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Occupancy Status: " + (isOccupied ? "Occupied" : "Vacant"));
        System.out.println("Room Type: " + roomType);
        System.out.println("Facilities: " + getFacilitiesAsString());

    }
    }

