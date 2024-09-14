package homework2;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа
 * (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и
 * вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class DZ2Array {
    public static void main(String[] args) {
        char[] symbol = {'8', '*', '$', 'd', '#', 'W'};
        int[] values = new int[symbol.length];

        conversion(symbol, values);
        average(values);
    }

    private static void conversion(char[] symbol, int[] values) {
        System.out.print("Преобразованный массив чисел: ");
        for (int i = 0; i < symbol.length; i++) {
            values[i] = symbol[i];
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    private static void average(int[] values) {
        double sumValues = 0;
        for (int i = 0; i < values.length; i++) {
            sumValues += values[i];
        }

        double average = sumValues / values.length;
        System.out.println("Среднее арифметическое всех элементов целочисленного массива: " + average);
        System.out.print("Элементы массива, которые больше среднего арифметического: ");
        for (int value : values) {
            if (value > average) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }
}
