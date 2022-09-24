import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack= new ArrayDeque<>();
        String[] elements = scanner.nextLine().split("");

        int arrMiddle = elements.length / 2;

        if (elements.length % 2 == 1) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < arrMiddle; i++) {
            queue.offer(elements[i]);
        }

        for (int i = arrMiddle; i < elements.length; i++) {
            stack.push(elements[i]);
        }

        boolean isBalanced = true;

        while (queue.size() > 0) {
            String stackChar = queue.poll();
            String queueChar = stack.pop();
            if (stackChar.equals("{") && !queueChar.equals("}")) {
                isBalanced = false;
            } else if (stackChar.equals("(") && !queueChar.equals(")")) {
                isBalanced = false;
            } else if (stackChar.equals("[") && !queueChar.equals("]")) {
                isBalanced = false;
            }

        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
