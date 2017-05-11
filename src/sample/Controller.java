package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;



public class Controller extends Canvas {

    @FXML
    public Slider slider;


    @FXML public javafx.scene.canvas.Canvas canvas;
    GraphicsContext graphicsContext;

    int x = 50;
    int y = 50;
    double step = 1;





    @FXML public void down(ActionEvent actionEvent) {
        graphicsContext = canvas.getGraphicsContext2D();
        move(graphicsContext, "DOWN");
    }

    @FXML public void left(ActionEvent actionEvent) {
        graphicsContext = canvas.getGraphicsContext2D();
        move(graphicsContext, "LEFT");
    }

    @FXML public void right(ActionEvent actionEvent) {
        graphicsContext = canvas.getGraphicsContext2D();
        move(graphicsContext, "RIGHT");
    }

    @FXML public void up(ActionEvent actionEvent) {
        graphicsContext = canvas.getGraphicsContext2D();
        move(graphicsContext, "UP");
    }


    public void move (GraphicsContext gc, String str) {
        step = slider.getValue();
        if (str.equals("UP")) {y -= step;}
        if (str.equals("DOWN")) {y += step;}
        if (str.equals("RIGHT")) {x += step;}
        if (str.equals("LEFT")) {x -= step;}
        gc.clearRect(0, 0, 284, 598);
        // gc.setFill(Color.BLUEVIOLET);
        gc.setStroke(Color.BLACK);
        gc.strokeOval (x, y, 20, 30);
    }

    public void create(ActionEvent actionEvent) {
    }

    public void select(ActionEvent actionEvent) {
    }


}