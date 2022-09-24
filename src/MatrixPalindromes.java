import java.util.Arrays;
import java.util.Scanner;

public class MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[input[0]][input[1]];

        for (int rows = 0; rows < input[0]; rows++) {

            for (int cols = 0; cols < input[1]; cols++) {
                char outside = (char) ('a' + rows);
                char middle = (char) (outside + cols);
                matrix[rows][cols] = String.valueOf(outside) + middle + outside;
            }
        }

        for (int rows = 0; rows < input[0]; rows++) {

            for (int cols = 0; cols < input[1]; cols++) {
               System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }
}
