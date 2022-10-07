package Exams;

import java.util.*;
import java.util.stream.Stream;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Double> milk = new ArrayDeque<>();
        Deque<Double> cacao = new ArrayDeque<>();
        Map<String, Integer> chocolates = new LinkedHashMap<>();

        String[] milkQuantity = scanner.nextLine().split(" ");
        for (int i = 0; i < milkQuantity.length; i++) {
            milk.offer(Double.parseDouble(milkQuantity[i]));
        }
        String[] cacaoQuantity = scanner.nextLine().split(" ");
        for (int i = 0; i < cacaoQuantity.length; i++) {
            cacao.push(Double.parseDouble(cacaoQuantity[i]));
        }

        while (!milk.isEmpty() && !cacao.isEmpty()) {
            Double milkValue = milk.poll();
            Double cacaoValue = cacao.pop();
            Double percentage = Math.ceil((cacaoValue / (milkValue + cacaoValue)) * 100);
            if (percentage == 30) {
                if (!chocolates.containsKey("Milk Chocolate")) {
                    chocolates.put("Milk Chocolate", 1);
                } else {
                    int allChocolates = chocolates.get("Milk Chocolate");
                    allChocolates += 1;
                    chocolates.put("Milk Chocolate", allChocolates);
                }
            } else if (percentage == 50) {
                if (!chocolates.containsKey("Dark Chocolate")) {
                    chocolates.put("Dark Chocolate", 1);
                } else {
                    int allChocolates = chocolates.get("Dark Chocolate");
                    allChocolates += 1;
                    chocolates.put("Dark Chocolate", allChocolates);
                }
            } else if (percentage == 100) {
                if (!chocolates.containsKey("Baking Chocolate")) {
                    chocolates.put("Baking Chocolate", 1);
                } else {
                    int allChocolates = chocolates.get("Baking Chocolate");
                    allChocolates += 1;
                    chocolates.put("Baking Chocolate", allChocolates);
                }
            } else {
                milkValue += 10;
                milk.offer(milkValue);
            }
        }

        if (chocolates.size() >= 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            chocolates.forEach((key, value) -> System.out.println("# " + key + " --> " + value));
        }else{
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            chocolates.forEach((key, value) -> System.out.println("# " + key + " --> " + value));
        }
    }
}
