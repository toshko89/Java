package Generics.GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            GenericBox<Integer> input = new GenericBox<>(Integer.parseInt(scanner.nextLine()));
            System.out.println(input);
        }
    }
}
