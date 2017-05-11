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
    /*tCircle[] circle;
    tRectangle[] rectangle;
    tSegment[] segment;
    tEllipse[] ellipse;
    tTriangle[] triangle;*/
    int size = 30;
    int x = 50;
    int y = 50;
    double step = 1;
    String type;

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

    @FXML public javafx.scene.canvas.Canvas canvas;
    GraphicsContext graphicsContext;


    @FXML public void down(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray("point", "DOWN", (int)step);
        drawArray();
    }

    @FXML public void left(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray("point", "LEFT", (int)step);
        drawArray();
    }

    @FXML public void right(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray("point", "RIGHT", (int)step);
        drawArray();
    }

    @FXML public void up(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray("point", "UP", (int)step);
        drawArray();
    }

    @FXML public void kup(KeyEvent keyEvent) {
        step = slider.getValue();
        moveArray("point", "UP", (int)step);
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
        ringR.setToggleGroup(toggleGroup);
        ovalR.setToggleGroup(toggleGroup);
        rectangleR.setToggleGroup(toggleGroup);
        triangleR.setToggleGroup(toggleGroup);
        pointR.setToggleGroup(toggleGroup);
        toggleGroup. //TODO Допилить выбор радиокнопки по ссылке http://www.java2s.com/Tutorials/Java/JavaFX/0420__JavaFX_RadioButton.htm

    }

    public void buildArray () {
        int i=0;
        Random random = new Random();
        point = new tPoint[size];
        /*circle = new tCircle[size];
        rectangle = new tRectangle[size];
        segment = new tSegment[size];
        ellipse = new tEllipse[size];
        triangle = new tTriangle[size];*/

        while (i<size) {
            point[i] = new tPoint(random.nextInt(600), random.nextInt(600),
                    random.nextDouble(), random.nextDouble(), random.nextDouble());
            /*circle[i] = new tCircle(random.nextInt(600), random.nextInt(600), random.nextInt(80),
                    random.nextDouble(), random.nextDouble(), random.nextDouble());
            rectangle[i] = new tRectangle(random.nextInt(600), random.nextInt(600), random.nextInt(80),
                    random.nextInt(80), random.nextDouble(), random.nextDouble(), random.nextDouble());
            segment[i] = new tSegment(random.nextInt(600), random.nextInt(600), random.nextInt(100),
                    random.nextDouble(), random.nextDouble(), random.nextDouble());
            ellipse[i] = new tEllipse(random.nextInt(600), random.nextInt(600), random.nextInt(80),
                    random.nextInt(80), random.nextDouble(), random.nextDouble(), random.nextDouble());
            triangle[i] = new tTriangle(random.nextInt(600), random.nextInt(600), random.nextInt(600), random.nextInt(600),
                    random.nextInt(600), random.nextInt(600), random.nextInt(600), random.nextInt(600),
                    random.nextDouble(), random.nextDouble(), random.nextDouble());*/

            i++;
        }
    }

    public void drawArray () {
        int i = 0;
        graphicsContext = canvas.getGraphicsContext2D();
            graphicsContext.clearRect(0, 0, 600, 300);
            while (i < size) {
                point[i].draw(graphicsContext);
            /*circle[i].create(root);
            rectangle[i].create(root);
            segment[i].create(root);
            ellipse[i].create(root);
            triangle[i].create(root);*/
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
            i++;
        }
    }



}
