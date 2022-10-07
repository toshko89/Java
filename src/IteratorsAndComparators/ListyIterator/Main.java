package IteratorsAndComparators.ListyIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ListyIterator<String> myListy = new ListyIterator<>();
        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            try {
                if (command.equals("Create")) {
                    for(int i = 1; i < commands.length; i++) {
                        myListy.create(commands[i]);
                    }
                } else if (command.equals("Move")) {
                    System.out.println(myListy.move());
                } else if (command.equals("Print")) {
                    myListy.print();
                } else if (command.equals("HasNext")) {
                    System.out.println(myListy.hasNext());
                }
            } catch (Exception e) {
                System.out.println("Invalid Operation!");
                break;
            }

            input = scanner.nextLine();
        }

    }
}


