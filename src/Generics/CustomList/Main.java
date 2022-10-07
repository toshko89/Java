package Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        MyList<String> newList = new MyList<>();

        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            if (command.equals("Add")){
                String element = commands[1];
                newList.add(element);
            } else if (command.equals("Remove")) {
                int index = Integer.parseInt(commands[1]);
                newList.remove(index);
            } else if (command.equals("Contains")) {
                String element = commands[1];
                System.out.println(newList.contains(element));
            } else if (command.equals("Swap")) {
                int index1 = Integer.parseInt(commands[1]);
                int index2 = Integer.parseInt(commands[2]);
                newList.swap(index1,index2);
            } else if (command.equals("Greater")) {
                String element = commands[1];
                System.out.println(newList.countGreaterThan(element));
            } else if (command.equals("Max")) {
                System.out.println(newList.getMax());
            }else if (command.equals("Min")){
                System.out.println(newList.getMin());
            } else if (command.equals("Print")) {
                newList.print();
            } else if (command.equals("Sort")) {
                Sorter.sort(newList);
            }

            input = scanner.nextLine();
        }
    }
}
