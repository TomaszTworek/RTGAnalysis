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
    public VBox pointsVBox;

    @FXML
    public Group imageOne;
    @FXML
    public Group imageTwo;
    @FXML
    public Group imageThree;
    @FXML
    public Group imageFour;

    private final List<Group> images = new ArrayList<>();

    private static Integer pointsNameIterator = 1;

    private Point pointRep = new Point();

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

        pointRep = new Point();
        for (Group image : images) {
            Circle circle = drawCircle(image, initialXClick, initialYClick, color);
            pointRep.getMyCircle().add(circle);
        }

        pointPane.setCircles(pointRep.getMyCircle());
        pointRep.setPointPane(pointPane);

        makeCirclesDraggableAndConnected(pointRep);
        points.add(pointRep);

    }

    private Color generateRandomColor() {
        return Color.color(Math.random(), Math.random(), Math.random());
    }


    private PointPane createPointPaneRepresentation(double x, double y, Color color) {
        PointPane pointPane = new PointPane();
        pointsVBox.getChildren().add(pointPane);
        pointPane.setXCoordinate(Double.toString(x));
        pointPane.setYCoordinate(Double.toString(y));
        pointPane.name.setText("Point " + pointsNameIterator++);
        pointPane.name.setTextFill(color);

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
            Draggable.Nature nature = new Draggable.Nature(pointRep.getMyCircle().get(i));

            nature.addListener((draggableNature, dragEvent) ->
                    setTextFieldsWithCurrentCirclePosition(nature, pointRep));

            for (int j = 0; j < pointRep.getMyCircle().size(); j++) {
                if (i != j) {
                    nature.addDraggedNode(pointRep.getMyCircle().get(j));
                }
            }
        }
    }

    private void setTextFieldsWithCurrentCirclePosition(Draggable.Nature draggableNature, Point pointRep) {

        double translateX = draggableNature.getDragNodes().get(0).getTranslateX();
        double translateY = draggableNature.getDragNodes().get(0).getTranslateY();

        pointRep.getPointPane().xCoordinateTextField.setText(
                String.valueOf(translateX + pointRep.getMyCircle().get(0).getCenterX()));

        pointRep.getPointPane().yCoordinateTextField.setText(
                String.valueOf(translateY + pointRep.getMyCircle().get(0).getCenterY()));

    }


}
