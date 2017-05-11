package sample;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class tCircle extends tPoint {
    protected int radius;
    private Circle shape;

    public tCircle(int posX, int posY, int radius, double colorR, double colorG, double colorB) {
        super(posX, posY, colorR, colorG, colorB);
        this.radius = radius;
    }

    public void setRadius(int r) {radius = r;}
    public int getRadius () {return radius;}

    @Override
    public void create(Group rt) {
        shape = new Circle(radius, Color.TRANSPARENT); // создается точка, с определенным цветом
        shape.setStroke(Color.color(colorR, colorG, colorB));
        shape.setTranslateX(posX);             // Задается смещение точки относительно левого верхнего угла
        shape.setTranslateY(posY);
        rt.getChildren().add(shape);
    }
}
