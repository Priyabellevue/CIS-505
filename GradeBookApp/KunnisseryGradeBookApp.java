/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package GradeBookApp;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KunnisseryGradeBookApp extends Application { /* Begin ZuckGradeBookApp, extending JavaFX Application. */
    /* These are the attributes of the grade book app. */
    private TextField txtFirstName = new TextField();
    private TextField txtLastName = new TextField();
    private TextField txtCourse = new TextField();
    private Label lblFirstName = new Label("First Name: ");
    private Label lblLastName = new Label("Last Name: ");
    private Label lblCourse = new Label("Course: ");
    private Label lblCourseFormat = new Label ("Ex: CIS 505");
    private Label lblGrade = new Label ("Grade: ");
    private ComboBox<String> cbGrade = new ComboBox<>();
    private String[] gradeOptions = { "A", "B", "C", "D", "E", "F"};
    private Button btnClear = new Button("Clear");
    private Button btnSave = new Button("Save");
    private Button btnView = new Button("View");
    private TextArea txtResults = new TextArea();

    /* This overrides the start method. */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grade Book Form"); /* Title set. */

        /* This creates the pane and adds all my attributes to it. */
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(txtFirstName, 1, 0);
        pane.add(txtLastName, 1, 1);
        pane.add(txtCourse, 1, 2);
        pane.add(lblFirstName, 0, 0);
        pane.add(lblLastName, 0, 1);
        pane.add(lblCourse, 0, 2);
        pane.add(lblGrade, 0, 4);
        pane.add(cbGrade, 1, 4, 2, 1);
        pane.add(txtResults,0,7,2,1);

        /* This sets the format for the course title, positions it, and fills the text red. */
        pane.add(lblCourseFormat, 1, 3);
        lblCourseFormat.setTextFill(Color.RED);
        GridPane.setHalignment(lblCourseFormat, HPos.RIGHT);

        /* This sets the values for the grades combo box. */
        ObservableList<String>grades = FXCollections.observableArrayList(gradeOptions);
        cbGrade.getItems().addAll(grades);

        /* This creates a container for my three buttons, positions it, and adds it to the pane. */
        HBox actionBtn = new HBox();
        actionBtn.setPadding(new Insets(15, 0, 15, 30));
        actionBtn.setSpacing(10);
        actionBtn.getChildren().add(btnClear);
        actionBtn.getChildren().add(btnSave);
        actionBtn.getChildren().add(btnView);
        pane.add(actionBtn, 0, 6, 2, 1);
        GridPane.setHalignment(actionBtn, HPos.CENTER);

        /* This sets the actions for the buttons. */
        btnClear.setOnAction(e -> clearFormFields());
        btnSave.setOnAction(e -> saveGradeForm());
        btnView.setOnAction(e -> viewGrades());

        /* This creates the scene, adds the pane to the scene, the scene to the stage, and then shows the stage. */
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    } /* End overridden start method. */

    /* This clears the form. */
    private void clearFormFields(){
        txtFirstName.setText("");
        txtLastName.setText("");
        txtCourse.setText("");
        cbGrade.setValue(null);
        txtResults.setText("");
    }

    /* This writes the field entries to a file called "grades.csv". */
    
        private void saveGradeForm(){
        ArrayList<Student> students = new ArrayList<Student>();

        Student student = new Student();
        student.setFirstName(txtFirstName.getText());
        student.setLastName(txtLastName.getText());
        student.setCourse(txtCourse.getText());
        student.setGrade(cbGrade.getValue());

        students.add(student);
        try {
            StudentIO.insert(students);
            txtResults.setText("Grade saved successfully.");
        } catch (IOException e) {
            txtResults.setText("Error saving grade: " + e.getMessage());
        }
    }

    /* This method presents the grades in the results area. */
    
    private void viewGrades() {
        try {
            String filterCourse = txtCourse.getText().trim();
            ArrayList<Student> students = StudentIO.findAll();
            StringBuilder viewedGrades = new StringBuilder();
    
            for (Student student : students) {
                if (filterCourse.isEmpty() || student.getCourse().equalsIgnoreCase(filterCourse)) {
                    viewedGrades.append(student.toString()).append("\n");
                }
            }
    
            txtResults.setText(viewedGrades.toString());
            if (viewedGrades.length() == 0) {
                txtResults.setText("No students found for the course: " + filterCourse);
            }
        } catch (IOException e) {
            txtResults.setText("Error viewing grades: " + e.getMessage());
        }
    }
    
    
        
    /* This is the main method that runs the application. */
    public static void main(String[] args) {
        launch(args); /* This launches the arguments in the main method. */
    }/* End main method. */
}