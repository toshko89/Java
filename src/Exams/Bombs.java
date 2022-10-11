package Exams;

import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        String[] bombEffectStrings = scanner.nextLine().split(", ");
        for (String bombEffect : bombEffectStrings) {
            bombEffects.offer(Integer.parseInt(bombEffect));
        }

        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        String[] bombCasingStrings = scanner.nextLine().split(", ");
        for (String bombCasing : bombCasingStrings) {
            bombCasings.push(Integer.parseInt(bombCasing));
        }

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Cherry Bombs", 0);
        bombs.put("Datura Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        Map<Integer, String> bombValues = new HashMap<>();
        bombValues.put(60, "Cherry Bombs");
        bombValues.put(40, "Datura Bombs");
        bombValues.put(120, "Smoke Decoy Bombs");

        while (!bombCasings.isEmpty() && !bombEffects.isEmpty() && !isBombPouchFull(bombs)) {
            Integer bombCasing = bombCasings.pop();
            Integer bombEffect = bombEffects.poll();

            String bombCreated = bombValues.get(bombEffect + bombCasing);
            if (bombCreated == null) {
                bombCasing -= 5;
                bombCasings.push(bombCasing);
                bombEffects.offerFirst(bombEffect);
            } else {
                bombs.put(bombCreated, bombs.get(bombCreated) + 1);
            }
        }

        if (isBombPouchFull(bombs)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.println("Bomb Effects: " + printDeque(bombEffects));
        System.out.println("Bomb Casings: " + printDeque(bombCasings));

        for (String bombName : bombs.keySet()) {
            System.out.println(bombName + ": " + bombs.get(bombName));
        }
    }

    private static boolean isBombPouchFull(Map<String, Integer> bombs) {
        return bombs.values().stream().allMatch(v -> v.compareTo(3) > -1);
    }

    private static String printDeque(ArrayDeque<Integer> deque) {
        return deque.stream().map(a -> a.toString()).reduce((a, b) -> a + ", " + b).orElse("empty");
    }
}
