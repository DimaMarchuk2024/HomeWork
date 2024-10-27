package homework8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Существует две постоянно соревнующиеся расы: маги огня и маги воздуха.
 * Их задача - как можно быстрее набрать 500 красных и 500 белых кристаллов.
 * <p>
 * Кристаллы растут на другой планете с рандомной скоростью от 2 до 5 рандомных кристаллов в сутки
 * (может быть 1 красный и 2 белых, а может и вовсе 4 кристалла красного цвета).
 * <p>
 * Маги огня и маги воздуха отправляют раз в сутки по ракете за добычей кристаллов.
 * Каждая ракета может погрузить на борт от 2 до 5 рандомных кристаллов.
 * Если кристаллов нет - ракета улетает пустой.
 * <p>
 * Написать программу, которая симулирует процесс заполнения кристаллов у магов огня и воздуха.
 * Для симуляции принять, что и кристаллы создаются, и ракеты прилетают в одно и тоже время - полночь.
 * <p>
 * Соревнование заканчивается, когда какая-то раса соберет необходимые кристаллы.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger red = new AtomicInteger();
        AtomicInteger white = new AtomicInteger();

        BuildCrystalsThread buildCrystals = new BuildCrystalsThread(red, white);
        WizardFireThread wizardFire = new WizardFireThread(red, white);
        WizardAirThread wizardAir = new WizardAirThread(red, white);

        Thread buildThread = new Thread(buildCrystals);
        Thread fireThread = new Thread(wizardFire);
        Thread airThread = new Thread(wizardAir);

        buildThread.start();
        fireThread.start();
        airThread.start();

        buildThread.join();
        fireThread.join();
        airThread.join();

    }
}
