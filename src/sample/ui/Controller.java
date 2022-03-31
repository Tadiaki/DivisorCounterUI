package sample.ui;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.logic.DivisorCounter;
import sample.logic.Result;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Controller {

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField txtMinimum;

    @FXML
    private TextField txtMaximum;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    @FXML
    public void initialize() {
        progressBar.setProgress(0.0);
        progressLabel.setText("");
        resultLabel.setText("");

        startButton.setDisable(false);
        stopButton.setDisable(true);

        txtMinimum.setText("1");
        txtMaximum.setText("100000");
    }

    @FXML
    public void start() {
        Integer minimum = Integer.parseInt(txtMinimum.getText());
        Integer maximum = Integer.parseInt(txtMaximum.getText());

        startButton.setDisable(true);
        stopButton.setDisable(false);
        resultLabel.setText("");

        DivisorCounter counter = new DivisorCounter(minimum, maximum);

        progressBar.progressProperty().bind(counter.progressProperty());

        counter.valueProperty().addListener((observable, oldValue, result) -> {
            resultLabel.setText("The number " + result.getNumber() + " has " + result.getDivisorCounter() + " divisors!");
        });

        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(counter);

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }
}

