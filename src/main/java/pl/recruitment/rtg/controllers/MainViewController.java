package pl.recruitment.rtg.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import pl.recruitment.rtg.MyPane;

public class MainViewController {

    @FXML
    public VBox pointsVBox;

    @FXML
    public ScrollPane scrollPoints;

    @FXML
    public void addNewPoint(MouseEvent mouseEvent) {
        createPointPaneViewAndAddToVBox();
    }

/*    @FXML
    public void initialize() {
        for (Node p : pointsVBox.getChildren()) {
            VBox.setVgrow(p, Priority.ALWAYS);
        }
    }*/

    private void createPointPaneViewAndAddToVBox() {
        MyPane pointPane = new MyPane();
        pointsVBox.getChildren().add(pointPane);
    }
}
