package homework3.dzoop;

import java.util.Objects;

public class Room {

    private boolean passageRoom;

    public Room(boolean passageRoom) {
        this.passageRoom = passageRoom;
    }

    public boolean isPassageRoom() {
        return passageRoom;
    }

    public void print() {
        if (isPassageRoom()) {
            System.out.println("Комната проходная");
        } else  System.out.println("Комната не проходная");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return passageRoom == room.passageRoom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passageRoom);
    }

    @Override
    public String toString() {
        return "Room{" +
                "passageRoom=" + passageRoom +
                '}';
    }
}
