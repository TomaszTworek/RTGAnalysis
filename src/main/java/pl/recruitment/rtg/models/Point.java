package pl.recruitment.rtg.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;
import pl.recruitment.rtg.controllers.PointPane;

public class Point {

    private PointPane pointPane;

    private ObservableList<Circle> myCircle;

    public PointPane getPointPane() {
        return pointPane;
    }

    public void setPointPane(PointPane pointPane) {
        this.pointPane = pointPane;
    }

    public ObservableList<Circle> getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(ObservableList<Circle> myCircle) {
        this.myCircle = myCircle;
    }

    public Point() {
        myCircle = FXCollections.observableArrayList();
    }

}
