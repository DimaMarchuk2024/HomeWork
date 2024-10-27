package homework8;

import java.util.Random;

public final class RandomUtil {
    private static final int DEFAULT_RANDOM = 6;
    public static volatile Integer randomRed;
    public static volatile Integer randomWhite;

    private RandomUtil() {
    }

    public static Random randomRedCrystals = new Random();
    public static synchronized Integer getRandomRedCrystals() {
        randomRed = randomRedCrystals.nextInt(DEFAULT_RANDOM);
        return randomRed;
    }

    public static Random randomWhiteCrystals = new Random();
    public static synchronized Integer getRandomWhiteCrystals(Integer randomRed) {

        randomWhite = randomWhiteCrystals.nextInt(DEFAULT_RANDOM - randomRed);

        if ((randomRed == 0 && randomWhite == 0) || (randomRed == 0 && randomWhite == 1)) {
            return randomWhite = 2;
        } else if (randomRed == 1 && randomWhite == 0) {
            return randomWhite = 1;
        } else return randomWhite;
    }
}
