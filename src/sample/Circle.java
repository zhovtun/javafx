package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by evgen on 22.05.2017.
 */
public class Circle extends Shape {
    private double posX;
    private double posY;
    private double radius;

    public Circle(double posX, double posY, double radius) {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.strokeOval(posX, posY, radius, radius);
    }

    @Override
    public void moveUp(int step) {
        posY -= step;
    }

    @Override
    public void moveDown(int step) {
        posY += step;
    }

    @Override
    public void moveRight(int step) {
    posX += step;
    }

    @Override
    public void moveLeft(int step) {
    posX -= step;
    }
}
