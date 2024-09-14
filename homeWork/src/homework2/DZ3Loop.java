package homework2;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer
 * с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 *
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 *
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */
public class DZ3Loop {
    public static void main(String[] args) {

        int startSalary = 600;
        int highSalary = 400;
        int costFoodFun = 300;
        int percentBroker = 10;
        int percentProfit = 2;
        int month = 2;
        int year = 3;

        double result = getSumSalary(startSalary, highSalary, month, year);
        System.out.println("Суммарная зарплата за " + year + " года и " + month + " месяца" + " = " + result);

        double yourAccount = getYourAccount(result, percentBroker, costFoodFun, year, month);
        System.out.println("Средств на счету Вани с учетом всех расходов за " + year + " года и "
                + month + " месяца" + " = " + yourAccount);

        double brokerAccount = getBrokerAccount(result, percentBroker, percentProfit);
        System.out.println("Средств на счету брокера за " + year + " года и " + month + " месяца с доходностью "
                + percentProfit + "% в месяц = " + brokerAccount);
    }

    private static double getSumSalary(int startSalary, int highSalary, int month, int year) {
        double resultYear = 0;
        double resultMonth = 0;
        int countHalfYear = year * 2;

        for (int i = 0; i < countHalfYear; i++) {
            for (int j = 0; j < countHalfYear; j++) {
                resultYear = resultYear + startSalary + highSalary * i;
            }
        }
        for (int i = 0; i < month; i++) {
            resultMonth = resultMonth + startSalary + highSalary * countHalfYear;
        }
        return resultYear + resultMonth;
    }

    private static double getYourAccount(double result, int percentBroker, int costFoodFun, int year, int month) {
        double costBroker = result * percentBroker / 100;
        return (result - (costFoodFun * (year * 12 + month)) - costBroker);
    }

    private static double getBrokerAccount(double result, int percentBroker, int percentProfit) {
        double costBroker = result * percentBroker / 100;
        return (costBroker * (100 + percentProfit) / 100);
    }
}
