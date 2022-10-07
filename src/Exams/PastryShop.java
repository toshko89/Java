package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(ingredientStack::push);

        Map<String, Integer> food = new LinkedHashMap<>();
        food.put("Biscuit", 0);
        food.put("Cake", 0);
        food.put("Pie", 0);
        food.put("Pastry", 0);

        while (!liquidQueue.isEmpty() && !ingredientStack.isEmpty()) {
            int currentLiqiud = liquidQueue.poll();
            int currentIngredient = ingredientStack.pop();
            int sum = currentLiqiud + currentIngredient;
            if (sum == 25) {
                int value = food.get("Biscuit");
                value++;
                food.put("Biscuit", value);
            } else if (sum == 50) {
                int value = food.get("Cake");
                value++;
                food.put("Cake", value);
            } else if (sum == 75) {
                int value = food.get("Pastry");
                value++;
                food.put("Pastry", value);
            } else if (sum == 100) {
                int value = food.get("Pie");
                value++;
                food.put("Pie", value);
            } else {
                currentIngredient += 3;
                ingredientStack.push(currentIngredient);
            }
        }


        boolean containsAll = true;

        for (Integer value : food.values()) {
            if (value == 0) {
                containsAll = false;
                break;
            }
        }

        if (containsAll) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidQueue.size() == 0) {
            System.out.println("Liquids left: none");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Liquids left: ");
            for (Integer integer : liquidQueue) {
                stringBuilder.append(integer).append(", ");
            }
            final int i = stringBuilder.lastIndexOf(",");
            stringBuilder.deleteCharAt(i);
            System.out.println(stringBuilder.toString().trim());
        }

        if (ingredientStack.size() == 0) {
            System.out.println("Ingredients left: none");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ingredients left: ");
            for (Integer integer : ingredientStack) {
                stringBuilder.append(integer).append(", ");
            }
            final int i = stringBuilder.lastIndexOf(",");
            stringBuilder.deleteCharAt(i);
            System.out.println(stringBuilder.toString().trim());
        }

        for (var value : food.entrySet()) {
            System.out.println(value.getKey() + ": " + value.getValue());
        }

    }
}
