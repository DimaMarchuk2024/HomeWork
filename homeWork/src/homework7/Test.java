package homework7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static homework7.UtilWriter.writeColumnNamesResultAndErrors;
import static homework7.UtilWriter.writeValuesResultAndErrors;

/**
 * Даны два файла в формате CSV.
 * CSV (Comma-Separated Values) файл - это обычный текстовый файл, где через запятую
 * (может использоваться и любой другой символ) перечислены значения.
 * Также может быть в первой строчке таких файлов заголовок с названием колонок.
 * Формат первого файла items-price.csv:
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 * Формат второго файла items-name.csv:
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 * Задача:
 * Считать оба CSV файла и объединить их по полю ID в один result.csv, где будут следующие поля: ID,NAME,PRICE.
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах, то записать их в один файл errors.csv,
 * где будет лишь одно поле ID.
 */

public class Test {
    public static void main(String[] args) throws IOException {
        Path pathPrice = Path.of("resources", "items-price.csv");
        Path pathName = Path.of("resources", "items-name.csv");
        Path resultPath = Path.of("resources", "result.csv");
        Path errorPath = Path.of("resources", "errors.csv");

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(resultPath);
             BufferedWriter errorBufferedWriter = Files.newBufferedWriter(errorPath);
             Stream<String> linesIdPrice = Files.lines(pathPrice);
             Stream<String> linesIdName = Files.lines(pathName)) {

            Map<String, String> mapIdPrice = getMapIdPrice(linesIdPrice);
            Map<String, String> mapIdName = getMapIdName(linesIdName);

            writeColumnNamesResultAndErrors(bufferedWriter, errorBufferedWriter, mapIdPrice, mapIdName);
            writeValuesResultAndErrors(bufferedWriter, errorBufferedWriter, mapIdPrice, mapIdName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> getMapIdName(Stream<String> linesIdName) {
        return linesIdName
                .collect(Collectors.toMap(lineId -> lineId.substring(0, lineId.indexOf(",")),
                        lineName -> lineName.substring(lineName.indexOf(",") + 1, lineName.lastIndexOf(","))));
    }

    private static Map<String, String> getMapIdPrice(Stream<String> linesIdPrice) {
        return linesIdPrice
                .collect(Collectors.toMap(lineId -> lineId.substring(0, lineId.indexOf(",")),
                        linePrice -> linePrice.substring(linePrice.indexOf(",") + 1)));
    }
}