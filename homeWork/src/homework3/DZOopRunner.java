package homework3;

import homework3.dzoop.Apartment;
import homework3.dzoop.Home;
import homework3.dzoop.Levels;
import homework3.dzoop.Room;

/**
 * Представить в виде классов и их композиции следующую модель.
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * В каждом классе реализовать метод print, который на консоль выводит информацию
 * об объекте (должны присутствовать все поля объекта!).
 * Например, метод print класса этаж должен выводить на консоль:
 * “Этаж 2, количество квартир 18”
 * Создание всех объектов вынести в отдельный класс с методом main.
 * <p>
 * Там же реализовать метод printAllInformation, который на вход принимает
 * объект типа дом, и выводит информацию о нем, его этажах, квартирах и комнатах,
 * вызывая методы print.
 */
public class DZOopRunner {
    public static void main(String[] args) {

        int countRooms = 5;
        int countApartments = 10;
        int countLevels = 20;
        int numberHome = 1;

        Home home = builderHome(countRooms, countApartments, countLevels, numberHome);

        printAllInformation(home);
    }

    private static Home builderHome(int countRooms, int countApartments, int countLevels, int numberHome) {

        Room[] room = new Room[countRooms];
        int countR = 0;
        for (int i = 1; i <= countRooms; i++) {
            if (i > countRooms - 2) {
                room[countR++] = new Room(true);
            } else room[countR++] = new Room(false);
        }

        Levels[] levels = new Levels[countLevels];
        int countL = 0;
        for (int i = 1; i <= countLevels; i++) {
            Apartment[] apartments = new Apartment[countApartments];
            int countA = 0;
            for (int j = 1; j <= countApartments; j++) {
                apartments[countA++] = new Apartment(i == 1 ? j : (j + countApartments * (i - 1)), room);
            }
            levels[countL++] = new Levels(i, apartments);
        }
        return new Home(numberHome, levels);
    }

    private static void printAllInformation(Home home) {

        home.print();

        for (Levels levels : home.getLevel()) {
            System.out.println();
            levels.print();

            for (Apartment apartment : levels.getApartment()) {
                System.out.println();
                apartment.print();

                for (Room room : apartment.getRoom()) {
                    room.print();
                }
            }
        }
    }
}
