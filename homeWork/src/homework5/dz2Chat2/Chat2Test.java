package homework5.dz2Chat2;
/**
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей”
 * будет список объектов типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор),
 * имя и возраст.
 * Задача:
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chat2Test {
    public static void main(String[] args) {

        Chat2 soccer = getChat2Soccer();
        Chat2 music = getChat2Music();
        Chat2 space = getChat2Space();
        Chat2 history = getChat2History();
        Chat2 dance = getChat2Dance();
        Chat2 auto = getChat2Auto();

        List<Chat2> chat2List = Arrays.asList(soccer, music, space, history, dance, auto);

        List<User> newUserChat = reorganizationChat2ListToUserListOver18(chat2List);
        System.out.println("Список пользователей всех чатов, возраст которых больше 18 лет: " + newUserChat);

        double averageAge = averageAgeChildren(chat2List);
        System.out.println("Средний возраст пользователей от 18 и младше лет = " + averageAge);
    }

    private static List<User> reorganizationChat2ListToUserListOver18(List<Chat2> chat2List) {
        List<User> newUserChat = new ArrayList<>();
        for (Chat2 chat2 : chat2List) {
            for (User user : chat2.getUser()) {
                Integer age = user.getAge();
                if (age > 18) {
                    newUserChat.add(user);
                }
            }
        }
        return newUserChat;
    }

    private static double averageAgeChildren(List<Chat2> chat2List) {
        int count = 0;
        int sum = 0;
        for (Chat2 chat2 : chat2List) {
            for (User user : chat2.getUser()) {
                Integer age = user.getAge();
                if (age <= 18) {
                    sum += age;
                    count++;
                }
            }
        }
        return (double) sum / count;
    }

    private static Chat2 getChat2Auto() {
        User dmitriy = new User(1, "Dmitriy", 26);
        User diana = new User(2, "Diana", 27);
        User roman = new User(3, "Roman", 17);

        List<User> listAutoUsers = Arrays.asList(dmitriy, diana, roman);
        return new Chat2("Auto", listAutoUsers);
    }

    private static Chat2 getChat2Dance() {
        User sergey = new User(1, "Sergey", 18);
        User svetlana = new User(2, "Svetlana", 15);
        User polina = new User(3, "Polina", 19);

        List<User> listDanceUsers = Arrays.asList(sergey, svetlana, polina);
        return new Chat2("Dance", listDanceUsers);
    }

    private static Chat2 getChat2History() {
        User ekaterina = new User(1, "Ekaterina", 15);
        User olga = new User(2, "Olga", 17);
        User timur = new User(3, "Timur", 22);

        List<User> listHistoryUsers = Arrays.asList(ekaterina, olga, timur);
        return new Chat2("History", listHistoryUsers);
    }

    private static Chat2 getChat2Space() {
        User evgeniy = new User(1, "Evgeniy", 28);
        User pavel = new User(2, "Pavel", 35);
        User nikita = new User(3, "Nikita", 25);

        List<User> listSpaceUsers = Arrays.asList(evgeniy, pavel, nikita);
        return new Chat2("Space", listSpaceUsers);
    }

    private static Chat2 getChat2Music() {
        User petr = new User(1, "Petr", 15);
        User elena = new User(2, "Elena", 13);
        User yulia = new User(3, "Yulia", 18);

        List<User> listMusicUsers = Arrays.asList(petr, elena, yulia);
        return new Chat2("Music", listMusicUsers);
    }

    private static Chat2 getChat2Soccer() {
        User ivan = new User(1, "Ivan", 12);
        User igor = new User(2, "Igor", 18);
        User oleg = new User(3, "Oleg", 22);

        List<User> listSoccerUsers = Arrays.asList(ivan, igor, oleg);
        return new Chat2("Soccer", listSoccerUsers);
    }
}
