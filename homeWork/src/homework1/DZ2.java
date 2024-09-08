package homework1;

/**
 * Даны 3 переменные:
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 *
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */

public class DZ2 {
    public static void main(String[] args) {
        double operand1 = 25.46;
        double operand2 = 45.89;
        char operation = '*';
        double result = operationParam(operand1, operand2, operation);
        System.out.println(operand1 + " " + operation + " " + operand2 + " = " + result);
    }

    public static double operationParam(double op1, double op2, char operation) {

        if (operation == '+') {
            return op1 + op2;
        } else if (operation == '-') {
            return op1 - op2;
        } else if (operation == '*') {
            return op1 * op2;
        } else if (operation == '/') {
            return op1 / op2;
        } else if (operation == '%') {
            return op1 % op2;
        } else {
            return 0.0;
        }
    }
}
