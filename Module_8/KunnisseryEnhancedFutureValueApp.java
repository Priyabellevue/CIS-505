/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class KunnisseryEnhancedFutureValueApp extends Application {

    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    private TextArea txtResults = new TextArea();
    private Label lblMonthlyPayment = new Label("Monthly Payment: ");
    private Label lblInterestRate = new Label("Interest Rate: ");
    private Label lblYears = new Label("Years: ");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblFutureValueDate = new Label();
    private Integer[] interestYears = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    private ComboBox<Integer> cbYears = new ComboBox<Integer>();
    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button("Clear");
    private DecimalFormat df = new DecimalFormat("$0.00");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kunnissery Future Value App");

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(txtMonthlyPayment, 1, 0);
        pane.add(txtInterestRate, 1, 1);
        pane.add(txtResults, 0, 5, 2, 1);
        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(lblInterestRate, 0, 1);
        pane.add(lblYears, 0, 3);
        pane.add(cbYears, 1, 3);
        pane.add(lblFutureValueDate,0 ,5);

        ObservableList<Integer> years = FXCollections.observableArrayList(interestYears);
        cbYears.getItems().addAll(years);

        lblInterestRateFormat.setTextFill(Color.RED);
        pane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        GridPane.setHalignment(cbYears, HPos.RIGHT);

        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);

        pane.add(actionBtnContainer, 1, 4);
        pane.setPrefSize(400, 300);

         /* This sets the buttons to take actions based on the methods called. */
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /* This method clears the form and sets the values. */
    private void clearFormFields(){
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        lblFutureValueDate.setText("");
        cbYears.setValue(0);
    }

    /* This method gets the date. */
    private String getDate(){
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        String outputDate = String.format(simpleDate.format(today));
        return outputDate;
    }

    /* This method calculates the results based on the Finance Calculator. */
    private void calculateResults(){
        Double monthlyPayment = Double.valueOf(txtMonthlyPayment.getText());
        Double interestRate = Double.valueOf(txtInterestRate.getText());
        int yearsValue = cbYears.getValue();
        txtResults.setText("The future value is " + df.format(FinanceCalculator.calculateFutureValue(monthlyPayment, interestRate, yearsValue)));
        lblFutureValueDate.setText(" Calculation as of "+getDate());
    }

    public static void main(String[] args) {
        launch(args);
    }
}