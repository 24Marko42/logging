
//import всего нужного для работы программы
import exceptions.InvalidDimensionException;
import exceptions.InvalidHeightException;
import exceptions.InvalidRadiusException;

import geometry2d.circle;
import geometry2d.rectangle;
import geometry3d.cylinder;

import java.util.logging.*;

// В Main создаём объекты классов Circle, Rectangle и Cylinder (правильные и неправильные).
public class main {
    private static final Logger logger = Logger.getLogger(main.class.getName());

    static {
        try {
            // Настраиваем вывод логов в консоль
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(consoleHandler);
            // Устанавливаем уровень логирования на FINE.
            logger.setLevel(Level.FINE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Создаем корректные объекты и выводим их строковое представление 
            circle circle1 = new circle(5);
            rectangle rectangle1 = new rectangle(4, 6);
            cylinder cylinder1 = new cylinder(circle1, 10.56);

            // Логируем успешное создание объектов
            logger.fine("\n\nCreate figure's: " + circle1 + ", " + rectangle1 + ", " + cylinder1);

            // Выводим строковые представления объектов
            System.out.println(circle1);
            System.out.println(rectangle1);
            System.out.println(cylinder1);

        } catch (InvalidRadiusException | InvalidDimensionException | InvalidHeightException e) {
            // Логируем сообщение об ошибке
            logger.severe("\n\nErrors of incorrect objects: " + e.getMessage());
        }

        // Проверка обработки исключений для объектов с некорректными значениями
        try {
            circle circleInvalid = new circle(-5);
        } catch (InvalidRadiusException e) {
            logger.severe("\n\nError of incorrect circle with -radius: " + e.getMessage());
        }

        try {
            rectangle rectangleInvalid = new rectangle(-4, 6);
        } catch (InvalidDimensionException e) {
            logger.severe("\n\nError of incorrect rectangle with -storona: " + e.getMessage());
        }

        try {
            circle circleValid = new circle(3);
            cylinder cylinderInvalid = new cylinder(circleValid, -10);
        } catch (InvalidHeightException e) {
            logger.severe("\n\nError of incorrect cylinder with -: " + e.getMessage());
        } catch (InvalidRadiusException e) {
            logger.severe("\n\nError of incorrect circle with -radius, while creating cylinder: " + e.getMessage());
        }
    }
}
