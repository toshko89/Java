import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> cardPowers = new HashMap<>() {{
            put("J", 11);
            put("Q", 12);
            put("K", 13);
            put("A", 14);
        }};
        HashMap<String, Integer> cardTypes = new HashMap<>() {{
            put("S", 4);
            put("H", 3);
            put("D", 2);
            put("C", 1);
        }};
        TreeMap<String, Integer> results = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] data = input.split(": ");
            String name = data[0];
            String[] cards = data[1].split(", ");
            String[] uniquecards = Arrays.stream(cards).distinct().toArray(String[]::new);
            for (int i = 0; i < uniquecards.length; i++) {
                String power = cards[i].substring(0, cards[i].length() - 1);
                String type = cards[i].substring(cards[i].length() - 1);
                if (power.matches("[0-9]+")) {
                    if (!results.containsKey(name)) {
                        int points = Integer.parseInt(power) * cardTypes.get(type);
                        results.put(name, points);
                        continue;
                    }
                    int points = results.get(name);
                    points += Integer.parseInt(power) * cardTypes.get(type);
                    results.put(name, points);
                } else {
                    if (!results.containsKey(name)) {
                        int cardPower = cardPowers.get(power);
                        int cardType = cardTypes.get(type);
                        results.put(name, (cardPower * cardType));
                        continue;
                    }
                    int playerPoints = results.get(name);
                    int cardPower = cardPowers.get(power);
                    int cardType = cardTypes.get(type);
                    results.put(name, playerPoints + (cardPower * cardType));
                }
            }
            input = scanner.nextLine();
        }

        results.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

    }

}
