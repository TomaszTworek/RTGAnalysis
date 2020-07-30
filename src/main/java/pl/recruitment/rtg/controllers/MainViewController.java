package pl.recruitment.rtg.controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
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
         /*   Draggable.Nature nature = new Draggable.Nature(circle);*/

            pointRep.getMyCircle().add(circle);
        }
        for (int i = 0; i < pointRep.getMyCircle().size(); i++) {
            Draggable.Nature nature = new Draggable.Nature(pointRep.getMyCircle().get(i));
            for (int j = 0; j < pointRep.getMyCircle().size(); j++) {
                if (i != j) {
                    nature.addDraggedNode(pointRep.getMyCircle().get(j));
                } else {
                    continue;
                }
            }
        }


        points.add(pointRep);
        System.out.println(points);
    }

    private Circle drawCircle(Group group, double x, double y) {
        Circle node = new MyCircle(4, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y));
        node.setCenterX(x);
        node.setCenterY(y);


        group.getChildren().add(node);
        return node;

    }


}
