package homework1;

/**
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника
 * и затем эти площади сравниваются друг с другом.
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит
 * на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */
public class DZ3 {

    public static void main(String[] args) {
        int a = 17;
        int b = 15;

        double triangleA = calculateArea(a);
        double triangleB = calculateArea(b);
        equalTriangle(triangleA, triangleB);
    }

    public static double calculateArea(int s) {
        return (double) (s * s) / 2;
    }

    public static void equalTriangle(double triangleA, double triangleB) {
        if (triangleA > triangleB) {
            System.out.println("первый треугольник больше второго");
        } else if (triangleA < triangleB) {
            System.out.println("первый треугольник меньше второго");
        } else {
            System.out.println("первый треугольник равен второму");
        }
    }
}
