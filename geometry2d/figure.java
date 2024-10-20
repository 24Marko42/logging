package geometry2d;

//Интерфейс Figure описывает общие методы для всех геометрических фигур.
public interface figure {
    double area(); //Метод area() вычисляет площадь фигуры.
    double perimeter(); //Метод perimeter() вычисляет периметр фигуры.
    String toString(); //Метод toString() возвращает строковое представление фигуры.
}