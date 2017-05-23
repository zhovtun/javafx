package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Random;


public class Controller {

    Constructor[] shape;
    
    int size;
    double step = 1;
    String type = "circle";

    @FXML
    private Slider slider;

    @FXML
    private Slider quantity;

    @FXML
    private RadioButton ringR;

    @FXML
    private RadioButton ovalR;

    @FXML
    private RadioButton rectangleR;

    @FXML
    private RadioButton triangleR;

    @FXML
    private RadioButton pointR;

    @FXML
    private RadioButton segmentR;

    @FXML public javafx.scene.canvas.Canvas canvas;
    GraphicsContext graphicsContext;


    // Метод, обрабатываюшйи нажатие кнопок двиения в окне
    @FXML public void down(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray(type, "DOWN", (int)step);
        drawArray();
    }

    // Метод, обрабатываюшйи нажатие кнопок в окне
    @FXML public void left(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray(type, "LEFT", (int)step);
        drawArray();
    }

    // Метод, обрабатываюшйи нажатие кнопок в окне
    @FXML public void right(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray(type, "RIGHT", (int)step);
        drawArray();
    }

    // Метод, обрабатываюшйи нажатие кнопок в окне
    @FXML public void up(ActionEvent actionEvent) {
        step = slider.getValue();
        moveArray(type, "UP", (int)step);
        drawArray();
    }

    // Метод, обрабатываюшйи нажатие кнопки "Создать" в окне
    @FXML public void create(ActionEvent actionEvent) {
        buildArray();
        drawArray();
    }

    // Метод, обрабатываюшйи выбор радиокнопок в окне
    @FXML public void select(ActionEvent actionEvent) {
        if (ringR.isSelected()) {type = "circle";}
        if (pointR.isSelected()) {type = "point";}
        if (rectangleR.isSelected()) {type = "rectangle";}
        if (ovalR.isSelected()) {type = "ellipse";}
        if (triangleR.isSelected()) {type = "triangle";}
        if (segmentR.isSelected()) {type = "segment";}

    }

    //Метод для создания массива объектов
    public void buildArray () {
        int i=0;
        size = (int) quantity.getValue();
        Random random = new Random();
        
        shape = new Constructor[size];
        
        while (i<size) {
            shape[i] = new Constructor(random.nextInt(600), random.nextInt(360),
                                        80, 55, Color.BLACK, Color.WHITE);
            i++;
        }
    }

    //Метод для отрисовки на Canvas массива объектов
    public void drawArray () {
        int i = 0;
        graphicsContext = canvas.getGraphicsContext2D();
            graphicsContext.clearRect(0, 0, 600, 360);
            while (i < size) {
                shape[i].draw(graphicsContext);
                i++;
            }
    }

    //Метод для определения движения
    public void moveArray (String type, String direction, int step) {
        int i=0;

        while (i<size) {
            if (type.equals("circle")) {
                switch (direction) {
                    case "UP" : shape[i].moveUp(step); break;
                    case "DOWN" : shape[i].moveDown(step); break;
                    case "LEFT" : shape[i].moveLeft(step); break;
                    case "RIGHT" : shape[i].moveRight(step); break;
                    default: break;
                }
            }
            i++;
        }
    }

    //Метод, реализующий случайное движение
    @FXML public void randMove(ActionEvent actionEvent) {
        String[] d = {"UP", "DOWN", "LEFT", "RIGHT"};
        Random rnd = new Random();
        for (int i = 0; i<100; i++) {
            step = slider.getValue();
            moveArray(type, d[rnd.nextInt(d.length)], (int)step);
            drawArray();
        }
    }
}
