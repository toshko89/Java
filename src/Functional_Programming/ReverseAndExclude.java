package Functional_Programming;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> data = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(data);
        data = data.stream().filter(num -> num % n != 0).collect(Collectors.toList());

        for (Integer num : data) {
            System.out.print(num + " ");
        }
    }
}
