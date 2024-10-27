package homework8;

import java.util.concurrent.atomic.AtomicInteger;

public class WizardAirThread implements Runnable {

    private final AtomicInteger red;
    private final AtomicInteger white;
    private Integer sumRedAir = 0;
    private Integer sumWhiteAir = 0;
    private Integer countDay = 1;
    private Integer randomRed = 0;

    public WizardAirThread(AtomicInteger red, AtomicInteger white) {
        this.red = red;
        this.white = white;
    }

    @Override
    public void run() {

        while (true) {
            System.out.println("День " + countDay++ + " вылета магов воздуха");
            int nowCountGrowRed;
            int nowCountGrowWhite;

            if (sumRedAir < 500) {
                synchronized (red) {
                    nowCountGrowRed = red.get();
                    if (nowCountGrowRed > 0) {
                        randomRed = RandomUtil.getRandomRedCrystals();
                        loadingRedCrystalsForWizardsAir(nowCountGrowRed);
                    } else {
                        System.err.println("Для магов воздуха красных кристаллов нет для загрузки в ракету");
                        try {
                            red.wait(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                randomRed = 0;
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (sumWhiteAir < 500) {
                synchronized (white) {
                    nowCountGrowWhite = white.get();
                    if (nowCountGrowWhite > 0) {
                        int randomWhite = RandomUtil.getRandomWhiteCrystals(randomRed);
                        loadingWhiteCrystalsForWizardsAir(nowCountGrowWhite, randomWhite);
                    } else {
                        System.out.println("Для магов воздуха белых кристаллов нет для загрузки в ракету");
                        try {
                            white.wait(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            else {
                if (randomRed < 2) {
                    randomRed = 2;
                }
            }

        if (sumRedAir >= 500 && sumWhiteAir >= 500) {
            System.out.println("!!!!Победа магов воздуха!!!!! Собрано " + sumRedAir + " красных" +
                    " и " + sumWhiteAir + " белых кристаллов");
            break;
        }
    }
}

private void loadingWhiteCrystalsForWizardsAir(int nowCountGrowWhite, int randomWhite) {
    if (nowCountGrowWhite < randomWhite) {
        white.addAndGet(-nowCountGrowWhite);
        sumWhiteAir += nowCountGrowWhite;
        System.out.println("Маги воздуха погрузили " + nowCountGrowWhite + " белых кристаллов. Всего у магов " + sumWhiteAir + " белых кристаллов");

        try {
            white.wait(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } else {
        white.addAndGet(-randomWhite);
        sumWhiteAir += randomWhite;
        System.out.println("Маги воздуха погрузили " + randomWhite + " белых кристаллов. Всего у магов " + sumWhiteAir + " белых кристаллов");

        try {
            white.wait(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

private void loadingRedCrystalsForWizardsAir(int nowCountGrowRed) {
    if (nowCountGrowRed < randomRed) {
        red.addAndGet(-nowCountGrowRed);
        sumRedAir += nowCountGrowRed;
        System.err.println("Маги воздуха погрузили " + nowCountGrowRed + " красных кристаллов. " +
                "Всего у магов " + sumRedAir + " красных кристаллов");
        try {
            red.wait(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } else {
        red.addAndGet(-randomRed);
        sumRedAir += randomRed;
        System.err.println("Маги воздуха погрузили " + randomRed + " красных кристаллов. " +
                "Всего у магов " + sumRedAir + " красных кристаллов");
        try {
            red.wait(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

}

