package homework9.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public final class UtilGenerateProblem {
    private static final Long COUNT_MINUTES_PROBLEM = 20L;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static Long problemMinutes = 0L;
    private static Integer id = 0;

    private UtilGenerateProblem() {
    }

    private static final LocalDateTime problemData = LocalDateTime.now().minusDays(2L);
    private static final Random random = new Random();

    private static final List<String> listFirstName = List.of("Иван", "Петр", "Вася", "Денис", "Дмитрий", "Сергей",
            "Александр", "Евгений", "Владимир", "Павел");
    private static final List<String> listLastName = List.of("Иванов", "Петров", "Сидоров", "Морозов", "Кузнецов",
            "Бондарь", "Дордаль", "Жегалов", "Кистанов", "Федоров");
    private static final List<String> listProblems = List.of("Не включается свет", "Почему опять не работает интернет",
            "Кто-то оборвал мне телефонный кабель", "Не включается компьютер", "Не работает кондиционер", "Лампочки перегорели",
            "Принтер не печатает", "Монитор завис", "Мышка не реагирует на движения", "Кнопки на клавиатуре залипают");

    public static String getIdDataTimePhoneNumberNameProblem() {
        id++;
        return (getId() + ", " + getDataTimeProblem() + ", " + getRandomPhoneNumber() + ", " + getRandomLastName() + " "
                + getRandomFirstName() + ", " + getRandomProblem());
    }

    public static String getDataTimeProblem() {
        LocalDateTime problemDateTime = problemData.plusMinutes(problemMinutes += COUNT_MINUTES_PROBLEM);
        return problemDateTime.format(FORMATTER);
    }

    public static String getRandomFirstName() {
        return getListFirstName().get(random.nextInt(getListFirstName().size() - 1));
    }

    public static String getRandomLastName() {
        return getListLastName().get(random.nextInt(getListLastName().size() - 1));
    }

    public static String getRandomProblem() {
        return getListProblems().get(random.nextInt(getListProblems().size() - 1));
    }

    public static String getRandomPhoneNumber() {
        final int codeCountry = random.nextInt(3);
        final int codeMobileOperator = random.nextInt(3);
        final int phoneNumber = random.nextInt(10_000_000);

        if (codeCountry == 0) {
            if (codeMobileOperator == 0) {
                if (phoneNumber < 1000_000) {
                    return "+375 29 " + new StringBuilder(String.valueOf(phoneNumber + 1000_000)).insert(3, " ").insert(6, " ");
                }
                return "+375 29 " + new StringBuilder(String.valueOf(phoneNumber)).insert(3, " ").insert(6, " ");
            } else if (codeMobileOperator == 1) {
                if (phoneNumber < 1000_000) {
                    return "+375 33 " + new StringBuilder(String.valueOf(phoneNumber + 1000_000)).insert(3, " ").insert(6, " ");
                }
                return "+375 33 " + new StringBuilder(String.valueOf(phoneNumber)).insert(3, " ").insert(6, " ");
            } else if (phoneNumber < 1000_000) {
                return "+375 44 " + new StringBuilder(String.valueOf(phoneNumber + 1000_000)).insert(3, " ").insert(6, " ");
            }
            return "+375 44 " + new StringBuilder(String.valueOf(phoneNumber)).insert(3, " ").insert(6, " ");

        } else if (codeCountry == 1) {
            if (codeMobileOperator == 0) {
                if (phoneNumber < 1000_000) {
                    return "29" + (phoneNumber + 1000_000);
                }
                return "29" + phoneNumber;
            } else if (codeMobileOperator == 1) {
                if (phoneNumber < 1000_000) {
                    return "33" + (phoneNumber + 1000_000);
                }
                return "33" + phoneNumber;
            } else if (phoneNumber < 1000_000) {
                return "44" + (phoneNumber + 1000_000);
            }
            return "44" + phoneNumber;

        } else {
            if (codeMobileOperator == 0) {
                if (phoneNumber < 1000_000) {
                    return "+37529" + (phoneNumber + 1000_000);
                }
                return "+37529" + phoneNumber;
            } else if (codeMobileOperator == 1) {
                if (phoneNumber < 1000_000) {
                    return "+37533" + (phoneNumber + 1000_000);
                }
                return "+37533" + phoneNumber;
            } else if (phoneNumber < 1000_000) {
                return "+37544" + (phoneNumber + 1000_000);
            }
            return "+37544" + phoneNumber;
        }
    }

    public static Integer getId() {
        return id;
    }
    public static List<String> getListFirstName() {
        return listFirstName;
    }
    public static List<String> getListLastName() {
        return listLastName;
    }
    public static List<String> getListProblems() {
        return listProblems;
    }
    public static Long getProblemMinutes() {
        return problemMinutes;
    }
}
