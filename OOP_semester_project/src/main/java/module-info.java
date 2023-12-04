module com.example.oop_semester_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.oop_semester_project to javafx.fxml;
    exports com.example.oop_semester_project;
}