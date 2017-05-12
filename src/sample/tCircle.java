package sample;


import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class tCircle extends tPoint {
    protected int radius;


    public tCircle(int posX, int posY, int radius, double colorR, double colorG, double colorB) {
        super(posX, posY, colorR, colorG, colorB);
        this.radius = radius;
    }

    public void setRadius(int r) {radius = r;}
    public int getRadius () {return radius;}

    @Override
    public void draw (GraphicsContext gc) {
        gc.setStroke(Color.color(colorR, colorG, colorB));
        gc.strokeOval(posX, posY, radius, radius);
    }
}
