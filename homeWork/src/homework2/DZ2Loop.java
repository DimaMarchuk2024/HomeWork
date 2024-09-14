package homework2;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class DZ2Loop {
    public static void main(String[] args) {
        int value = -123456789;

        int result = reverse(value);
        System.out.println(result);
    }

    private static int reverse(int value) {
        int countNumbers = 0;
        for (int currentValue = (value > 0 ? value : value * -1); currentValue > 0; currentValue = currentValue / 10) {
            countNumbers++;
        }

        int result = 0;
        for (int currentValue = (value > 0 ? value : value * -1); currentValue > 0; currentValue = currentValue / 10) {
            result += (int) ((currentValue % 10) * Math.pow(10, --countNumbers));
        }

        if (value > 0) {
            return result;
        } else {
            return result * -1;
        }
    }
}
