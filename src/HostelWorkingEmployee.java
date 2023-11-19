

    public class HostelWorkingEmployee extends HostelStaff {
        private String role;

        public HostelWorkingEmployee(String name, String staffID, String contactInfo, String role) {
            super( name, staffID, contactInfo);
            this.role = role;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
        public void showDetails() {
            super.showDetails();
            System.out.println("Role: " + role);
        }

}
