package homework9;

import com.dmdev.lesson91homework.Util.UtilGenerateProblem;
import com.dmdev.lesson91homework.solution.Solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Реализовать эмулятор сервиса поддержки в Беларуси.
 * <p>
 * Все жалобы клиентов хранятся в хронологическом порядке в виде текстового лог-файла следующего формата
 * (столбцы разделены через запятую):
 * <p>
 * - Порядковый номер клиента
 * - Дата и время звонка в ISO формате
 * - Фамилия и Имя клиента
 * - Телефон клиента
 * - Текст жалобы
 * <p>
 * Каждая новая жалоба идет с новой строки в лог-файле.
 * <p>
 * Например:
 * 1, 2021-09-13T10:15:30, Иванов Иван, +375 29 999 78 90, Не включается свет
 * 2, 2021-12-22T11:38:16, Петров Петр, +375257777765, Почему опять не работает интернет?
 * 3, 2021-12-28T06:55:24, Петров Петр, 333652193, Кто-то оборвал мне телефонный кабель
 * <p>
 * Задача:
 * С какой-то периодичностью (например, раз в 2 минуты) считывать все новые записи из лог-файла и отправлять
 * их диспетчерам для созвона с клиентами (ограничить количество диспетчеров, например, 2-3).
 * <p>
 * Созвон длится какое-то фиксированное время (например, 3-5 секунд), после чего он записывается в другой лог-файл
 * в виде:
 * - Порядковый номер клиента с предыдущего лог файла
 * - Дата и время созвона
 * - Номер телефона клиента
 * <p>
 * Например:
 * 2, 2022-01-04 04:15, +375 (25) 777-77-65
 * 1, 2022-01-04 04:30, +375 (29) 999-78-90
 * 3, 2022-01-04 04:45, +375 (33) 365-21-93
 * <p>
 * Номера телефонов могут быть представлены по-разному, поэтому привести их к одному формату: +375 (29) 999-78-90.
 * <p>
 * * Желательно реализовать функционал добавления новых жалоб в конец лог-файла.
 */

public class SupportServiceRunner {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        generateSupportService();

    }

    private static void generateSupportService() throws IOException, InterruptedException {
        for (int x = 0; x < 10; x++) {

            Path pathProblem = Path.of("resources", "problems.log");
            writeProblemInFile(pathProblem);

            Thread.sleep(60_000L);
            List<String> listProblem = readFromFileProblemToList(pathProblem);

            Solution solution = new Solution(listProblem);
            solution.writeSolutionToFile();
        }
    }

    private static void writeProblemInFile(Path pathProblem) throws IOException {
        try (BufferedWriter bufferedWriterProblem = Files.newBufferedWriter(pathProblem)) {
            for (int i = 0; i < 10; i++) {
                bufferedWriterProblem.write(UtilGenerateProblem.getIdDataTimePhoneNumberNameProblem());
                bufferedWriterProblem.newLine();
            }
        }
    }

    private static List<String> readFromFileProblemToList(Path pathProblem) throws IOException {
        List<String> listProblem = new ArrayList<>();
        try (BufferedReader bufferedReaderProblem = Files.newBufferedReader(pathProblem)) {
            for (int i = 0; i < 10; i++) {
                String s = bufferedReaderProblem.readLine();
                listProblem.add(s);
            }
        }
        return listProblem;
    }
}
