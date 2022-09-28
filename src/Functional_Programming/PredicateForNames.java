package Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Predicate<String> namelength = s -> s.length() <= n;
        List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                .filter(namelength).collect(Collectors.toList());

        for (String s : input) {
            System.out.println(s);
        }

    }
}
