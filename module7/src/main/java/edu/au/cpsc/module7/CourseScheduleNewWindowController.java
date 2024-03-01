package edu.au.cpsc.module7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class CourseScheduleNewWindowController {

    @FXML
    private Label messageLabel;

    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    @FXML
    protected void closeButtonAction(ActionEvent event) {
        // Close the new window
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }
}
