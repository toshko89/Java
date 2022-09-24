import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandsLength = Integer.parseInt(scanner.nextLine());
        int[] commands;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= commandsLength; i++) {
            commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int command = commands[0];
            int number = commands.length > 1 ? commands[1]: 0;

            switch (command) {
                case 1:
                    stack.push(number);
                    break;
                case 2:
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
            }
        }

    }
}
