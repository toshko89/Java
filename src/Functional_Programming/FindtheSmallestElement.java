package Functional_Programming;

import javax.naming.PartialResultException;
import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindtheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallest = (arr) -> {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) <= min) {
                    min = arr.get(i);
                    index = i;
                }
            }
            return index;
        };

        Integer result = findSmallest.apply(input);
        System.out.println(result);
    }
}
