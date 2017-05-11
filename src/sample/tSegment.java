package sample;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class tSegment extends tPoint {
    protected int length;
    private Rectangle shape;

    public tSegment(int posX, int posY, int length, double colorR, double colorG, double colorB) {
        super(posX, posY, colorR, colorG, colorB);
        this.length = length;
    }

    public void setLength (int l) {length = l;}
    public int getLength () {return length;}

    @Override
    public void create(Group rt) {
        shape = new Rectangle(length, 1);
        shape.setFill(Color.color(colorR, colorG, colorB));
        shape.setStroke(Color.color(colorR, colorG, colorB));
        shape.setTranslateX(posX);
        shape.setTranslateY(posY);
        rt.getChildren().add(shape);
    }
}
