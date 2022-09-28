package Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String criteria = tokens[1];
            String string = tokens[2];
            Predicate<String> predicate = getPredicate(criteria, string);
            if (command.equals("Remove")) {
                names.removeIf(predicate);
            } else if (command.equals("Double")) {
                List<String> toAdd = names.stream().filter(predicate).collect(Collectors.toList());
                names.addAll(toAdd);
            }
            input = scanner.nextLine();
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(names.stream().sorted().collect(Collectors.joining(", ")) + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String criteria, String string) {
        Predicate<String> predicate = null;
        switch (criteria) {
            case "StartsWith":
                predicate = s -> s.startsWith(string);
                break;
            case "EndsWith":
                predicate = s -> s.endsWith(string);
                break;
            case "Length":
                predicate = s -> s.length() == Integer.parseInt(string);
                break;
        }
        return predicate;
    }
}
