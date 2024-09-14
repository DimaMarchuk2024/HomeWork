package homework2;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число,
 * а возвращать количество четных цифр (вторая функция - нечетных).
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class DZ1Loop {
    public static void main(String[] args) {
        int value = -851502691;
        
        int resultEven = getEven(value);
        System.out.println("количество четных цифр: " + resultEven);
        int resultOdd = getOdd(value);
        System.out.println("количество нечетных цифр: " + resultOdd);
    }

    private static int getEven(int value) {
        int result = 0;
        for (int currentValue = (value > 0 ? value : value * -1); currentValue > 0 ; currentValue = currentValue /10) {
            if (currentValue % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    private static int getOdd(int value) {
        int result = 0;
        for (int currentValue = (value > 0 ? value : value * -1); currentValue > 0 ; currentValue = currentValue /10) {
            if (currentValue % 2 != 0) {
                result++;
            }
        }
        return result;
    }
}
