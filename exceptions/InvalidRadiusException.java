package exceptions;

//Класс InvalidRadiusException описывает исключение, возникающее при попытке создать круг с отрицательным радиусом.
public class InvalidRadiusException extends Exception {
    public InvalidRadiusException(String message) {
        super(message);
    }
}
