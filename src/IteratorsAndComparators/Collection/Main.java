package IteratorsAndComparators.Collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator listyIterator = new ListyIterator();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Create":
                    for (int i = 1; i < tokens.length; i++) {
                        listyIterator.create(tokens[i]);
                    }
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
