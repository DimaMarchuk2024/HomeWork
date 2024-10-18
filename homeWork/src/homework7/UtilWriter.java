package homework7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public final class UtilWriter {

    private UtilWriter() {
    }

    public static void writeColumnNamesResultAndErrors(BufferedWriter bufferedWriter,
                                                       BufferedWriter errorBufferedWriter,
                                                       Map<String, String> mapIdPrice,
                                                       Map<String, String> mapIdName) throws IOException {
        for (Map.Entry<String, String> entryIdName : mapIdName.entrySet()) {
            String id = entryIdName.getKey();
            String name = entryIdName.getValue();
            String price = mapIdPrice.get(entryIdName.getKey());

            if (id.equals("ID")) {
                bufferedWriter.write(id + "," + name + "," + price);
                bufferedWriter.newLine();

                errorBufferedWriter.write(id);
                errorBufferedWriter.newLine();
            }
        }
    }

    public static void writeValuesResultAndErrors(BufferedWriter bufferedWriter,
                                                  BufferedWriter errorBufferedWriter,
                                                  Map<String, String> mapIdPrice,
                                                  Map<String, String> mapIdName) throws IOException {
        for (Map.Entry<String, String> entryIdName : mapIdName.entrySet()) {
            String idValue = entryIdName.getKey();
            String nameValue = entryIdName.getValue();
            String priceValue = mapIdPrice.get(entryIdName.getKey());

            if (nameValue.isEmpty()) {
                errorBufferedWriter.write(idValue);
                errorBufferedWriter.newLine();
            } else if (!idValue.equals("ID")) {
                bufferedWriter.write(idValue + "," + nameValue + "," + priceValue);
                bufferedWriter.newLine();
            }
        }
    }
}
