
    public class HostelStaff implements Details{
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

        public void setName(String name) {
            this.name = name;
        }

        public String getStaffID() {
            return staffID;
        }

        public void setStaffID(String staffID) {
            this.staffID = staffID;
        }

        public String getContactInfo() {
            return contactInfo;
        }

        public void setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
        }
        public void showDetails() {
            System.out.println("Hostel Staff Details:");
            System.out.println("Name: " + name);
            System.out.println("Staff ID: " + staffID);
            System.out.println("Contact Information: " + contactInfo);
        }
    }

