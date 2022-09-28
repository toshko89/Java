package Functional_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer startNumber = Integer.parseInt(scanner.nextLine());
        List<Integer> sequence = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> results = new ArrayList<>();
        BiPredicate<Integer, Integer> isDivisible = (number, seq) -> number % seq == 0;

        boolean canAdd = true;

        for (int i = 1; i <= startNumber; i++) {
            for (int j = 0; j < sequence.size(); j++) {
                canAdd = isDivisible.test(i, sequence.get(j));
            }
            if (canAdd) {
                results.add(i);
            }

        }
        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i) + " ");
        }
    }
}
