import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLength = Integer.parseInt(scanner.nextLine());
        Set<String> resultSet = new TreeSet<>();
        String[] input ;
        while (inputLength-- > 0){
            input = scanner.nextLine().split(" ");
            Arrays.stream(input).forEach(el-> resultSet.add(el));
        }

        resultSet.forEach(el->System.out.print(el+ " "));

    }
}
