package pl.recruitment.rtg.controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
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

    public Point getPointRep() {
        return pointRep;
    }

    public void setPointRep(Point pointRep) {
        this.pointRep = pointRep;
    }

    private static Integer iterator = 1;

    private Point pointRep = new Point();
    private ObservableList<Point> points = FXCollections.observableArrayList();

    public ObservableList<Point> getPoints() {
        return points;
    }

    public void setPoints(ObservableList<Point> points) {
        this.points = points;
    }

    @FXML
    public void initialize() {
        images.addAll(Arrays.asList(group1, group2, group3, group4));


    }


    @FXML
    public void addNewPoint(MouseEvent mouseEvent) {
        createPointPaneViewAndAddToVBox(mouseEvent, mouseEvent.getX(), mouseEvent.getY());

    }

    private void createPointPaneViewAndAddToVBox(MouseEvent mouseEvent, double x, double y) {

        PointPane point = new PointPane();
        pointsVBox.getChildren().add(point);
        point.setXCoordinate(Double.toString(x));
        point.setYCoordinate(Double.toString(y));
        point.name.setText("Point " + iterator++);

        pointRep = new Point();

        for (Group group : images) {
            Circle circle = drawCircle(group, x, y);

            pointRep.getMyCircle().add(circle);
            System.out.println("CIRCLES pointREP: " +
                    pointRep.getMyCircle());
        }
        point.setCircles(pointRep.getMyCircle());
        pointRep.setPointPane(point);

        makeCirclesDraggableConnected(mouseEvent, pointRep, point);
        points.add(pointRep);
    }

    private Circle drawCircle(Group group, double x, double y) {
        Circle node = new MyCircle(4, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y));

        node.setCenterX(x);
        node.setCenterY(y);

        group.getChildren().add(node);
        return node;

    }

    private void makeCirclesDraggableConnected(MouseEvent mouseEvent, Point pointRep, PointPane pane) {
        for (int i = 0; i < pointRep.getMyCircle().size(); i++) {
            Draggable.Nature nature = new Draggable.Nature(pointRep.getMyCircle().get(i));
            double x = Double.parseDouble(pane.xCoordinateTextField.getText());
            double y = Double.parseDouble(pane.yCoordinateTextField.getText());
            nature.addListener(new Draggable.Listener() {
                @Override
                public void accept(Draggable.Nature draggableNature, Draggable.Event dragEvent) {
                    setTextFields(draggableNature, pane, x, y);
                }
            });
            for (int j = 0; j < pointRep.getMyCircle().size(); j++) {
                if (i != j) {
                    nature.addDraggedNode(pointRep.getMyCircle().get(j));
                }
            }
        }
    }

    //pobiera text i ustawia (przesunięcie + text) w polu tesktowym
    private void setTextFields(Draggable.Nature draggableNature, PointPane pane, double x, double y) {

        double translateX = draggableNature.getDragNodes().get(0).getTranslateX();
        double translateY = draggableNature.getDragNodes().get(0).getTranslateY();

        pane.xCoordinateTextField.setText(
                String.valueOf(translateX + x));

        pane.yCoordinateTextField.setText(
                String.valueOf(translateY + y));
    }


}
