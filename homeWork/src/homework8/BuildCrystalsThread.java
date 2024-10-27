package homework8;

import java.util.concurrent.atomic.AtomicInteger;

public class BuildCrystalsThread implements Runnable {

    private final AtomicInteger red;
    private final AtomicInteger white;
    private Integer countDay = 1;

    public BuildCrystalsThread(AtomicInteger red, AtomicInteger white) {
        this.red = red;
        this.white = white;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("День " + countDay++);
            int randomRed;
            synchronized (red) {
                randomRed = RandomUtil.getRandomRedCrystals();
                int sumRed = red.addAndGet(randomRed);
                System.err.println("Образовалось " + randomRed + " красных кристаллов. " +
                        "Всего " + sumRed + " красных кристаллов");
                try {
                    red.wait(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (white) {
                int randomWhite = RandomUtil.getRandomWhiteCrystals(randomRed);
                int sumWhite = white.addAndGet(randomWhite);
                System.out.println("Образовалось " + randomWhite + " белых кристаллов. " +
                        "Всего " + sumWhite + " белых кристаллов");
                try {
                    white.wait(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
