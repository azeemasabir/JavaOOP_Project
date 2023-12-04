package com.example.oop_semester_project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {

    // Separate class to store valid credentials

    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
// Add background image
        // Add background image
        String imagePath = "C:/Users/Admin/IdeaProjects/OOP_semester_project/src/main/java/com/example/OOP_semester_project/Images/B.jpeg";
        try (InputStream stream = new FileInputStream(imagePath)) {
            Image backgroundImage = new Image(stream);


            // Set background size to maintain aspect ratio
            BackgroundSize backgroundSize = new BackgroundSize(
                    BackgroundSize.DEFAULT.getWidth(),
                    BackgroundSize.DEFAULT.getHeight(),
                    false,
                    false,
                     true,
                    true
            );

            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    backgroundSize
            );


            // Set background to the grid
            grid.setBackground(new Background(background));
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Add an ImageView with an Image to the GridPane
        Text scenetitle = new Text("Welcome");
        scenetitle.setFill(Color.FLORALWHITE);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        userName.setTextFill(Color.FLORALWHITE);
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        pw.setTextFill(Color.FLORALWHITE);
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (userTextField.getText().equals(User.VALID_USERNAME)
                        && pwBox.getText().equals(User.VALID_PASSWORD)) {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Login successful");
                    // If login is successful, move to the next scene
                    moveToNextScene(primaryStage);
                } else {
                    actiontarget.setFill(Color.FLORALWHITE);
                    actiontarget.setText("Invalid username or password");
                }
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hostel Allotment system");

        primaryStage.show();
    }

    // Method to move to the next scene
    private void moveToNextScene(Stage primaryStage) {
        // Create a new VBox for the next scene
        VBox nextVBox = new VBox(20);
        nextVBox.setAlignment(Pos.CENTER);
        nextVBox.setPadding(new Insets(25, 25, 25, 25));
        String imagePath = "C:/Users/Admin/IdeaProjects/OOP_semester_project/src/main/java/com/example/OOP_semester_project/Images/I.jpeg";
        try (InputStream stream = new FileInputStream(imagePath)) {
            Image backgroundImage = new Image(stream);

            // Set background size to maintain aspect ratio
            BackgroundSize backgroundSize = new BackgroundSize(
                    BackgroundSize.DEFAULT.getWidth(),
                    BackgroundSize.DEFAULT.getHeight(),
                    false,
                    false,
                    true,
                    true
            );

            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    backgroundSize
            );

            // Set background to the VBox in the next scene
            nextVBox.setBackground(new Background(background));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // You can leave this part if you want to keep the title or add something else
        Text sceneTitle = new Text("CLICK TO GET DETAILS");
        sceneTitle.setFill(Color.FLORALWHITE);
        sceneTitle.setFont(Font.font("Details", FontWeight.EXTRA_BOLD, 20));
        sceneTitle.setStyle("-fx-font-family: 'Arial';");

        nextVBox.getChildren().add(sceneTitle);
        // Create HBox for horizontal buttons
        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        Button back = new Button("BACK");
//        back.setStyle("-fx-background-color: purple;");
//        back.setPrefWidth(80);
//        back.setStyle("-fx-text-fill: white;");
        back.setOnAction(actionEvent -> {
            try {
                start(primaryStage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Create buttons with specified titles
        String[] buttonTitles = {"STUDENTS", "FEE", "ROOM", "HOSTEL STAFF", "HOSTEL EMPLOYEES"};
        for (String title : buttonTitles) {
            Button button = createStyledButton(title, primaryStage);
            buttonBox.getChildren().add(button);
        }

        // Add the HBox with buttons to the VBox
        nextVBox.getChildren().addAll(buttonBox,back);

        // Set the VBox in a new scene
        Scene nextScene = new Scene(nextVBox, 300, 275);
        nextScene.setFill(Color.LIGHTBLUE); // Set background color

        // Set the next scene on the primary stage
        primaryStage.setScene(nextScene);

    }


    // Method to create styled buttons
    private Button createStyledButton(String text, Stage primaryStage) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: #800080; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14pt;");


        button.setEffect(new Bloom()); // Add drop shadow effect
        if (text.equals("STUDENTS")) {
            button.setOnAction(e -> moveToStudentsScene(primaryStage));
        } else if (text.equals("FEE")) {
            button.setOnAction(e -> moveToFeeScene(primaryStage));
        } else if (text.equals("ROOM")) {
            button.setOnAction(e -> moveToRoomScene(primaryStage));
        }
        else if (text.equals(("HOSTEL STAFF"))){
            button.setOnAction(e -> moveToHostelStaffScene(primaryStage) );
        }
        else if (text.equals("HOSTEL EMPLOYEES")){
            button.setOnAction(e -> moveToWorkingEmployeesScene(primaryStage) );
        }

        return button;
    }

    // Add a new method to handle the action for the "STUDENTS" button
    private void moveToStudentsScene(Stage primaryStage) {
        // Create a new VBox for the "STUDENTS" scene
        VBox studentsVBox = new VBox(20);
        studentsVBox.setAlignment(Pos.CENTER);
        studentsVBox.setPadding(new Insets(25, 25, 25, 25));
        Button back = new Button("BACK");
        back.setOnAction(actionEvent -> moveToNextScene(primaryStage));

        // Add content specific to the "STUDENTS" scene
        Text studentsTitle = new Text("STUDENTS RECORD");
        studentsTitle.setFill(Color.FLORALWHITE);
        studentsTitle.setFont(Font.font("Details", FontWeight.EXTRA_BOLD, 20));
        studentsTitle.setStyle("-fx-font-family: 'Arial';");
        // Add background image
        String imagePath = "C:/Users/Admin/IdeaProjects/OOP_semester_project/src/main/java/com/example/OOP_semester_project/Images/J.jpeg";
        try (InputStream stream = new FileInputStream(imagePath)) {
            Image backgroundImage = new Image(stream);

            BackgroundSize backgroundSize = new BackgroundSize(
                    BackgroundSize.DEFAULT.getWidth(),
                    BackgroundSize.DEFAULT.getHeight(),
                    false,
                    false,
                    true,
                    true
            );

            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    backgroundSize
            );

            studentsVBox.setBackground(new Background(background));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a TableView
        TableView<Student> tableView = createStudentTableView();

        // Add buttons for adding and removing data
        Button addButton = createStyledButton("ADD", primaryStage);
        Button removeButton = createStyledButton("Remove", primaryStage);
        Button backButton = createStyledButton("Back", primaryStage);

        // Set actions for buttons
        addButton.setOnAction(e -> showAddStudentDialog(tableView));
        removeButton.setOnAction(e -> removeSelectedStudent(tableView));
        backButton.setOnAction(actionEvent -> moveToNextScene(primaryStage));
        // Add components to the VBox
        studentsVBox.getChildren().addAll(studentsTitle, tableView, addButton, removeButton, backButton);

        // Set the VBox in a new scene
        Scene studentsScene = new Scene(studentsVBox, 500, 400);
        studentsScene.setFill(Color.LIGHTBLUE); // Set background color

        // Set the students scene on the primary stage
        primaryStage.setScene(studentsScene);
    }

    // Method to create a TableView for students
    private TableView<Student> createStudentTableView() {
        TableView<Student> tableView = new TableView<>();

        // Create columns
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Student, String> rollNoColumn = new TableColumn<>("Roll No");
        TableColumn<Student, String> roomNoColumn = new TableColumn<>("Room No");
        TableColumn<Student, String> emailColumn = new TableColumn<>("Email");

        // Set cell value factories for columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        rollNoColumn.setCellValueFactory(new PropertyValueFactory<>("rollNo"));
        roomNoColumn.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        roomNoColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Add columns to the table
        tableView.getColumns().addAll(nameColumn, rollNoColumn, roomNoColumn, emailColumn);

        return tableView;
    }

    // Method to show a dialog for adding a new student
    private void showAddStudentDialog(TableView<Student> tableView) {
        Dialog<Student> dialog = new Dialog<>();
        dialog.setTitle("Add Student");
        dialog.setHeaderText("Enter student details:");

        // Set the button types
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Create and add input fields
        TextField nameField = new TextField();
        TextField rollNoField = new TextField();
        TextField roomNoField = new TextField();
        TextField emailField = new TextField();
        dialog.getDialogPane().setContent(new VBox(10, new Label("Name:"), nameField, new Label("Roll No:"), rollNoField, new Label("Room No"), roomNoField, new Label("Email"), emailField));

        // Enable/Disable add button depending on whether a name is entered
        Node addButtonNode = dialog.getDialogPane().lookupButton(addButton);
        addButtonNode.setDisable(true);

        // Validation logic
        nameField.textProperty().addListener((observable, oldValue, newValue) -> addButtonNode.setDisable(newValue.trim().isEmpty()));

        // Set result converter for the dialog
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                return new Student(nameField.getText(), rollNoField.getText(), roomNoField.getText(), emailField.getText());
            }
            return null;
        });

        // Show the dialog and process the result
        dialog.showAndWait().ifPresent(student -> {
            tableView.getItems().add(student);
        });
    }

    // Method to remove the selected student from the TableView
    private void removeSelectedStudent(TableView<Student> tableView) {
        Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            tableView.getItems().remove(selectedStudent);
        }
    }

    private void moveToFeeScene(Stage primaryStage) {
        VBox feeBox = new VBox(20);
        feeBox.setAlignment(Pos.CENTER);
        Button back = new Button("BACK");
        back.setOnAction(actionEvent -> moveToNextScene(primaryStage));
        feeBox.setPadding(new Insets(25, 25, 25, 25));
        Text feeTitle = new Text("FEE RECORD");
        feeTitle.setFill(Color.FLORALWHITE);
        feeTitle.setFont(Font.font("Details", FontWeight.EXTRA_BOLD, 20));
        feeTitle.setStyle("-fx-font-family: 'Arial';");
        String imagePath = "C:/Users/Admin/IdeaProjects/OOP_semester_project/src/main/java/com/example/OOP_semester_project/Images/H.jpeg";
        try (InputStream stream = new FileInputStream(imagePath)) {
            Image backgroundImage = new Image(stream);

            BackgroundSize backgroundSize = new BackgroundSize(
                    BackgroundSize.DEFAULT.getWidth(),
                    BackgroundSize.DEFAULT.getHeight(),
                    false,
                    false,
                    true,
                    true
            );

            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    backgroundSize
            );

            feeBox.setBackground(new Background(background));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create a TableView
        TableView<Fee> tableView = createFeeTableView();

        // Add buttons for adding and removing data
        Button addButton = createStyledButton("ADD", primaryStage);
        Button removeButton = createStyledButton("Remove", primaryStage);
        Button backButton = createStyledButton("Back", primaryStage);

        // Set actions for buttons
        addButton.setOnAction(e -> showAddFeeDialog(tableView));
        removeButton.setOnAction(e -> removeSelectedFee(tableView));
        backButton.setOnAction(actionEvent -> moveToNextScene(primaryStage));
        // Add components to the VBox
        feeBox.getChildren().addAll(feeTitle, tableView, addButton, removeButton,backButton);
        // Set the VBox in a new scene
        Scene feeScene = new Scene(feeBox, 300, 275);
        feeScene.setFill(Color.LIGHTBLUE); // Set background color

        // Set the fee scene on the primary stage
        primaryStage.setScene(feeScene);
    }

    // Method to create a TableView for students
    private TableView<Fee> createFeeTableView() {
        TableView<Fee> tableView = new TableView<>();

        // Create columns
        TableColumn<Fee, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Fee, String> rollNoColumn = new TableColumn<>("Roll No");
        TableColumn<Fee, String> statusColumn = new TableColumn<>("Status");
        TableColumn<Fee, String> pendingColumn = new TableColumn<>("Fee Pending");

        // Set cell value factories for columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        rollNoColumn.setCellValueFactory(new PropertyValueFactory<>("rollNo"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        pendingColumn.setCellValueFactory(new PropertyValueFactory<>("fee pending"));

        // Add columns to the table
        tableView.getColumns().addAll(nameColumn, rollNoColumn, statusColumn, pendingColumn);

        return tableView;
    }

    // Method to show a dialog for adding a new student
    private void showAddFeeDialog(TableView<Fee> tableView) {
        Dialog<Fee> dialog = new Dialog<>();
        dialog.setTitle("Add Fee");
        dialog.setHeaderText("Enter Fee details:");

        // Set the button types
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Create and add input fields
        TextField nameField = new TextField();
        TextField rollNoField = new TextField();
        TextField statusField = new TextField();
        TextField pendingField = new TextField();
        dialog.getDialogPane().setContent(new VBox(10, new Label("Name:"), nameField, new Label("Roll No:"), rollNoField, new Label("Fee Status"), statusField, new Label("Fee Pending"), pendingField));

        // Enable/Disable add button depending on whether a name is entered
        Node addButtonNode = dialog.getDialogPane().lookupButton(addButton);
        addButtonNode.setDisable(true);

        // Validation logic
        nameField.textProperty().addListener((observable, oldValue, newValue) -> addButtonNode.setDisable(newValue.trim().isEmpty()));

        // Set result converter for the dialog
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                return new Fee(nameField.getText(), rollNoField.getText(), statusField.getText(), pendingField.getText());
            }
            return null;
        });

        // Show the dialog and process the result
        dialog.showAndWait().ifPresent(fee -> {
            tableView.getItems().add(fee);
        });
        dialog.showAndWait().ifPresent(fee -> {
            tableView.getItems().add(fee);
        });
    }

    private void removeSelectedFee(TableView<Fee> tableView) {
        Fee selectedFee = tableView.getSelectionModel().getSelectedItem();
        if (selectedFee != null) {
            tableView.getItems().remove(selectedFee);
        }
    }

    private void moveToRoomScene(Stage primaryStage) {
        VBox roomBox = new VBox(20);
        roomBox.setAlignment(Pos.CENTER);
        Button back = new Button("BACK");
        back.setOnAction(actionEvent -> moveToNextScene(primaryStage));
        roomBox.setPadding(new Insets(25, 25, 25, 25));
        Text roomTitle = new Text("Room Details");
        roomTitle.setFill(Color.FLORALWHITE);
        roomTitle.setFont(Font.font("Details", FontWeight.EXTRA_BOLD, 20));
        roomTitle.setStyle("-fx-font-family: 'Arial';");
        String imagePath = "C:/Users/Admin/IdeaProjects/OOP_semester_project/src/main/java/com/example/OOP_semester_project/Images/H.jpeg";
        try (InputStream stream = new FileInputStream(imagePath)) {
            Image backgroundImage = new Image(stream);

            BackgroundSize backgroundSize = new BackgroundSize(
                    BackgroundSize.DEFAULT.getWidth(),
                    BackgroundSize.DEFAULT.getHeight(),
                    false,
                    false,
                    true,
                    true
            );

            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    backgroundSize
            );

            roomBox.setBackground(new Background(background));
        } catch (IOException e) {
            e.printStackTrace();
        }
