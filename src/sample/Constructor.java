package sample;

import javafx.scene.canvas.GraphicsContext;

public class Constructor {
    private double posX, posY, radiusBig, radiusSmall;

    public Constructor(double posX, double posY, double radiusBig, double radiusSmall) {
        this.posX = posX;
        this.posY = posY;
        this.radiusBig = radiusBig;
        this.radiusSmall = radiusSmall;
    }

    Circle bigCircle = new Circle(posX, posY, radiusBig);
    Circle smallCircle = new Circle(posX, posY, radiusSmall);
    Rectangle rectangle = new Rectangle(
            posX + radiusBig - radiusSmall,
            posX + (radiusBig - radiusSmall)* 2,
            posX + radiusBig,
            posX + radiusBig + (radiusBig - radiusSmall),
            posY + radiusBig - radiusSmall,
            posY + (radiusBig - radiusSmall)* 2,
            posY + radiusBig,
            posY + radiusBig + (radiusBig - radiusSmall)
    );

    public void draw (GraphicsContext gc) {
        bigCircle.draw(gc);
        smallCircle.draw(gc);
        rectangle.draw(gc);
    }
}