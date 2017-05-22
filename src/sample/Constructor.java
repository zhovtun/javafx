package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Constructor {
    private double posX, posY, radiusBig, radiusSmall;
    boolean type;
    private Color colorStroke;
    private Color colorFill;
    private Circle bigCircle;
    private Circle smallCircle;
    private Rectangle rectangle;
    private Rectangle rectangleStroke;

    public Constructor(double posX, double posY, double radiusBig, double radiusSmall, Color colorStroke, Color colorFill) {
        this.posX = posX;
        this.posY = posY;
        this.radiusBig = radiusBig;
        this.radiusSmall = radiusSmall;
        this.colorStroke = colorStroke;
        this.colorFill = colorFill;
        bigCircle = new Circle(posX, posY, radiusBig);
        smallCircle = new Circle(posX, posY, radiusSmall);
        rectangle = new Rectangle(
                posX + radiusBig - radiusSmall,
                posX + (radiusBig - radiusSmall)* 2,
                posX + radiusBig,
                posX + radiusBig + (radiusBig - radiusSmall),
                posY + radiusBig - radiusSmall,
                posY + (radiusBig - radiusSmall)* 2,
                posY + radiusBig,
                posY + radiusBig + (radiusBig - radiusSmall),
                true, colorFill
        );
        rectangleStroke = new Rectangle(
                posX + radiusBig - radiusSmall -1,
                posX + (radiusBig - radiusSmall)* 2 -1,
                posX + radiusBig,
                posX + radiusBig + (radiusBig - radiusSmall) -1,
                posY + radiusBig - radiusSmall -1,
                posY + (radiusBig - radiusSmall)* 2 -1,
                posY + radiusBig -1,
                posY + radiusBig + (radiusBig - radiusSmall) -1,
                false, colorStroke
        );
    }



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