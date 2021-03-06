package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    // **** Для создания линий, используется полигон. Конструктор метода Polygon принимает на вход 2 массива xArray и yArray,
    // **** которые содержат xy координаты точек полигона.
    private double point1x, point2x, point3x, point4x;
    private double point1y, point2y, point3y, point4y;
    private double[] xArray;
    private double[] yArray;
    private boolean type;
    private Color color;

    public Rectangle(double point1x, double point2x, double point3x, double point4x, double point1y, double point2y, double point3y, double point4y, boolean type, Color color) {
        this.point1x = point1x;
        this.point2x = point2x;
        this.point3x = point3x;
        this.point4x = point4x;
        this.point1y = point1y;
        this.point2y = point2y;
        this.point3y = point3y;
        this.point4y = point4y;
        this.type = type;
        this.color = color;
        xArray = new double[] {point1x, point2x, point3x, point4x};
        yArray = new double[] {point1y, point2y, point3y, point4y};
    }
    // **** Метод рисования объекта
    @Override
    public void draw(GraphicsContext gc) {
        xArray[0] = point1x;
        xArray[1] = point2x;
        xArray[2] = point3x;
        xArray[3] = point4x;
        yArray[0] = point1y;
        yArray[1] = point2y;
        yArray[2] = point3y;
        yArray[3] = point4y;
        
        if (type) {
            gc.setFill(color);
            gc.fillPolygon(xArray, yArray, 4);
        }
        else {
            gc.setStroke(color);
            gc.strokePolygon(xArray, yArray, 4);
        }
    }
    // **** Методы движения объекта
    @Override
    public void moveUp(int step) {
        point1y -= step;
        point2y -= step;
        point3y -= step;
        point4y -= step;
    }

    @Override
    public void moveDown(int step) {
        point1y += step;
        point2y += step;
        point3y += step;
        point4y += step;
    }

    @Override
    public void moveRight(int step) {
        point1x += step;
        point2x += step;
        point3x += step;
        point4x += step;
    }

    @Override
    public void moveLeft(int step) {
        point1x -= step;
        point2x -= step;
        point3x -= step;
        point4x -= step;
    }
}
