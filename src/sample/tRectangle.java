package sample;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class tRectangle extends tSegment {
    protected int height;
    private Rectangle shape;

    public tRectangle(int posX, int posY, int length, int height, double colorR, double colorG, double colorB) {
        super(posX, posY, length, colorR, colorG, colorB);
        this.height = height;
    }

    public void setHeight (int h) {height = h;}
    public int getHeight () {return height;}

    @Override
    public void create(Group rt) {
        shape = new Rectangle(length, height);
        shape.setFill(Color.TRANSPARENT);
        shape.setStroke(Color.color(colorR, colorG, colorB));
        shape.setTranslateX(posX);
        shape.setTranslateY(posY);
        rt.getChildren().add(shape);
    }
}
