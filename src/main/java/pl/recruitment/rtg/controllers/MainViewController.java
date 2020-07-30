package pl.recruitment.rtg.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import pl.recruitment.rtg.Draggable;
import pl.recruitment.rtg.MyCircle;
import pl.recruitment.rtg.Point;
import pl.recruitment.rtg.PointPane;

import java.util.*;

public class MainViewController {

    @FXML
    public VBox pointsVBox;

    @FXML
    public ScrollPane scrollPoints;

    @FXML
    public Group group1;
    @FXML
    public Group group4;
    @FXML
    public Group group3;
    @FXML
    public Group group2;

    private final List<Group> images = new ArrayList<>();
    private static Integer iterator = 1;
    private ObservableList<Point> points = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        images.addAll(Arrays.asList(group1, group2, group3, group4));

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
        point.name.setText("Point " + iterator++);
        
        Point pointRep = new Point(point);
        for (Group group : images) {
            Circle circle = drawCircle(group, x, y);
            pointRep.getMyCircle().add(circle);
        }

        points.add(pointRep);
        System.out.println(points);
    }

    private Circle drawCircle(Group group, double x, double y) {
        Circle node = new MyCircle(4, x, y);
        node.setCenterX(x);
        node.setCenterY(y);

        new Draggable.Nature(node);
        group.getChildren().add(node);
        return node;

    }


}
