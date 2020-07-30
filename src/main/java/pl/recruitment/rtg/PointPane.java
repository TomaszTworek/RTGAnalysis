package pl.recruitment.rtg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
