package sample;

/*
 * Класс tPoint.
 * Включает в себя следующие поля, описывающие объект типа "точка":
 * 1. Координаты posX, posY;
 * 2. Цвет точки, заданный в цветовой схеме RGB кодами трех цветов
 *    colorR - red, colorG - green, colorB - blue.
 */


import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class tPoint{

    protected int posX;
    protected int posY;
    protected double colorR;
    protected double colorG;
    protected double colorB;
    private Circle circle;

    private static final int STEP = 5;


/*
 * Конструктор класса. При инициализации объекта, задает значения полей данных.
 */

    public tPoint(int posX, int posY, double colorR, double colorG, double colorB) {
        this.posX = posX;
        this.posY = posY;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

/*
 * Методы для работы с полями класса.
 * 1. setPosX, setPosY и т. д. задают значения защищенных полей
 * 2. getPosX, getPosY и т. д. возвращают значения защищенных полей
 */

    public void setPosX(int x) {
        posX = x;
    }

    public void setPosY(int y) {
        posY = y;
    }

    public void setColorR(double r) {
        colorR = r;
    }

    public void setColorG(double g) {
        colorG = g;
    }

    public void setColorB(double b) {
        colorB = b;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public double getColorR() {
        return colorR;
    }

    public double getColorG() {
        return colorG;
    }

    public double getColorB() {
        return colorB;
    }


/*
 * В методе createPoint создается точка. 
 * Точка, это в действительности залитая цветом окружность малого радиуса.
 * 
 */
    
    public void create (Group rt) {
            circle = new Circle(2, Color.color(colorR, colorG, colorB)); // создается точка, с определенным цветом
            circle.setTranslateX(posX);             // Задается смещение точки относительно левого верхнего угла
            circle.setTranslateY(posY);             
            rt.getChildren().add(circle);           // Добавление точки в ноду rt.

    }

    public void draw (GraphicsContext gc) {
        gc.setFill(Color.color(colorR, colorG, colorB));
        gc.fillOval(posX, posY, 2, 2);
    }

/*
 *  Методы для смещения точки вверх, вниз, вправо, влево.
 *  
 */
    public void moveUp (int step) {
        posY -= step;
    }

    public void moveDown (int step) {
        posY += step;
    }

    public void moveRight (int step) {
        posX += step;
    }

    public void moveLeft (int step) {
        posX -= step;
    }

}