import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Алексеев", "403-712-030");
        addContact(phoneBook, "Смирнов", "555-226-123");
        addContact(phoneBook, "Кузнецов", "855-236-156");
        addContact(phoneBook, "Волков", "865-348-874");
        addContact(phoneBook, "Алексеев", "354-954-878");
        addContact(phoneBook, "Орлов", "654-985-895");
        addContact(phoneBook, "Николаев", "354-546-546");

        printPhoneBook(phoneBook);
    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {

        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    private static void printPhoneBook(Map<String, List<String>> phoneBook) {

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        for (int i = entries.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = entries.get(i);
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        }
    }
}