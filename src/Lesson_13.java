import java.util.*;

public class Lesson_13 {
    public static void main(String[] args){
        List<String> words = Arrays.asList(
                "Biora", "lateksil", "SaunaProtect", "Biora",
                "Gaiti", "Superlateksi", "Gaiti", "Nordica",
                "Satu", "Timantti", "Timantti", "Teksturedecor",
                "Katto", "Akvatop", "Gaiti", "Korsika");

        Set<String> unique = new HashSet<>(words);


        System.out.println("Уникальные слова:\n" + unique);
        System.out.println("Частота встречаемости слов:");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(words, key));
        }


        PhoneBook phonebook = new PhoneBook();

        phonebook.add("Ivuts", "1234567");
        phonebook.add("Kuptsov", "2345678");
        phonebook.add("Kuptsov", "3456789");
        phonebook.add("Rimkevich", "4567890");
        phonebook.add("Lalyko", "9876541");


        System.out.println(phonebook.get("Kuptsov"));
        System.out.println(phonebook.get("Ivuts"));
        System.out.println(phonebook.get("Borozna"));

        phonebook.add("Lalyko", "9876541");
    }
}