// Create a TableView
        TableView<Room> tableView = createRoomTableView();

// Add buttons for adding and removing data
        Button addButton = createStyledButton("ADD", primaryStage);
        Button removeButton = createStyledButton("Remove", primaryStage);
        Button backButton = createStyledButton("Back", primaryStage);


// Set actions for buttons
        addButton.setOnAction(e -> showAddRoomDialog(tableView));
        removeButton.setOnAction(e -> removeSelectedRoom(tableView));
        backButton.setOnAction(actionEvent -> moveToNextScene(primaryStage));
        roomBox.getChildren().addAll(roomTitle, tableView, addButton, removeButton, backButton);

// Set the VBox in a new scene
        Scene roomScene = new Scene(roomBox, 300, 275);
        roomScene.setFill(Color.LIGHTBLUE); // Set background color

// Set the fee scene on the primary stage
        primaryStage.setScene(roomScene);

    }


    private TableView<Room> createRoomTableView() {
        TableView<Room> tableView = new TableView<>();

        // Create columns
        TableColumn<Room, String> roomNoColumn = new TableColumn<>("Room no");
        TableColumn<Room, String> categoryColumn = new TableColumn<>("Category");
        TableColumn<Room, String> statusColumn = new TableColumn<>("Status");
        TableColumn<Room, String> facilityColumn = new TableColumn<>("Facilities");

        // Set cell value factories for columns
        roomNoColumn.setCellValueFactory(new PropertyValueFactory<>("roomNo"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        facilityColumn.setCellValueFactory(new PropertyValueFactory<>("facility"));

        // Add columns to the table
        tableView.getColumns().addAll(roomNoColumn, categoryColumn, statusColumn, facilityColumn);

        return tableView;
    }

    private void showAddRoomDialog(TableView<Room> tableView) {
        Dialog<Room> dialog = new Dialog<>();
        dialog.setTitle("Add Room no");
        dialog.setHeaderText("Enter Room details:");

        // Set the button types
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Create and add input fields
        TextField roomNoField = new TextField();
        TextField categoryField = new TextField();
        TextField statusField = new TextField();
        TextField FacilityField = new TextField();
        dialog.getDialogPane().setContent(new VBox(10, new Label("Room no:"), roomNoField, new Label("Category:"), categoryField, new Label("Room Status"), statusField, new Label("Facilities"), FacilityField));

        // Enable/Disable add button depending on whether a name is entered
        Node addButtonNode = dialog.getDialogPane().lookupButton(addButton);
        addButtonNode.setDisable(true);

        // Validation logic
        roomNoField.textProperty().addListener((observable, oldValue, newValue) -> addButtonNode.setDisable(newValue.trim().isEmpty()));

        // Set result converter for the dialog
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                return new Room(roomNoField.getText(), categoryField.getText(), statusField.getText(), FacilityField.getText());
            }
            return null;
        });

        // Show the dialog and process the result
        dialog.showAndWait().ifPresent(room -> {
            tableView.getItems().add(room);
        });
    }

    private void removeSelectedRoom(TableView<Room> tableView) {
        Room selectedRoom = tableView.getSelectionModel().getSelectedItem();
        if (selectedRoom != null) {
            tableView.getItems().remove(selectedRoom);
        }
    }

    private void moveToHostelStaffScene(Stage primaryStage) {
        VBox staffBox = new VBox(20);
        staffBox.setAlignment(Pos.CENTER);
        Button back = new Button("BACK");
        back.setOnAction(actionEvent -> moveToNextScene(primaryStage));
        staffBox.setPadding(new Insets(25, 25, 25, 25));
        Text staffTitle = new Text("HOSTEL STAFF RECORD");
        staffTitle.setFill(Color.FLORALWHITE);
        staffTitle.setFont(Font.font("Details", FontWeight.EXTRA_BOLD, 20));
        staffTitle.setStyle("-fx-font-family: 'Arial';");
        String imagePath = "C:/Users/Admin/IdeaProjects/OOP_semester_project/src/main/java/com/example/OOP_semester_project/Images/H.jpeg";
        try (InputStream stream = new FileInputStream(imagePath)) {
            Image backgroundImage = new Image(stream);

            BackgroundSize backgroundSize = new BackgroundSize(
                    BackgroundSize.DEFAULT.getWidth(),
                    BackgroundSize.DEFAULT.getHeight(),
                    false,
                    false,
                    true,
                    true
            );

            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    backgroundSize
            );

            staffBox.setBackground(new Background(background));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TableView<HostelStaff> tableView = createHostelStaffTableView();

        // Add buttons for adding and removing data
        Button addButton = createStyledButton("ADD", primaryStage);
        Button removeButton = createStyledButton("Remove", primaryStage);
        Button backButton = createStyledButton("Back", primaryStage);

        // Set actions for buttons
        addButton.setOnAction(e -> showAddStaffDialog(tableView));
        removeButton.setOnAction(e -> removeSelectedStaff(tableView));
        backButton.setOnAction(actionEvent -> moveToNextScene(primaryStage));
        // Add components to the VBox
        staffBox.getChildren().addAll(staffTitle, tableView, addButton, removeButton, backButton);
        // Set the VBox in a new scene
        Scene staffScene = new Scene(staffBox, 300, 275);
        staffScene.setFill(Color.LIGHTBLUE); // Set background color

        // Set the fee scene on the primary stage
        primaryStage.setScene(staffScene);
    }
    private TableView<HostelStaff> createHostelStaffTableView() {
        TableView<HostelStaff> tableView = new TableView<>();

        // Create columns
        TableColumn<HostelStaff, String> nameColumn = new TableColumn<>("Staff Name");
        TableColumn<HostelStaff, String> idColumn = new TableColumn<>("Staff ID");
        TableColumn<HostelStaff, String> contactColumn = new TableColumn<>("Contact info");


        // Set cell value factories for columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));


        // Add columns to the table
        tableView.getColumns().addAll(nameColumn, idColumn, contactColumn);

        return tableView;
    }
    private void showAddStaffDialog(TableView<HostelStaff> tableView) {
        Dialog<HostelStaff> dialog = new Dialog<>();
        dialog.setTitle("Add Staff");
        dialog.setHeaderText("Enter Staff details:");

        // Set the button types
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Create and add input fields
        TextField nameField = new TextField();
        TextField idField = new TextField();
        TextField contactField = new TextField();

        dialog.getDialogPane().setContent(new VBox(10, new Label("Staff name:"), nameField, new Label("Staff ID:"), idField, new Label("Contact info"), contactField));

        // Enable/Disable add button depending on whether a name is entered
        Node addButtonNode = dialog.getDialogPane().lookupButton(addButton);
        addButtonNode.setDisable(true);

        // Validation logic
        nameField.textProperty().addListener((observable, oldValue, newValue) -> addButtonNode.setDisable(newValue.trim().isEmpty()));

        // Set result converter for the dialog
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                return new HostelStaff(nameField.getText(), idField.getText(), contactField.getText());
            }
            return null;
        });

        // Show the dialog and process the result
        dialog.showAndWait().ifPresent(hostelStaff -> {
            tableView.getItems().add(hostelStaff);
        });
    }

    private void removeSelectedStaff(TableView<HostelStaff> tableView) {
        HostelStaff selectedStaff = tableView.getSelectionModel().getSelectedItem();
        if (selectedStaff != null) {
            tableView.getItems().remove(selectedStaff);
        }
    }
    private void moveToWorkingEmployeesScene(Stage primaryStage) {
        VBox employeeBox = new VBox(20);
        employeeBox.setAlignment(Pos.CENTER);
        Button back = new Button("BACK");
        back.setOnAction(actionEvent -> moveToNextScene(primaryStage));
        employeeBox.setPadding(new Insets(25, 25, 25, 25));
        Text employeeTitle = new Text("HOSTEL STAFF RECORD");
        employeeTitle.setFill(Color.FLORALWHITE);
        employeeTitle.setFont(Font.font("Details", FontWeight.EXTRA_BOLD, 20));
        employeeTitle.setStyle("-fx-font-family: 'Arial';");
        String imagePath = "C:/Users/Admin/IdeaProjects/OOP_semester_project/src/main/java/com/example/OOP_semester_project/Images/H.jpeg";
        try (InputStream stream = new FileInputStream(imagePath)) {
            Image backgroundImage = new Image(stream);

            BackgroundSize backgroundSize = new BackgroundSize(
                    BackgroundSize.DEFAULT.getWidth(),
                    BackgroundSize.DEFAULT.getHeight(),
                    false,
                    false,
                    true,
                    true
            );

            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    backgroundSize
            );

            employeeBox.setBackground(new Background(background));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TableView<HostelWorkingEmployee> tableView = createHostelWorkingEmployeeTableView();

        // Add buttons for adding and removing data
        Button addButton = createStyledButton("ADD", primaryStage);
        Button removeButton = createStyledButton("Remove", primaryStage);
        Button backButton = createStyledButton("Back", primaryStage);

        // Set actions for buttons
        addButton.setOnAction(e -> showAddEmployeeDialog(tableView));
        removeButton.setOnAction(e -> removeSelectedEmployee(tableView));
        backButton.setOnAction(actionEvent -> moveToNextScene(primaryStage));
        // Add components to the VBox
        employeeBox.getChildren().addAll(employeeTitle, tableView, addButton, removeButton, backButton);
        // Set the VBox in a new scene
        Scene employeeScene = new Scene(employeeBox, 300, 275);
        employeeScene.setFill(Color.LIGHTBLUE); // Set background color

        // Set the fee scene on the primary stage
        primaryStage.setScene(employeeScene);
    }
    private TableView<HostelWorkingEmployee> createHostelWorkingEmployeeTableView() {
        TableView<HostelWorkingEmployee> tableView = new TableView<>();

        // Create columns
        TableColumn<HostelWorkingEmployee, String> nameColumn = new TableColumn<>("Employee Name");
        TableColumn<HostelWorkingEmployee, String> idColumn = new TableColumn<>("Employee ID");
        TableColumn<HostelWorkingEmployee, String> contactColumn = new TableColumn<>("Employee Contact info");
        TableColumn<HostelWorkingEmployee, String> roleColumn = new TableColumn<>("Employee Role");


        // Set cell value factories for columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("employeeInfo"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("employeeRole"));


        // Add columns to the table
        tableView.getColumns().addAll(nameColumn, idColumn, contactColumn,roleColumn);

        return tableView;
    }
    private void showAddEmployeeDialog(TableView<HostelWorkingEmployee> tableView) {
        Dialog<HostelWorkingEmployee> dialog = new Dialog<>();
        dialog.setTitle("Add Employee");
        dialog.setHeaderText("Enter Employee details:");

        // Set the button types
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Create and add input fields
        TextField employeeNameField = new TextField();
        TextField employeeIDField = new TextField();
        TextField employeeContactField = new TextField();
        TextField roleField = new TextField();

        dialog.getDialogPane().setContent(new VBox(10, new Label("Employee name:"), employeeNameField, new Label("Employee ID:"), employeeIDField, new Label("Employee Contact info"), employeeContactField, new Label("Employee Role"), roleField));

        // Enable/Disable add button depending on whether a name is enteredcd
        Node addButtonNode = dialog.getDialogPane().lookupButton(addButton);
        addButtonNode.setDisable(true);

        // Validation logic
        employeeNameField.textProperty().addListener((observable, oldValue, newValue) -> addButtonNode.setDisable(newValue.trim().isEmpty()));

        // Set result converter for the dialog
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                return new HostelWorkingEmployee(employeeNameField.getText(), employeeIDField.getText(), employeeContactField.getText(), roleField.getText());
            }
            return null;
        });

        // Show the dialog and process the result
        dialog.showAndWait().ifPresent(hostelWorkingEmployee -> {
            tableView.getItems().add(hostelWorkingEmployee);
        });
    }

    private void removeSelectedEmployee(TableView<HostelWorkingEmployee> tableView) {
        HostelWorkingEmployee selectedEmployee = tableView.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            tableView.getItems().remove(selectedEmployee);
        }
    }
    public static void main (String[]args){
            launch();
        }
    }
