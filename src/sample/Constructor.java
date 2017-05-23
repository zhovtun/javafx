package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class Constructor {
    private double posX, posY, radiusBig, radiusSmall;
    boolean type;
    private Color colorStroke;
    private Color colorFill;
    private Circle bigCircle;
    private Circle smallCircle;
    private Rectangle rectangle;
    private Rectangle rectangleStroke;
    double div = 6;

    // **** Конструктор класса, в котором создается заданная фигура.  Фигура представляет собой 2 окружности и 2 прямоугольника,
    // **** один залитый белым цветом и без контура, второй прозрачнй и с контуром черного цвета.

    public Constructor(double posX, double posY, double radiusBig, double radiusSmall, Color colorStroke, Color colorFill) {
        this.posX = posX;
        this.posY = posY;
        this.radiusBig = radiusBig;
        this.radiusSmall = radiusSmall;
        this.colorStroke = colorStroke;
        this.colorFill = colorFill;
        bigCircle = new Circle(posX, posY, radiusBig);  // **** Внешняя окружность. ****
        smallCircle = new Circle(posX+(radiusBig-radiusSmall)/2, posY+(radiusBig-radiusSmall)/2, radiusSmall); // **** Внутренняя окружность. ****
        rectangle = new Rectangle(  // **** Прямоугльник, залитый белым цветом. Точки полигона определяются по формуле x = x + r*cos(a), y = y + sin(a). ****
                posX + radiusBig/2 + radiusBig/2*cos(Math.toRadians(30+30/div)),
                posX + radiusBig/2 + radiusBig/2*cos(Math.toRadians(60-30/div)),
                posX + radiusBig/2 + radiusBig/2*cos(Math.toRadians(210+30/div)),
                posX + radiusBig/2 + radiusBig/2*cos(Math.toRadians(240-30/div)),
                posY + radiusBig/2 + radiusBig/2*sin(Math.toRadians(30+30/div)),
                posY + radiusBig/2 + radiusBig/2*sin(Math.toRadians(60-30/div)),
                posY + radiusBig/2 + radiusBig/2*sin(Math.toRadians(210+30/div)),
                posY + radiusBig/2 + radiusBig/2*sin(Math.toRadians(240-30/div)),
                true, colorFill
        );
        rectangleStroke = new Rectangle(    // **** Прямоугльник, прозрачный с черным контуром ****
                posX + radiusBig/2 + radiusSmall/2*cos(Math.toRadians(30)),
                posX + radiusBig/2 + radiusSmall/2*cos(Math.toRadians(60)),
                posX + radiusBig/2 + radiusSmall/2*cos(Math.toRadians(210)),
                posX + radiusBig/2 + radiusSmall/2*cos(Math.toRadians(240)),
                posY + radiusBig/2 + radiusSmall/2*sin(Math.toRadians(30)),
                posY + radiusBig/2 + radiusSmall/2*sin(Math.toRadians(60)),
                posY + radiusBig/2 + radiusSmall/2*sin(Math.toRadians(210)),
                posY + radiusBig/2 + radiusSmall/2*sin(Math.toRadians(240)),
                false, colorStroke
        );
    }


    // **** Метод для рисования созданной фигуры

    public void draw (GraphicsContext gc) {
        bigCircle.draw(gc);
        smallCircle.draw(gc);
        rectangleStroke.draw(gc);
        rectangle.draw(gc);
    }
    
    public void moveUp(int step) {
        bigCircle.moveUp(step);
        smallCircle.moveUp(step);
        rectangleStroke.moveUp(step);
        rectangle.moveUp(step);
    }
    
    public void moveDown(int step) {
        bigCircle.moveDown(step);
        smallCircle.moveDown(step);
        rectangleStroke.moveDown(step);
        rectangle.moveDown(step);
    }
    
    public void moveRight(int step) {
        bigCircle.moveRight(step);
        smallCircle.moveRight(step);
        rectangleStroke.moveRight(step);
        rectangle.moveRight(step);
    }
    
    public void moveLeft(int step) {
        bigCircle.moveLeft(step);
        smallCircle.moveLeft(step);
        rectangleStroke.moveLeft(step);
        rectangle.moveLeft(step);
    }
}