package pl.recruitment.rtg.controllers;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import pl.recruitment.rtg.PointPane;

public class MainViewController {

    @FXML
    public VBox pointsVBox;

    @FXML
    public ScrollPane scrollPoints;

 



    @FXML
    public void initialize(){
    }
    @FXML
    public void addNewPoint(MouseEvent mouseEvent) {
        createPointPaneViewAndAddToVBox(mouseEvent.getX(), mouseEvent.getY());
    }

    private void createPointPaneViewAndAddToVBox(double x, double y) {
        PointPane point = new PointPane();
        pointsVBox.getChildren().add(point);
        point.setXCoordinate(Double.toString(x));
        point.setYCoordinate(Double.toString(y));



    }


}
