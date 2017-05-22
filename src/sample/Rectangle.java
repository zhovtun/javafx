package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by evgen on 22.05.2017.
 */
public class Rectangle extends Shape {
    private double point1x, point2x, point3x, point4x;
    private double point1y, point2y, point3y, point4y;
    private double[] xArray;
    private double[] yArray;

    public Rectangle(double point1x, double point2x, double point3x, double point4x, double point1y, double point2y, double point3y, double point4y) {
        this.point1x = point1x;
        this.point2x = point2x;
        this.point3x = point3x;
        this.point4x = point4x;
        this.point1y = point1y;
        this.point2y = point2y;
        this.point3y = point3y;
        this.point4y = point4y;
        xArray = new double[]{point1x, point2x, point3x, point4x};
        yArray = new double[] {point1y, point2y, point3y, point4y};
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillPolygon(xArray, yArray, 4);
    }

    @Override
    public void moveUp(int step) {

    }

    @Override
    public void moveDown(int step) {

    }

    @Override
    public void moveRight(int step) {

    }

    @Override
    public void moveLeft(int step) {

    }
}
