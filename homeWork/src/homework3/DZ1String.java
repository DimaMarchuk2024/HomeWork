package homework3;
/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра,
 * если они идут друг за другом.Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * Например: "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

public class DZ1String {
    public static void main(String[] args) {
        String value = "aA aafabc C Cpddd Dio OsfWwww";

        String result = deleteDuplicateChar(value);
        System.out.println("Строка без повторяющихся символов в верхнем регистре: " + result);
    }

    private static String deleteDuplicateChar(String value) {
        StringBuilder stringBuilder = new StringBuilder(value.replace(" ", ""));

        for (int i = 0; i < stringBuilder.length(); i++) {
            if ((i + 1) == stringBuilder.length()) {
                break;
            } else if (stringBuilder.substring(i, i + 1)
                    .equalsIgnoreCase(stringBuilder.substring(i + 1, i + 2))) {
                stringBuilder.deleteCharAt(i);
                i--;
            }
        }
        return stringBuilder.toString().toUpperCase();
    }
}