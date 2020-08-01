package pl.recruitment.rtg;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Point {
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

    private PointPane pointPane;

    private ObservableList<Circle> myCircle;

    public Point(PointPane pointPane, ObservableList<Circle> myCircle) {
        this.pointPane = pointPane;
        this.myCircle = myCircle;
    }

    public Point(PointPane pointPane) {
        this.pointPane = pointPane;
        myCircle = FXCollections.observableArrayList();
    }

    public Point() {
        myCircle = FXCollections.observableArrayList();
    }

}
