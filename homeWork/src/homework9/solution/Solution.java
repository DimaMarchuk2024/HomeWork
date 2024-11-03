package homework9.solution;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {

    private static final String REGEX_DATA_TIME_PHONE_NUMBER_NAME_FROM_PROBLEM_LIST = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}, " +
            "(\\+375)? ?(\\(?\\d{2}\\)?) ?(\\d{3}) ?(\\d{2}) ?(\\d{2}), " +
            "\\D+ \\D+, \\D+$";
    private static final DateTimeFormatter FORMATTER_TIME_SOLUTION = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    List<String> listProblem;

    public Solution(List<String> listProblem) {
        this.listProblem = listProblem;
    }

    File fileSolution = Path.of("resources", "solution.log").toFile();
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void writeSolutionToFile() {
        for (int i = 0; i < 2; i++) {
            final int index = i;
            executorService.execute(() -> {
                for (int j = index; j < listProblem.size(); j += 2) {
                    try (FileOutputStream fileOutputStreamSolution = new FileOutputStream(fileSolution, true)) {
                        String problem = listProblem.get(j);
                        String timeSolution = LocalDateTime.now().format(FORMATTER_TIME_SOLUTION);
                        String solution = problem.replaceAll(REGEX_DATA_TIME_PHONE_NUMBER_NAME_FROM_PROBLEM_LIST,
                                timeSolution + ", +375 ($2) $3-$4-$5");
                        fileOutputStreamSolution.write(solution.concat("\n").getBytes());
                        Thread.sleep(5000L);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
