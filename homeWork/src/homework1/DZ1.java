package homework1;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */

public class DZ1 {
    public static void main(String[] args) {
        int minutes = 59;
        quarterHour(minutes);
    }

    public static void quarterHour(int minutes) {
        if (0 <= minutes && minutes < 15) {
            System.out.println(minutes + " в первой четверти");
        } else if (15 <= minutes && minutes < 30) {
            System.out.println(minutes + " во второй четверти");
        } else if (30 <= minutes && minutes < 45) {
            System.out.println(minutes + " в третьей четверти");
        } else if (45 <= minutes && minutes <= 59) {
            System.out.println(minutes + " в четвертой четверти");
        } else {
            System.out.println("Неверный параметр: " + minutes);
        }
    }
}
