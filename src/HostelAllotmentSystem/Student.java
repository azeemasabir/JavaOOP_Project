package HostelAllotmentSystem;

public class Student implements Details {
    private String studentName;
    private int rollNumber;
    private Date enrollmentDate;
    private Date leavingDate;
    private Fee fees;

    public Student(String studentName,int rollNumber) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public void setFees(Fee fees) {
        this.fees = fees;
    }
    public Fee getFees() {
        return fees;
    }


        public void leave(int day, int month, int year) {
            if (leavingDate == null) {
                leavingDate = new Date(day, month, year); // Set leaving date to the current date
                System.out.println(studentName + " has left the hostel.");
            } else {
                System.out.println(studentName + " has already left the hostel.");
            }
        }

        public void enroll(int day, int month, int year) {
            if (enrollmentDate == null) {
                enrollmentDate = new Date(day, month, year); // Set enrollment date to the current date
                System.out.println(studentName + " has enrolled in the hostel.");
            } else {
                System.out.println(studentName + " is already enrolled in the hostel.");
            }
        }
    public void checkFeeStatus() {
        if (fees != null && fees.getAmount() > 0) {
            System.out.println("Fees ststus:");
            System.out.println(studentName + " has pending fees of " + fees.getAmount());
        } else if (fees != null && fees.getAmount() == 0) {
            System.out.println("Fees ststus:");
            System.out.println(studentName + " has paid all fees.");
        } else {
            System.out.println("Fee Status:");
            System.out.println("No fee information available for "+ studentName);
        }
    }
    public String getDuration() {
        if (enrollmentDate != null && leavingDate != null) {
            // Calculate duration (assuming simple calculation for demonstration)
            // You may want to use java.time.LocalDate for a more accurate duration calculation
            int durationDays = leavingDate.getDay() - enrollmentDate.getDay();
            int durationMonths = leavingDate.getMonth() - enrollmentDate.getMonth();
            int durationYears = leavingDate.getYear() - enrollmentDate.getYear();

            return  "the duation of " +getStudentName()+ " stayed in hostel is " + durationYears + " years, " + durationMonths + " months, " + durationDays + " days";
        } else {
            return "Not Applicable";
        }
    }
    @Override
    public void showDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Enrollment date :" + getEnrollmentDate());
    }

}



