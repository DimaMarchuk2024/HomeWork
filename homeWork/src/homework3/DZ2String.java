package homework3;
/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * Посчитать сууму всех чисел из строки.
 * Например:
 * "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?"
 */
public class DZ2String {

    public static void main(String[] args) {
        String value = "Привет 8, 0 как 1 2 твои дела?  5 Может4, сделать 3 дело?";

        int lengthCharArray = calculateLengthCharArray(value);

        int[] numberArray = convertStringToNumberArray(value, lengthCharArray);

        System.out.print("Массив цифр из переданной строки: ");
        printArray(numberArray);

        int sum = sumNumberArray(numberArray);
        System.out.println("Сумма всех чисел из строки: " + sum);
    }

    private static int calculateLengthCharArray(String value) {
        char[] charArray = value.toCharArray();
        int lengthCharArray = 0;
        for (char c : charArray) {
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5'
                    || c == '6' || c == '7' || c == '8' || c == '9') {
                lengthCharArray++;
            }
        }
        return lengthCharArray;
    }

    private static int[] convertStringToNumberArray(String value, int length) {
        char[] charArray = value.toCharArray();
        int[] numberArray = new int[length];
        int countIndex = 0;
        for (char c : charArray) {
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                numberArray[countIndex++] = Integer.parseInt((String.valueOf(c)));
            }
        }
        return numberArray;
    }

    private static int sumNumberArray(int[] numberArray) {
        int sum = 0;
        for (int value : numberArray) {
            sum += value;
        }
        return sum;
    }

    private static void printArray(int[] numberArray) {
        for (int value : numberArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
