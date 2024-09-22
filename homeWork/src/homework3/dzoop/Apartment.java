package homework3.dzoop;

import java.util.Arrays;
import java.util.Objects;

public class Apartment {

    private int apartmentNumber;

    private Room[] room;

    public Apartment(int apartmentNumber, Room[] room) {
        this.apartmentNumber = apartmentNumber;
        this.room = room;
    }

    public void print() {
        System.out.println("Квартира №" + getApartmentNumber() + ", количество комнат " + getRoom().length);
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public Room[] getRoom() {
        return room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return apartmentNumber == apartment.apartmentNumber && Arrays.equals(room, apartment.room);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(apartmentNumber);
        result = 31 * result + Arrays.hashCode(room);
        return result;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentNumber=" + apartmentNumber +
                ", room=" + Arrays.toString(room) +
                '}';
    }
}
