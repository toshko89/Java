package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> freshness = new ArrayDeque<>();

        int[] secondInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i : secondInput) {
            freshness.offer(i);
        }

        int[] firstInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int i : firstInput) {
            ingredients.push(i);
        }

        Map<String, Integer> results = new TreeMap<>();

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            int ingredient = ingredients.peek();
            int fresh = freshness.peek();
//            int ingredient = ingredients.pop();
//            int fresh = freshness.poll();
            int sum = ingredient * fresh;

            if (fresh == 0) {
                freshness.poll();
                continue;
            }

            if (sum == 150) {
                if (!results.containsKey("Pear Sour")) {
                    results.put("Pear Sour", 1);
                } else {
                    int currentValue = results.get("Pear Sour");
                    currentValue += 1;
                    results.put("Pear Sour", currentValue);
                }
                ingredients.pop();
                freshness.poll();
            } else if (sum == 250) {
                if (!results.containsKey("The Harvest")) {
                    results.put("The Harvest", 1);
                } else {
                    int currentValue = results.get("The Harvest");
                    currentValue += 1;
                    results.put("The Harvest", currentValue);
                }
                ingredients.pop();
                freshness.poll();
            } else if (sum == 300) {
                if (!results.containsKey("Apple Hinny")) {
                    results.put("Apple Hinny", 1);
                } else {
                    int currentValue = results.get("Apple Hinny");
                    currentValue += 1;
                    results.put("Apple Hinny", currentValue);
                }
                ingredients.pop();
                freshness.poll();
            } else if (sum == 400) {
                if (!results.containsKey("High Fashion")) {
                    results.put("High Fashion", 1);
                } else {
                    int currentValue = results.get("High Fashion");
                    currentValue += 1;
                    results.put("High Fashion", currentValue);
                }
                ingredients.pop();
                freshness.poll();
            } else {
                ingredients.pop();
                freshness.poll();
                int freshValue = fresh + 5;
                freshness.offer(freshValue);
            }
        }

        if (results.size() >= 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (freshness.size() > 0) {
            int sum = 0;
            for (Integer integer : freshness) {
                sum += integer;
            }
            System.out.println("Ingredients left: " + sum);
        }

        if (results.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (var entry : results.entrySet()) {
                stringBuilder.append(" # ").append(entry.getKey()).append(" --> ")
                        .append(entry.getValue()).append(System.lineSeparator());
            }

            System.out.print(stringBuilder.toString().trim());
        }
    }
}
