import java.util.Arrays;
import java.util.Scanner;

public class Diagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int rows = 0; rows < n; rows++) {
            matrix[rows] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int sumPrimary = 0;
        int sumSecondary = 0;
        for (int i = 0; i < n; i++) {
            sumPrimary += matrix[i][i];
            sumSecondary += matrix[i][n - i - 1];
        }

        int diff = Math.abs(sumPrimary - sumSecondary);
        System.out.println(diff);
    }
}
