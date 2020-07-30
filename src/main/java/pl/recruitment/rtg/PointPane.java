package pl.recruitment.rtg;

import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;

public class PointPane extends Pane {

    @FXML
    public Label name;

    @FXML
    public TextField xCoordinateTextField;

    @FXML
    public TextField yCoordinateTextField;

    public void setXCoordinate(String xCoordinate){
        xCoordinateTextField.setText(xCoordinate);
    }

    public void setYCoordinate(String yCoordinate){
        yCoordinateTextField.setText(yCoordinate);
    }

    MyCircle circle = new MyCircle();

    @FXML
    public void initialize(){
        xCoordinateTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                xCoordinateTextField.setText(newValue);

                System.out.println("X " + xCoordinateTextField.getText());
            }
        });
        yCoordinateTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                yCoordinateTextField.setText(newValue);

                System.out.println("Y " + yCoordinateTextField.getText());
            }
        });
    }
    @FXML
    public void updateXCircle(KeyEvent e){
        if (e.getCode().toString().equals("ENTER")) {
            circle.setX(Double.parseDouble(xCoordinateTextField.getText()));
        }
        System.out.println(circle.getX());
    }

    @FXML
    public void updateYCircle(KeyEvent e){
        if (e.getCode().toString().equals("ENTER")) {

            circle.setY(Double.parseDouble(yCoordinateTextField.getText()));
        }
        System.out.println(circle.getY());

    }

    public PointPane() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Point.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
