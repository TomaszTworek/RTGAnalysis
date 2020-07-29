package pl.recruitment.rtg.controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import pl.recruitment.rtg.MyPane;

public class MainViewController {

    @FXML
    public VBox pointsVBox;

    @FXML
    public void addNewPoint(MouseEvent mouseEvent) {
        createPointPaneViewAndAddToVBox();
    }

    private void createPointPaneViewAndAddToVBox() {
        MyPane pointPane = new MyPane();
        pointsVBox.getChildren().add(pointPane);
    }
}
