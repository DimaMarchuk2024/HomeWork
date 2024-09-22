package homework3.dzoop;

import java.util.Arrays;
import java.util.Objects;

public class Home {

    private int homeNumber;
    private Levels[] level;

    public Home(int homeNumber, Levels[] levels) {
        this.homeNumber = homeNumber;
        this.level = levels;
    }

    public void print() {
        System.out.println("Дом №" + getHomeNumber() + ", количество этажей " + getLevel().length);
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public Levels[] getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return homeNumber == home.homeNumber && Arrays.equals(level, home.level);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(homeNumber);
        result = 31 * result + Arrays.hashCode(level);
        return result;
    }

    @Override
    public String toString() {
        return "Home{" +
                "homeNumber=" + homeNumber +
                ", level=" + Arrays.toString(level) +
                '}';
    }
}
