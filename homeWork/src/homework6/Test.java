package homework6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * 1. Средняя оценка студентов этого курса, количество оценок у которых больше 3-
 * 2. Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * 3. Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public class Test {

    public static void main(String[] args) {

        List<Student> listStudents = List.of(
                new Student("Ivan", "Ivanov", 2, List.of(5, 7, 6)),
                new Student("Petr", "Zaurov", 4, List.of(3, 5, 5, 4, 7, 5)),
                new Student("Ivan", "Abramov", 3, List.of(8, 8, 7, 6)),
                new Student("Timur", "Karginov", 5, List.of(5, 5, 7)),
                new Student("Olga", "Petrova", 1, List.of(7, 8, 5, 5)),
                new Student("Ivan", "Lenon", 3, List.of(8, 8, 9)),
                new Student("Petr", "Romanov", 4, List.of(4, 8, 9, 5, 4))
        );

        Map<Integer, List<Double>> avgGradesResult = listStudents.stream()
                .filter(student -> student.getListGrades().size() > 3)
                .collect(Collectors.groupingBy(Student::getCourse,
                        Collectors.mapping(student -> student.getListGrades().stream()
                                        .mapToInt(Integer::intValue).average().orElse(0.0),
                                Collectors.toList())));

        System.out.println("Map, где ключом является номер курса, " +
                "а значением средняя оценка студентов этого курса, " +
                "количество оценок у которых больше 3-x: " + avgGradesResult);

        Map<Integer, List<String>> sortFullNameResult = listStudents.stream()
                .sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName))
                .collect(Collectors.groupingBy(Student::getCourse,
                        Collectors.mapping(student -> student.getFirstName() + " " + student.getLastName(),
                                Collectors.toList())));

        System.out.println("Map, где ключом является номер курса, " +
                "а значением отсортированный по полям Имя и Фамилия список студентов данного курса," +
                " но только с полями Имя и Фамилия: " + sortFullNameResult);

        Map<Integer, List<NewStudent>> sortFullNameAndAvgGradesResult = listStudents.stream()
                .sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName))
                .collect(Collectors.groupingBy(Student::getCourse,
                        Collectors.mapping(student -> new NewStudent(student.getFirstName() + " " + student.getLastName(),
                                        student.getListGrades().stream().mapToInt(Integer::intValue).average().orElse(0.0)),
                                Collectors.toList())));

        System.out.println("Map, где ключом является номер курса, а значением объект с двумя полями " +
                "(отсортированный список студентов и средняя оценка этих студентов): " + sortFullNameAndAvgGradesResult);

    }
}
