/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package GradeBookApp;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KunnisseryGradeBookApp extends Application {
    
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

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grade Book Form"); /* Title set. */

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

        pane.add(lblCourseFormat, 1, 3);
        lblCourseFormat.setTextFill(Color.RED);
        GridPane.setHalignment(lblCourseFormat, HPos.RIGHT);

        ObservableList<String>grades = FXCollections.observableArrayList(gradeOptions);
        cbGrade.getItems().addAll(grades);

        HBox actionBtn = new HBox();
        actionBtn.setPadding(new Insets(15, 0, 15, 30));
        actionBtn.setSpacing(10);
        actionBtn.getChildren().add(btnClear);
        actionBtn.getChildren().add(btnSave);
        actionBtn.getChildren().add(btnView);
        pane.add(actionBtn, 0, 6, 2, 1);
        GridPane.setHalignment(actionBtn, HPos.CENTER);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args); /* This launches the arguments in the main method. */
    }
}