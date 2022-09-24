import java.util.*;
import java.util.stream.IntStream;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack,input);

        while(stack.size()> 1){
            int first = Integer.valueOf(stack.pop());
            String operation = stack.pop();
            int second = Integer.valueOf(stack.pop());

            switch (operation){
                case "+": stack.push(String.valueOf(first+second));
                break;
                case "-": stack.push(String.valueOf(first-second));
                break;
            }
        }

        System.out.print(stack.pop());
    }
}
