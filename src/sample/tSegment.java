package sample;


import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class tSegment extends tPoint {
    protected int length;


    public tSegment(int posX, int posY, int length, double colorR, double colorG, double colorB) {
        super(posX, posY, colorR, colorG, colorB);
        this.length = length;
    }

    public void setLength (int l) {length = l;}
    public int getLength () {return length;}

    @Override
    public void draw (GraphicsContext gc) {
        gc.setStroke(Color.color(colorR, colorG, colorB));
        gc.strokeRect(posX, posY, length, 1);
    }
}
