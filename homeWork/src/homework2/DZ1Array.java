package homework2;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы
 * (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * <p>
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции.
 * main - только для тестирования написанного функционала.
 */
public class DZ1Array {
    public static void main(String[] args) {
        int[] values = {1, -12, 26, 10, -3, 0, 5};

        positiveArray(values);
        System.out.println("Hello");
    }

    private static void positiveArray(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 0){
                count++;
            }
        }

        int[] valuesPositive = new int[count];
        count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 0) {
                valuesPositive[count++] = values[i] * valuesPositive.length;
            }
        }

        System.out.print("Массив с положительными значениями, умноженными на длину " + valuesPositive.length + " : ");
        for(int value : valuesPositive) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}


    