package Generics.GenericCountMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> allInputs = new Box<>();

        while (n-- > 0) {
            Double input = Double.parseDouble(scanner.nextLine());
            allInputs.values.add(input);
        }

        double search = Double.parseDouble(scanner.nextLine());
        int result = allInputs.searchElements(allInputs.values, search);

        System.out.println(result);

    }
}
