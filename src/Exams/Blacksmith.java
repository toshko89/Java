package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> carbonQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(carbonQueue::push);

        Map<String, Integer> swords = new TreeMap<>();

        int totalSwords = 0;

        while (!carbonQueue.isEmpty() && !steelQueue.isEmpty()) {
            int currentSteel = steelQueue.poll();
            int currentCarbon = carbonQueue.pop();
            int sum = currentSteel + currentCarbon;
            if (sum == 70) {
                if (!swords.containsKey("Gladius")) {
                    swords.put("Gladius", 1);
                } else {
                    int current = swords.get("Gladius");
                    current += 1;
                    swords.put("Gladius", current);
                }
                totalSwords++;
            } else if (sum == 80) {
                if (!swords.containsKey("Shamshir")) {
                    swords.put("Shamshir", 1);
                } else {
                    int current = swords.get("Shamshir");
                    current += 1;
                    swords.put("Shamshir", current);
                }
                totalSwords++;
            } else if (sum == 90) {
                if (!swords.containsKey("Katana")) {
                    swords.put("Katana", 1);
                } else {
                    int current = swords.get("Katana");
                    current += 1;
                    swords.put("Katana", current);
                }
                totalSwords++;
            } else if (sum == 110) {
                if (!swords.containsKey("Sabre")) {
                    swords.put("Sabre", 1);
                } else {
                    int current = swords.get("Sabre");
                    current += 1;
                    swords.put("Sabre", current);
                }
                totalSwords++;
            } else {
                int carbonPlus = currentCarbon + 5;
                carbonQueue.push(carbonPlus);
            }
        }

        if (swords.size() > 0) {
            System.out.println("You have forged" + " " + totalSwords + " " + "swords.");
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Steel left: ");
            for (Integer integer : steelQueue) {
                stringBuilder.append(integer).append(", ");
            }
            final int i = stringBuilder.lastIndexOf(",");
            stringBuilder.deleteCharAt(i);
            System.out.println(stringBuilder.toString().trim());
        }

        if (carbonQueue.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Carbon left: ");
            for (Integer integer : carbonQueue) {
                stringBuilder.append(integer).append(", ");
            }
            final int i = stringBuilder.lastIndexOf(",");
            stringBuilder.deleteCharAt(i);
            System.out.println(stringBuilder.toString().trim());
        }

        if (swords.size() > 0) {
            for (var value : swords.entrySet()) {
                System.out.println(value.getKey() + ": " + value.getValue());
            }
        }
    }
}
