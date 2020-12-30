import java.util.*;
import java.util.function.Function;

public class Main {

    private static List<String> vocabulary = new ArrayList<>();

    public static void main(String[] args) {
        String aborigenMsg = "Представьте, что у вас есть, исходный текст сообщения местного жителя";

        // Использую чистую функцию - без побочных эффектов и детерминированную (результат зависит только от входящего параметра,
        // при одинаковом параметре дает всегда один и тот же результат)
        Function<String, ArrayList<String>> converter = x -> new ArrayList<String>(Arrays.asList(x.split("[\\s,;]+")));
        List<String> list = converter.apply(aborigenMsg);

        // Использую Stream API - это монада. Т.е. последовательность связанных между собой операций без хранения состояния,
        // но в этом примере есть побочный эффект - вывод значений через forEach().
        list.stream().map(String::toLowerCase).distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }
}