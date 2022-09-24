import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] inputValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int elementsToPush = elements[0];
        int popFromStack = elements[1];
        int search = elements[2];

        for (int i = 0; i < inputValues.length; i++) {
            stack.add(inputValues[i]);
        }

        for (int i = 0; i < popFromStack; i++) {
            stack.poll();
        }

        if (stack.contains(search)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }

    }
}
