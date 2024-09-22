package homework3.dzoop;

import java.util.Arrays;
import java.util.Objects;

public class Levels {
    private int levelNumber;
    private Apartment[] apartment;

    public Levels(int levelNumber, Apartment[] apartment) {
        this.levelNumber = levelNumber;
        this.apartment = apartment;
    }

    public void print() {
        System.out.println("Этаж " + getLevelNumber() + ", количество квартир " + getApartment().length);
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public Apartment[] getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Levels levels = (Levels) o;
        return levelNumber == levels.levelNumber && Arrays.equals(apartment, levels.apartment);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(levelNumber);
        result = 31 * result + Arrays.hashCode(apartment);
        return result;
    }

    @Override
    public String toString() {
        return "Levels{" +
                "levelNumber=" + levelNumber +
                ", apartment=" + Arrays.toString(apartment) +
                '}';
    }
}
