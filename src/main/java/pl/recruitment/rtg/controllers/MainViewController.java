package pl.recruitment.rtg.controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pl.recruitment.rtg.models.MyCircle;
import pl.recruitment.rtg.models.Point;
import pl.recruitment.rtg.utils.Draggable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainViewController {

    @FXML
    private VBox pointsVBox;

    @FXML
    private Group imageOne;
    @FXML
    private Group imageTwo;
    @FXML
    private Group imageThree;
    @FXML
    private Group imageFour;

    private final List<Group> images = new ArrayList<>();

    private static Integer pointsNameIterator = 1;

    private Point pointRepresentation = new Point();

    private ObservableList<Point> points = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        images.addAll(Arrays.asList(imageOne, imageTwo, imageThree, imageFour));
    }


    @FXML
    public void addNewPoint(MouseEvent mouseEvent) {
        double initialXClick = mouseEvent.getX();
        double initialYClick = mouseEvent.getY();

        Color color = generateRandomColor();
        PointPane pointPane = createPointPaneRepresentation(initialXClick, initialYClick, color);

        pointRepresentation = new Point();
        for (Group image : images) {
            Circle circle = drawCircle(image, initialXClick, initialYClick, color);
            pointRepresentation.getMyCircle().add(circle);
        }

        pointPane.setPointsView(pointRepresentation.getMyCircle());
        pointRepresentation.setPointPane(pointPane);

        makeCirclesDraggableAndConnected(pointRepresentation);
        points.add(pointRepresentation);

    }

    private Color generateRandomColor() {
        return Color.color(Math.random(), Math.random(), Math.random());
    }


    private PointPane createPointPaneRepresentation(double x, double y, Color color) {
        PointPane pointPane = new PointPane();
        pointsVBox.getChildren().add(pointPane);
        pointPane.setXCoordinate(Double.toString(x));
        pointPane.setYCoordinate(Double.toString(y));
        pointPane.getName().setText("Point " + pointsNameIterator++);
        pointPane.getName().setTextFill(color);

        return pointPane;
    }


    private Circle drawCircle(Group group, double x, double y, Color color) {
        Circle node = new MyCircle(4, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y));
        node.setCenterX(x);
        node.setCenterY(y);
        node.setFill(color);
        node.setStroke(Color.color(0,0,0));

        group.getChildren().add(node);
        return node;
    }

    private void makeCirclesDraggableAndConnected(Point pointRep) {
        for (int i = 0; i < pointRep.getMyCircle().size(); i++) {
            Draggable.Nature draggable = new Draggable.Nature(pointRep.getMyCircle().get(i));

            draggable.addListener((draggableNature, dragEvent) ->
                    setTextFieldsWithCurrentCirclePosition(draggable, pointRep));

            for (int j = 0; j < pointRep.getMyCircle().size(); j++) {
                if (i != j) {
                    draggable.addDraggedNode(pointRep.getMyCircle().get(j));
                }
            }
        }
    }

    private void setTextFieldsWithCurrentCirclePosition(Draggable.Nature draggableNature, Point pointRep) {

        double translateX = draggableNature.getDragNodes().get(0).getTranslateX();
        double translateY = draggableNature.getDragNodes().get(0).getTranslateY();

        pointRep.getPointPane().getxCoordinateTextField().setText(
                String.valueOf(translateX + pointRep.getMyCircle().get(0).getCenterX()));

        pointRep.getPointPane().getyCoordinateTextField().setText(
                String.valueOf(translateY + pointRep.getMyCircle().get(0).getCenterY()));

    }


}
