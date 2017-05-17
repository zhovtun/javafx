package sample;

import javafx.scene.canvas.GraphicsContext;


public abstract class Shape {

    public abstract void draw (GraphicsContext graphicsContext);
    public abstract void moveUp (int step);
    public abstract void moveDown (int step);
    public abstract void moveRight (int step);
    public abstract void moveLeft (int step);

}
