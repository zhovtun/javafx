package sample;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class tTriangle extends tPoint {
    private double vertex1x;
    private double vertex1y;
    private double vertex2x;
    private double vertex2y;
    private double vertex3x;
    private double vertex3y;
    private Polygon shape;

    public tTriangle(double vertex1x, double vertex1y, double vertex2x, double vertex2y, double vertex3x, double vertex3y,
                     int posX, int posY, double colorR, double colorG, double colorB) {
        super(posX, posY, colorR, colorG, colorB);
        this.vertex1x = vertex1x;
        this.vertex1y = vertex1y;
        this.vertex2x = vertex2x;
        this.vertex2y = vertex2y;
        this.vertex3x = vertex3x;
        this.vertex3y = vertex3y;
    }

    public void setVertex1x (int v1x) {vertex1x = v1x;}
    public void setVertex1y (int v1y) {vertex1y = v1y;}
    public void setVertex2x (int v2x) {vertex2x = v2x;}
    public void setVertex2y (int v2y) {vertex2y = v2y;}
    public void setVertex3x (int v3x) {vertex3x = v3x;}
    public void setVertex3y (int v3y) {vertex3y = v3y;}
    
    public double getVertex1x () {return vertex1x;}
    public double getVertex1y () {return vertex1y;}
    public double getVertex2x () {return vertex2x;}
    public double getVertex2y () {return vertex2y;}
    public double getVertex3x () {return vertex3x;}
    public double getVertex3y () {return vertex3y;}

    @Override
    public void create(Group rt) {
        shape = new Polygon(vertex1x, vertex1y, vertex2x, vertex2y, vertex3x, vertex3y);
        //shape.setTranslateX(posX);
        //shape.setTranslateY(posY);
        shape.setFill(Color.TRANSPARENT);
        shape.setStroke(Color.color(colorR, colorG, colorB));
        rt.getChildren().add(shape);
    }
}
