package homework4.DZBancomat;

public class ATM {

    private Integer count10;
    private Integer count20;
    private Integer count50;

    private static final Integer DENOMINATION_BANKNOTE_10 = 10;
    private static final Integer DENOMINATION_BANKNOTE_20 = 20;
    private static final Integer DENOMINATION_BANKNOTE_50 = 50;

    public ATM(Integer count10, Integer count20, Integer count50) {
        this.count10 = count10;
        this.count20 = count20;
        this.count50 = count50;
    }

    public int sumAddMany() {
        return getCount10() * DENOMINATION_BANKNOTE_10 + getCount20() * DENOMINATION_BANKNOTE_20
                + getCount50() * DENOMINATION_BANKNOTE_50;
    }

    public boolean isSuccessfulOperation(Integer cashOut) {
        if (cashOut > (getCount50() * DENOMINATION_BANKNOTE_50 + getCount20() * DENOMINATION_BANKNOTE_20
                + getCount10() * DENOMINATION_BANKNOTE_10)) {
            return false;
        } else {
            cashWithdrawal(cashOut);
        }
        return true;
    }

    public void cashWithdrawal(Integer cashOut) {
        int balance1;
        int balance2;

        if ((cashOut - cashOut % DENOMINATION_BANKNOTE_50) / DENOMINATION_BANKNOTE_50 >= getCount50()) {
            System.out.println("Снято " + getCount50() + " купюр номиналом 50");
            balance1 = cashOut - getCount50() * DENOMINATION_BANKNOTE_50;
        } else {
            System.out.println("Снято " + (cashOut - cashOut % DENOMINATION_BANKNOTE_50) / DENOMINATION_BANKNOTE_50
                    + " купюр номиналом 50");
            balance1 = cashOut - (cashOut - cashOut % DENOMINATION_BANKNOTE_50);
        }

        if ((balance1 - balance1 % DENOMINATION_BANKNOTE_20) / DENOMINATION_BANKNOTE_20 >= getCount20()) {
            System.out.println("Снято " + getCount20() + " купюр номиналом 20");
            balance2 = balance1 - getCount20() * DENOMINATION_BANKNOTE_20;
        } else {
            System.out.println("Снято " + (balance1 - balance1 % DENOMINATION_BANKNOTE_20) / DENOMINATION_BANKNOTE_20
                    + " купюр номиналом 20");
            balance2 = balance1 - (balance1 - balance1 % 20);
        }

        System.out.println("Снято " + (balance2 - balance2 % DENOMINATION_BANKNOTE_10) / DENOMINATION_BANKNOTE_10
                + " купюр номиналом 10");
    }

    public int getCount10() {
        return count10;
    }

    public int getCount20() {
        return count20;
    }

    public int getCount50() {
        return count50;
    }

    public void setCount10(Integer count10) {
        this.count10 = count10;
    }

    public void setCount20(Integer count20) {
        this.count20 = count20;
    }

    public void setCount50(Integer count50) {
        this.count50 = count50;
    }
}
