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

import java.io.IOException;

public class PointPane extends Pane {

    @FXML
    public Label name;

    @FXML
    public TextField xCoordinateTextField;

    @FXML
    public TextField yCoordinateTextField;

    private ObservableList<Circle> circles = FXCollections.observableArrayList();

    public void setCircles(ObservableList<Circle> myCircle) {
        this.circles = myCircle;
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
    public void initialize() {

       /* xCoordinateTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                for (Circle c : circles) {
                    c.setCenterX(Double.parseDouble(newValue));
                }
            }
        });
        yCoordinateTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                for (Circle c : circles) {
                    c.setCenterY(Double.parseDouble(newValue));
                }
            }
        });*/
}

    @FXML
    public void updateXCircle(KeyEvent e) {
        if (e.getCode().toString().equals("ENTER") || e.getCode().toString().equals("TAB")) {
            for (Circle c : circles) {
                c.setCenterX(0.0);
                c.setTranslateX(Double.parseDouble(xCoordinateTextField.getText()));
            }
        }
    }


    @FXML
    public void updateYCircle(KeyEvent e) {
        if (e.getCode().toString().equals("ENTER") || e.getCode().toString().equals("TAB")) {
            for (Circle c : circles) {
                c.setCenterY(0.0);
                c.setTranslateY(Double.parseDouble(yCoordinateTextField.getText()));
            }
        }
    }
}
