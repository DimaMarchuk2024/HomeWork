package homework5.dz1Chat;
/**
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */

import java.util.*;

public class ChatTest {
    public static void main(String[] args) {

        Chat soccer = new Chat("Soccer", 1600);
        Chat music = new Chat("Music", 1600);
        Chat space = new Chat("Space", 235);
        Chat history = new Chat("History", 956);
        Chat dance = new Chat("Dance", 1050);
        Chat auto = new Chat("Auto", 1780);

        List<Chat> chatList = new ArrayList<>();
        chatList.add(soccer);
        chatList.add(music);
        chatList.add(space);
        chatList.add(history);
        chatList.add(dance);
        chatList.add(auto);

        Collections.sort(chatList);
        System.out.println("Исходный список чатов с сортировкой по названию по умолчанию: " + chatList);

        System.out.println();

        List<Chat> newChatList = deleteChatLess1000Users(chatList);
        System.out.println("Список чатов после удаления чатов с менее 1000 пользователями: " + newChatList);

        System.out.println();

        chatList.sort(new DescendingNumberUsersOrNameComparator());
        System.out.println("Отсортированный новый список чатов по убыванию количества пользователей," +
                " а если это количество совпадает, то по названию в алфавитном порядке: " + newChatList);
    }

    private static List<Chat> deleteChatLess1000Users(List<Chat> chatList) {
        Iterator<Chat> iterator = chatList.iterator();
        while (iterator.hasNext()) {
            Chat chat = iterator.next();
            if (chat.getNumberUsers() < 1000) {
                iterator.remove();
            }
        }
        return chatList;
    }

    public static class DescendingNumberUsersOrNameComparator implements Comparator<Chat> {
        @Override
        public int compare(Chat o1, Chat o2) {
            if (o1.getNumberUsers() - o2.getNumberUsers() == 0) {
                return o1.getName().compareTo(o2.getName());
            } else return o2.getNumberUsers() - o1.getNumberUsers();
        }
    }
}
