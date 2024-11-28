package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    @Override
    public void start(Stage stage) {
        TextField input1 = new TextField();
        TextField input2 = new TextField();
        Button addButton = new Button("Add");
        Label resultLabel = new Label();

        addButton.setOnAction(event -> {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            resultLabel.setText(String.valueOf(num1 + num2));
        });

        VBox root = new VBox(input1, input2, addButton, resultLabel);
        Scene scene = new Scene(root, 400, 300);

        stage.setScene(scene);
        stage.show();
    }
}
