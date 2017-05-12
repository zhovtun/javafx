package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.Random;


public class Controller extends Canvas {

    tPoint[] point;
    tCircle[] circle;
    tRectangle[] rectangle;
    tSegment[] segment;
    tEllipse[] ellipse;
    tTriangle[] triangle;

    int size = 30;
    int x = 50;
    int y = 50;
    double step = 1;
    String type = "circle";

    public ToggleGroup toggleGroup;

    @FXML
    public Slider slider;

    @FXML
    public RadioButton ringR;

    @FXML
    public RadioButton ovalR;

    @FXML
    public RadioButton rectangleR;

    @FXML
    public RadioButton triangleR;

    @FXML
    public RadioButton pointR;

    @FXML
    public RadioButton segmentR;

    @FXML public javafx.scene.canvas.Canvas canvas;
    GraphicsContext graphicsContext;


    @FXML public void down(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray(type, "DOWN", (int)step);
        drawArray();
    }

    @FXML public void left(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray(type, "LEFT", (int)step);
        drawArray();
    }

    @FXML public void right(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray(type, "RIGHT", (int)step);
        drawArray();
    }

    @FXML public void up(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray(type, "UP", (int)step);
        drawArray();
    }

    @FXML public void kup(KeyEvent keyEvent) {
        step = slider.getValue();
        moveArray(type, "UP", (int)step);
        drawArray();
    }


    public void move (GraphicsContext gc, String str) {
        step = slider.getValue();
        if (str.equals("UP")) {y -= step;}
        if (str.equals("DOWN")) {y += step;}
        if (str.equals("RIGHT")) {x += step;}
        if (str.equals("LEFT")) {x -= step;}
        gc.clearRect(0, 0, 600, 300);
        // gc.setFill(Color.BLUEVIOLET);
        gc.setStroke(Color.BLACK);
        gc.strokeOval (x, y, 20, 30);
    }

    public void create(ActionEvent actionEvent) {
        buildArray();
        drawArray();
    }

    public void select(ActionEvent actionEvent) {
        if (ringR.isSelected()) {type = "circle";}
        if (pointR.isSelected()) {type = "point";}
        if (rectangleR.isSelected()) {type = "rectangle";}
        if (ovalR.isSelected()) {type = "ellipse";}
        if (triangleR.isSelected()) {type = "triangle";}
        if (segmentR.isSelected()) {type = "segment";}

    }

    public void buildArray () {
        int i=0;
        Random random = new Random();
        point = new tPoint[size];
        circle = new tCircle[size];
        rectangle = new tRectangle[size];
        segment = new tSegment[size];
        ellipse = new tEllipse[size];
        triangle = new tTriangle[size];

        while (i<size) {
            point[i] = new tPoint(random.nextInt(600), random.nextInt(300),
                    random.nextDouble(), random.nextDouble(), random.nextDouble());
            circle[i] = new tCircle(random.nextInt(600), random.nextInt(300), random.nextInt(30),
                    random.nextDouble(), random.nextDouble(), random.nextDouble());
            rectangle[i] = new tRectangle(random.nextInt(600), random.nextInt(300), random.nextInt(30),
                    random.nextInt(80), random.nextDouble(), random.nextDouble(), random.nextDouble());
            segment[i] = new tSegment(random.nextInt(600), random.nextInt(300), random.nextInt(50),
                    random.nextDouble(), random.nextDouble(), random.nextDouble());
            ellipse[i] = new tEllipse(random.nextInt(600), random.nextInt(300), random.nextInt(30),
                    random.nextInt(60), random.nextDouble(), random.nextDouble(), random.nextDouble());
            triangle[i] = new tTriangle(random.nextInt(600), random.nextInt(300), random.nextInt(600), random.nextInt(300),
                    random.nextInt(600), random.nextInt(300), random.nextInt(600), random.nextInt(300),
                    random.nextDouble(), random.nextDouble(), random.nextDouble());

            i++;
        }
    }

    public void drawArray () {
        int i = 0;
        graphicsContext = canvas.getGraphicsContext2D();
            graphicsContext.clearRect(0, 0, 600, 300);
            while (i < size) {
                point[i].draw(graphicsContext);
                circle[i].draw(graphicsContext);
                rectangle[i].draw(graphicsContext);
                segment[i].draw(graphicsContext);
                ellipse[i].draw(graphicsContext);
                triangle[i].draw(graphicsContext);
                i++;
            }
    }

    public void moveArray (String type, String direction, int step) {
        int i=0;

        while (i<size) {
            if (type.equals("point")) {
                switch (direction) {
                    case "UP" : point[i].moveUp(step); break;
                    case "DOWN" : point[i].moveDown(step); break;
                    case "LEFT" : point[i].moveLeft(step); break;
                    case "RIGHT" : point[i].moveRight(step); break;
                    default: break;
                }
            }
            if (type.equals("circle")) {
                switch (direction) {
                    case "UP" : circle[i].moveUp(step); break;
                    case "DOWN" : circle[i].moveDown(step); break;
                    case "LEFT" : circle[i].moveLeft(step); break;
                    case "RIGHT" : circle[i].moveRight(step); break;
                    default: break;
                }
            }
            if (type.equals("rectangle")) {
                switch (direction) {
                    case "UP" : rectangle[i].moveUp(step); break;
                    case "DOWN" : rectangle[i].moveDown(step); break;
                    case "LEFT" : rectangle[i].moveLeft(step); break;
                    case "RIGHT" : rectangle[i].moveRight(step); break;
                    default: break;
                }
            }
            if (type.equals("triangle")) {
                switch (direction) {
                    case "UP" : triangle[i].moveUp(step); break;
                    case "DOWN" : triangle[i].moveDown(step); break;
                    case "LEFT" : triangle[i].moveLeft(step); break;
                    case "RIGHT" : triangle[i].moveRight(step); break;
                    default: break;
                }
            }
            if (type.equals("ellipse")) {
                switch (direction) {
                    case "UP" : ellipse[i].moveUp(step); break;
                    case "DOWN" : ellipse[i].moveDown(step); break;
                    case "LEFT" : ellipse[i].moveLeft(step); break;
                    case "RIGHT" : ellipse[i].moveRight(step); break;
                    default: break;
                }
            }
            if (type.equals("segment")) {
                switch (direction) {
                    case "UP" : segment[i].moveUp(step); break;
                    case "DOWN" : segment[i].moveDown(step); break;
                    case "LEFT" : segment[i].moveLeft(step); break;
                    case "RIGHT" : segment[i].moveRight(step); break;
                    default: break;
                }
            }
            i++;
        }
    }



}
