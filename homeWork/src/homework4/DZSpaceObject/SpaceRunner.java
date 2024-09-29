package homework4.DZSpaceObject;

/**
 * Создать иерархию классов, описывающих объекты в космосе.
 * Например, планета, спутник, звезда, астероид и т.д.
 * У каждого есть набор методов и характеристик-свойств, как общих (масса),
 * так и присущих только этому типу космического объекта.
 * Необходимо учесть следующее:
 * В иерархии должно быть минимум 10 классов/интерфейсов
 * Обязательно использовать наследование (достаточно 1-2 уровней)
 * Использовать полиморфизм и продемонстрировать переопределение методов в иерархии
 * Продемонстрировать добавление собственных методов в классах-наследниках (можно с помощью интерфейсов)
 * При разработке иерархии держать в уме принцип инкапсуляции, выбирать корректные имена классов, их полей и методов, пользоваться преимуществами полиморфизма
 * Отдавайте предпочтение интерфейсам, а не абстрактным классам
 * При переопределении методов обязательно использовать аннотацию @Override
 * Не создавать лишних классов в системе (полностью дублирующих или не содержащих назначения)
 * Каждый класс должен выполнять своё назначение
 * Для каждого не абстрактного класса переопределить метод toString() класса для представления информации о классах в строковой форме
 * Создать общие методы:
 * - Рассчитывающие диаметр космического объекта
 * - Сравнивающий массы 2 космических объектов (метод не статический!)
 * Создать утилитный класс* SpaceUtils со следующими статическими методами:
 * - Принимающий 2 космический объекта и определяющий силу гравитации между ними (можно придумать любую формула на основании расстоянии между объектами и т.д.)
 * - Принимающий космический объект и определяющий, является ли он звездой или нет
 * Создать класс SpaceRunner, где протестировать написанный функционал
 * В этом задании нет одного правильного решения, подойдите к нему творчески.
 * Утилитный класс* - это такой класс, который:
 * - помечен ключевым словом final, чтобы запретить наследоваться от него
 * - имеет private конструктор, чтобы нельзя было создать объект этого класса
 * - имеет только статические методы и константы
 */
public class SpaceRunner {

    public static void main(String[] args) {

        Planet planet = new Planet(1000, 100, 1500000, 30, 4);
        Satellite satellite = new Satellite(100, 25, 1_500_000, 45, 2, 2000);
        Asteroid asteroid = new Asteroid(20, 25, 5);
        Comet comet = new Comet(25, 500);
        Star star = new Star(5000, 3500, 500_000_000, 20);

        System.out.println("Диаметр планеты = " + planet.getDiameter());
        System.out.println("Скорость вращения планеты = " + planet.getSpeedRotation());
        System.out.println();
        System.out.println("Диаметр спутника планеты = " + satellite.getDiameter());
        System.out.println("Скорость вращения спутника планеты = " + satellite.getSpeedRotation());
        System.out.println();
        System.out.println("Диаметр астероида = " + asteroid.getDiameter());
        System.out.println("Возможность разрушить планету массой " + planet.getMass()
                + " при столкновении с астероидом массой " + asteroid.getMass() + " = " + asteroid.dangerDestructionPlanet(planet));
        System.out.println();
        System.out.println("Диаметр кометы = " + comet.getDiameter());
        System.out.println("Температура кометы = " + comet.calculateTemperatureComet());
        System.out.println();
        System.out.println("Диаметр звезды = " + star.getDiameter());
        System.out.println("Светимость звезды = " + star.getLuminosityStar());
        System.out.println();
        System.out.println("Сила притяжения между " + satellite + " и " + asteroid + " = "
                + SpaceUtils.forceOfGravitation(satellite, asteroid, 100_000));
        System.out.println();
        System.out.println("Объект " + planet + " является звездой = " + SpaceUtils.isStar(planet));
        System.out.println();
        System.out.println("Объект " + star + " является звездой = " + SpaceUtils.isStar(star));
    }
}
