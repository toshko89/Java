package Functional_Programming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class CombinatorFunction {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(1, 2, 3, 4));
        int a = fold(0, numbers, (x, y) -> x + y);
        int b = fold(1, numbers, (x, y) -> x * y);
        int c = fold(1, numbers, (x, y) -> x * x + y * y);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    static Integer fold(Integer identity, List<Integer> numbers, BiFunction<Integer, Integer, Integer> combinator) {
        int result = identity;
        for (Integer num : numbers) {
            result = combinator.apply(result, num);
        }

        return result;
    }

}


