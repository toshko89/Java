package Generics.GenericSwapMethodIntegers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SwapIntegers<Integer> newSwap = new SwapIntegers<>();

        while (n-- > 0) {
            Integer command = Integer.parseInt(scanner.nextLine());
            newSwap.data.add(command);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int index1 = indexes[0];
        int index2 = indexes[1];
        SwapIntegers.swap(newSwap.data, index1, index2);
        System.out.println(newSwap);
    }
}
