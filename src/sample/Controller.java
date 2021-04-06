package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;

public class Controller {

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private Label resultLabel;

    @FXML
    private Spinner<Integer> minimumSpinner;

    @FXML
    private Spinner<Integer> maximumSpinner;

    @FXML
    private ProgressBar progressBar;

    @FXML
    public void initialize() {
        progressBar.setProgress(0.5);
        resultLabel.setText("");

        startButton.setDisable(false);
        stopButton.setDisable(true);

        minimumSpinner.setValueFactory(new DivisorSpinnerValueFactory(1));
        maximumSpinner.setValueFactory(new DivisorSpinnerValueFactory(100000));
    }

    @FXML
    public void start() {
        Integer minimum = minimumSpinner.getValue();
        Integer maximum = maximumSpinner.getValue();

        startButton.setDisable(true);
        stopButton.setDisable(false);
        resultLabel.setText("");

        DivisorCounter counter = new DivisorCounter();
        Result result = counter.calculate(minimum, maximum);
        resultLabel.setText("The number " + result.getNumber() + " has " + result.getDivisorCounter() + " divisors!");

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }
}

