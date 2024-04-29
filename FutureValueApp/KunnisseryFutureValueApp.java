package FutureValueApp;
import javafx.application.Application;
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

public class KunnisseryFutureValueApp extends Application {

    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    private TextArea area1 = new TextArea();
    private Label lblMonthlyPayment = new Label("Monthly Payment: ");
    private Label lblInterestRate = new Label("Interest Rate: ");
    private Label lblYears = new Label("Years: ");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    @SuppressWarnings("unused")
    private Label year = new Label();
    private ComboBox<Integer> years = new ComboBox<>();
    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button("Clear");

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
        pane.add(area1, 0, 5, 2, 1);
        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(lblInterestRate, 0, 1);
        pane.add(lblYears, 0, 3);
        pane.add(years, 1, 3, 2, 1);

        lblInterestRateFormat.setTextFill(Color.RED);
        pane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        GridPane.setHalignment(years, HPos.RIGHT);

        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);

        pane.add(actionBtnContainer, 1, 4);
        pane.setPrefSize(400, 300);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}