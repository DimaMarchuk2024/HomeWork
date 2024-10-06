package homework5.dz2Chat2;

import java.util.List;
import java.util.Objects;

public class Chat2 {

    private final String name;
    private final List<User> user;

    public Chat2(String name, List<User> user) {
        this.name = name;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat2 chat2 = (Chat2) o;
        return Objects.equals(name, chat2.name) && Objects.equals(user, chat2.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, user);
    }

    @Override
    public String toString() {
        return "Chat2{" +
                "name='" + name + '\'' +
                ", user=" + user +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<User> getUser() {
        return user;
    }
}
