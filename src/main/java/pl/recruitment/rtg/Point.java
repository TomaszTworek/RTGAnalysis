package pl.recruitment.rtg;

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

    public List<Circle> getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(List<Circle> myCircle) {
        this.myCircle = myCircle;
    }

    private PointPane pointPane;

    private List<Circle> myCircle;

    public Point(PointPane pointPane, List<Circle> myCircle) {
        this.pointPane = pointPane;
        this.myCircle = myCircle;
    }

    public Point(PointPane pointPane) {
        this.pointPane = pointPane;
        myCircle = new ArrayList<>();
    }
}
