package pl.recruitment.rtg.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import pl.recruitment.rtg.utils.TextFieldValidator;

import java.io.IOException;

public class PointPane extends Pane {

    @FXML
    private Label name;

    @FXML
    private TextField xCoordinateTextField;

    @FXML
    private TextField yCoordinateTextField;

    @FXML
    private Label warningMessage;


    private ObservableList<Circle> pointsView = FXCollections.observableArrayList();
    private final TextFieldValidator textFieldValidator = new TextFieldValidator();

    public void setPointsView(ObservableList<Circle> myCircle) {
        this.pointsView = myCircle;
    }

    public void setXCoordinate(String xCoordinate) {
        xCoordinateTextField.setText(xCoordinate);
    }

    public void setYCoordinate(String yCoordinate) {
        yCoordinateTextField.setText(yCoordinate);
    }

    public PointPane() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Point.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void updateXCircle(KeyEvent e) {
        if (e.getCode().toString().equals("ENTER") || e.getCode().toString().equals("TAB")) {
            if (textFieldValidator.checkTextFieldInputIsValid(xCoordinateTextField.getText())) {
                for (Circle c : pointsView) {
                    c.setCenterX(0.0);
                    c.setTranslateX(Double.parseDouble(xCoordinateTextField.getText()));
                }
                this.warningMessage.setText("");
            } else {
                this.warningMessage.setText(textFieldValidator.getMessage());
            }
        }
    }

    @FXML
    public void updateYCircle(KeyEvent e) {
        if (e.getCode().toString().equals("ENTER") || e.getCode().toString().equals("TAB")) {
            if (textFieldValidator.checkTextFieldInputIsValid(yCoordinateTextField.getText())) {
                for (Circle c : pointsView) {
                    c.setCenterY(0.0);
                    c.setTranslateY(Double.parseDouble(yCoordinateTextField.getText()));
                }
                this.warningMessage.setText("");
            } else {
                this.warningMessage.setText(textFieldValidator.getMessage());
            }
        }
    }


    public Label getName() {
        return name;
    }

    public TextField getxCoordinateTextField() {
        return xCoordinateTextField;
    }

    public TextField getyCoordinateTextField() {
        return yCoordinateTextField;
    }

    public Label getWarningMessage() {
        return warningMessage;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public void setxCoordinateTextField(TextField xCoordinateTextField) {
        this.xCoordinateTextField = xCoordinateTextField;
    }

    public void setyCoordinateTextField(TextField yCoordinateTextField) {
        this.yCoordinateTextField = yCoordinateTextField;
    }

    public void setWarningMessage(Label warningMessage) {
        this.warningMessage = warningMessage;
    }
}
