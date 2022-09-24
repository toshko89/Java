import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("");
        TreeMap<String, Integer> wordsSet = new TreeMap<>();

        for (String word : words) {
            if (!wordsSet.containsKey(word)) {
                wordsSet.put(word, 1);
                continue;
            }
            int value = wordsSet.get(word);
            wordsSet.put(word, value + 1);
        }

        for (Map.Entry<String, Integer> entry : wordsSet.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s%n");
        }

    }
}
