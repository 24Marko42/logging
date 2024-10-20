package geometry2d;

import exceptions.InvalidDimensionException;
import javafx.scene.shape.Rectangle;

import java.util.logging.*;

//Класс Rectangle реализует интерфейс Figure и описывает прямоугольник.
public class rectangle implements figure {
    private double width; //Поле width хранит ширину прямоугольника.
    private double height; // Поле height хранит высоту прямоугольника.
    private static final Logger logger = Logger.getLogger(Rectangle.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("figures.log");
            fileHandler.setFormatter(new XMLFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public rectangle(double width, double height) throws InvalidDimensionException{
        if (width < 0 || height < 0) {
            logger.info("\nAttempt to create a rectangle with negative dimensions: width=" + width + ", height=" + height);
            throw new InvalidDimensionException("\nThe dimensions cannot be negative");
        }
        this.width = width;
        this.height = height;
        logger.info("\nThe triangle has been created: width=" + width + ", height=" + height);
    }

    //Метод area() вычисляет площадь прямоугольника.
    @Override
    public double area() {
        return width * height;
    }

    //Метод perimeter() вычисляет периметр прямоугольника.
    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    //Метод toString() возвращает строковое представление прямоугольника.
    @Override
    public String toString() {
        return "\nRectangle {" + "width=" + width + ", height=" + height + ", area=" + area() + ", perimeter=" + perimeter() + '}';
    }
}
