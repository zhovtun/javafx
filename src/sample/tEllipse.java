package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class tEllipse extends tCircle {
    private int radius2;
    private Ellipse shape;
    public tEllipse(int posX, int posY, int radius, int radius2, double colorR, double colorG, double colorB) {
        super(posX, posY, radius, colorR, colorG, colorB);
        this.radius2 = radius2;
    }

    public void setRadius2 (int r2) {radius2 = r2;}
    public int getRadius2 () {return radius2;}

    @Override
    public void create(Group rt) {
        shape = new Ellipse(radius, radius2); 
        shape.setFill(Color.TRANSPARENT);
        shape.setStroke(Color.color(colorR, colorG, colorB));
        shape.setTranslateX(posX);
        shape.setTranslateY(posY);
        rt.getChildren().add(shape);
    }

}
