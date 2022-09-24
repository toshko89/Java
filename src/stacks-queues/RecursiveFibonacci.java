import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[] memo = new long[n + 1];
        System.out.println(fib(n, memo));
    }
    private static long fib(int n, long[] memo) {
        if (n < 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
    }

}
