package com.example;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorUITest extends ApplicationTest {

    private TextField input1;
    private TextField input2;
    private Button addButton;
    private Label resultLabel;

    @Override
    public void start(Stage stage) {
        CalculatorApp app = new CalculatorApp();
        app.start(stage);
    }

    @Test
    void testAddition() {
        input1 = lookup(".text-field").nth(0).query();
        input2 = lookup(".text-field").nth(1).query();
        addButton = lookup(".button").query();
        resultLabel = lookup(".label").query();

        clickOn(input1).write("3");
        clickOn(input2).write("5");
        clickOn(addButton);

        assertEquals("8.0", resultLabel.getText());
    }
}
