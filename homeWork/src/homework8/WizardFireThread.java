package homework8;

import java.util.concurrent.atomic.AtomicInteger;

public class WizardFireThread implements Runnable {

    private final AtomicInteger red;
    private final AtomicInteger white;
    private Integer sumRedFire = 0;
    private Integer sumWhiteFire = 0;
    private Integer countDay = 1;
    private Integer randomRed = 0;

    public WizardFireThread(AtomicInteger red, AtomicInteger white) {
        this.red = red;
        this.white = white;
    }

    @Override
    public void run() {

        while (true) {
            System.out.println("День " + countDay++ + " вылета магов огня");
            int nowCountGrowRed;
            int nowCountGrowWhite;

            if (sumRedFire < 500) {
                synchronized (red) {
                    nowCountGrowRed = red.get();
                    if (nowCountGrowRed > 0) {
                        randomRed = RandomUtil.getRandomRedCrystals();
                        loadingRedCrystalsForWizardsFire(nowCountGrowRed);
                    } else {
                        System.err.println("Для магов огня красных кристаллов нет для загрузки в ракету");
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

            if (sumWhiteFire < 500) {
                synchronized (white) {
                    nowCountGrowWhite = white.get();
                    if (nowCountGrowWhite > 0) {
                        int randomWhite = RandomUtil.getRandomWhiteCrystals(randomRed);
                        loadingWhiteCrystalsForWizardsFire(nowCountGrowWhite, randomWhite);
                    } else {
                        System.out.println("Для магов огня белых кристаллов нет для загрузки в ракету");
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

            if (sumRedFire >= 500 && sumWhiteFire >= 500) {
                System.out.println("!!!!Победа магов огня!!!!! Собрано " + sumRedFire + " красных" +
                        " и " + sumWhiteFire + " белых кристаллов");
                break;
            }
        }
    }

    private void loadingWhiteCrystalsForWizardsFire(int nowCountGrowWhite, int randomWhite) {
        if (nowCountGrowWhite < randomWhite) {
            white.addAndGet(-nowCountGrowWhite);
            sumWhiteFire += nowCountGrowWhite;
            System.out.println("Маги огня погрузили " + nowCountGrowWhite + " белых кристаллов. Всего у магов " + sumWhiteFire + " белых кристаллов");

            try {
                white.wait(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            white.addAndGet(-randomWhite);
            sumWhiteFire += randomWhite;
            System.out.println("Маги огня погрузили " + randomWhite + " белых кристаллов. Всего у магов " + sumWhiteFire + " белых кристаллов");

            try {
                white.wait(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadingRedCrystalsForWizardsFire(int nowCountGrowRed) {
        if (nowCountGrowRed < randomRed) {
            red.addAndGet(-nowCountGrowRed);
            sumRedFire += nowCountGrowRed;
            System.err.println("Маги огня погрузили " + nowCountGrowRed + " красных кристаллов. Всего у магов " + sumRedFire + " красных кристаллов");

            try {
                red.wait(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            red.addAndGet(-randomRed);
            sumRedFire += randomRed;
            System.err.println("Маги огня погрузили " + randomRed + " красных кристаллов. Всего у магов " + sumRedFire + " красных кристаллов");

            try {
                red.wait(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



