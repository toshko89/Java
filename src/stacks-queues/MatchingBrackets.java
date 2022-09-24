import java.util.*;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String originalString = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        List<Integer> intArr = new ArrayList<>();

        intArr.add(2);
        intArr.add(3);
        

        System.out.println(intArr.stream().filter(x -> x == 2));

    }

}
