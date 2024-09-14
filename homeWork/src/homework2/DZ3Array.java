package homework2;
/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других:
 * с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 */
public class DZ3Array {
    public static void main(String[] args) {

        int[] values = {-4, 0, 1, 9, 0, -18, 3};

        int[][] array = splitArray(values);

        printArray(array);
    }

    private static int[][] splitArray(int[] values) {

        int[] arrayNegative = getArrayNegative(values);
        int[] arrayZero = getArrayZero(values);
        int[] arrayPositive = getArrayPositive(values);

        int[][] array = {arrayNegative, arrayZero, arrayPositive};

        return array;
    }

    private static int[] getArrayNegative(int[] values) {
        int countNegative = 0;
        for (int value : values) {
            if (value < 0) {
                countNegative++;
            }
        }
        int[] arrayNegative = new int[countNegative];
        countNegative = 0;
        for (int value : values) {
            if (value < 0) {
                arrayNegative[countNegative++] = value;
            }
        }
        System.out.print("Массив с отрицательными значениями: ");
        for (int valueNegative : arrayNegative) {
            System.out.print(valueNegative + " ");
        }
        System.out.println();
        return arrayNegative;
    }

    private static int[] getArrayZero(int[] values) {
        int countNull = 0;
        for (int value : values) {
            if (value == 0) {
                countNull++;
            }
        }
        int[] arrayZero = new int[countNull];
        countNull = 0;
        for (int value : values) {
            if (value == 0) {
                arrayZero[countNull++] = value;
            }
        }
        System.out.print("Массив с нулевыми значениями: ");
        for (int valueZero : arrayZero) {
            System.out.print(valueZero + " ");
        }
        System.out.println();
        return arrayZero;
    }

    private static int[] getArrayPositive(int[] values) {
        int countPositive = 0;
        for (int value : values) {
            if (value > 0) {
                countPositive++;
            }
        }
        int[] arrayPositive = new int[countPositive];
        countPositive = 0;
        for (int value : values) {
            if (value > 0) {
                arrayPositive[countPositive++] = value;
            }
        }
        System.out.print("Массив с положительными значениями: ");
        for (int valuePositive : arrayPositive) {
            System.out.print(valuePositive + " ");
        }
        System.out.println();
        return arrayPositive;
    }

    private static void printArray(int[][] array) {
        System.out.println("Получившийся двумерный массив: ");
        for (int[] value : array) {
            for (int val : value) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
