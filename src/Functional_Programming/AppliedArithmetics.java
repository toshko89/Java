package Functional_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            numbers = arithmetic(numbers, command);
            command = scanner.nextLine();
        }

        Arrays.stream(numbers).forEach(el -> System.out.print(el + " "));

    }

    private static int[] arithmetic(int[] numbers, String command) {
        switch (command) {
            case "add":
                return Arrays.stream(numbers).map(x -> x + 1).toArray();
            case "multiply":
                return Arrays.stream(numbers).map(x -> x * 2).toArray();
            case "subtract":
                return Arrays.stream(numbers).map(x -> x - 1).toArray();
            case "print":
                return numbers;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
