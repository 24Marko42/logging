package exceptions;

//Класс InvalidDimensionException описывает исключение, возникающее при попытке создать прямоугольник с отрицательными размерами.
public class InvalidDimensionException extends Exception {
    /*
    Конструктор InvalidDimensionException создает новое исключение с заданным сообщением.
    message - сообщение об исключении
     */
    public InvalidDimensionException(String message) {
        super(message);
    }
}
/*Слово super используется в Java для обращения к конструктору суперкласса или родительского класса. 
В данном случае, super(message) вызывает конструктор суперкласса Exception и передает ему сообщение об исключении, 
чтобы класс InvalidDimensionException унаследовал функциональность и свойства родительского класса Exception. */