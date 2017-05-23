package sample;

import javafx.scene.canvas.GraphicsContext;


public abstract class Shape {

    //  ***** Определены обязательные методы ******
    //  ***** Метод для рисования объекта    ******
    public abstract void draw (GraphicsContext graphicsContext);

    // ***** Методы для движения объекта *****
    public abstract void moveUp (int step);
    public abstract void moveDown (int step);
    public abstract void moveRight (int step);
    public abstract void moveLeft (int step);

}
