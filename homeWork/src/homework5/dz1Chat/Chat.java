package homework5.dz1Chat;

import java.util.Objects;

public class Chat implements Comparable<Chat> {

    private final String name;
    private final Integer numberUsers;

    public Chat(String name, Integer numberUsers) {
        this.name = name;
        this.numberUsers = numberUsers;
    }

    @Override
    public int compareTo(Chat o) {
        return getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(name, chat.name) && Objects.equals(numberUsers, chat.numberUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberUsers);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", numberUsers=" + numberUsers +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getNumberUsers() {
        return numberUsers;
    }
}
