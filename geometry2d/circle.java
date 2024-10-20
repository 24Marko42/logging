package geometry2d;

import exceptions.InvalidRadiusException;

import java.util.logging.*;

//Класс Circle реализует интерфейс Figure и описывает круг.
public class circle implements figure {
    private double radius; 
    private static final Logger logger = Logger.getLogger(circle.class.getName());

    static {
        try {
            // Создаем обработчик файла для логирования
            FileHandler fileHandler = new FileHandler("figures.log");
            fileHandler.setFormatter(new XMLFormatter()); // Логи в формате XML
            logger.addHandler(fileHandler);
            logger.setLevel(Level.SEVERE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public circle(double radius) throws InvalidRadiusException{
        if (radius < 0) {
            logger.severe("\nAttempt to create a circle with a negative radius: " + radius);
            throw new InvalidRadiusException("The radius cannot be negative");
        }
        this.radius = radius;
        logger.severe("\nThe circle is created with a radius: " + radius);

    }

    //Метод area() вычисляет площадь круга.
    @Override // означает, что метод переопределён в данном классе
    public double area() {
        return Math.PI * radius * radius;
    }

    //Метод perimeter() вычисляет периметр круга.
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    //Метод toString() возвращает строковое представление круга.
    @Override
    public String toString() {
        return "\nCircle {" + "radius=" + radius + ", area=" + area() + ", perimeter=" + perimeter() + '}';
    }
}