package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int life = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];

        int[] playerPosition = null;
        int[] helenPosition = null;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            matrix[row] = input;
            for (int col = 0; col < size; col++) {
                if (input[col].equals("P")) {
                    playerPosition = new int[]{row, col};
                } else if (input[col].equals("H")) {
                    helenPosition = new int[]{row, col};
                }
            }
        }

        boolean hellenMissing = true;
        boolean parisIsDead = false;

        while (hellenMissing && !parisIsDead) {
            String[] commands = scanner.nextLine().split(" ");
            String direction = commands[0];
            int[] spartan = new int[2];
            spartan[0] = Integer.parseInt(commands[1]);
            spartan[1] = Integer.parseInt(commands[2]);
            switch (direction) {
                case "up":
                    life--;
                    matrix[spartan[0]][spartan[1]] = "S";
                    if (canMove(playerPosition[0] - 1, size)) {
                        matrix[playerPosition[0]][playerPosition[1]] = "-";
                        playerPosition[0]--;
                    }
                    if (Arrays.equals(playerPosition, spartan)) {
                        life -= 2;
                        matrix[spartan[0]][spartan[1]] = "-";
                        if (life <= 0) {
                            System.out.printf("Paris died at %d;%d.%n", playerPosition[0], playerPosition[1]);
                            matrix[playerPosition[0]][playerPosition[1]] = "X";
                            parisIsDead = true;
                            break;
                        }
                    }
                    if (life <= 0) {
                        System.out.printf("Paris died at %d;%d.%n", playerPosition[0], playerPosition[1]);
                        matrix[playerPosition[0]][playerPosition[1]] = "X";
                        parisIsDead = true;
                        break;
                    }
                    if (Arrays.equals(playerPosition, helenPosition)) {
                        System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", life);
                        matrix[playerPosition[0]][playerPosition[1]] = "-";
                        hellenMissing = false;
                        break;
                    }
                    break;
                case "down":
                    life--;
                    matrix[spartan[0]][spartan[1]] = "S";
                    if (canMove(playerPosition[0] + 1, size)) {
                        matrix[playerPosition[0]][playerPosition[1]] = "-";
                        playerPosition[0]++;
                    }
                    if (Arrays.equals(playerPosition, spartan)) {
                        life -= 2;
                        matrix[spartan[0]][spartan[1]] = "-";
                        if (life <= 0) {
                            System.out.printf("Paris died at %d;%d.%n", playerPosition[0], playerPosition[1]);
                            matrix[playerPosition[0]][playerPosition[1]] = "X";
                            parisIsDead = true;
                            break;
                        }
                    }
                    if (life <= 0) {
                        System.out.printf("Paris died at %d;%d.%n", playerPosition[0], playerPosition[1]);
                        matrix[playerPosition[0]][playerPosition[1]] = "X";
                        parisIsDead = true;
                        break;
                    }
                    if (Arrays.equals(playerPosition, helenPosition)) {
                        System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", life);
                        matrix[playerPosition[0]][playerPosition[1]] = "-";
                        hellenMissing = false;
                        break;
                    }
                    break;
                case "left":
                    life--;
                    matrix[spartan[0]][spartan[1]] = "S";
                    if (canMove(playerPosition[1] - 1, size)) {
                        matrix[playerPosition[0]][playerPosition[1]] = "-";
                        playerPosition[1]--;
                    }
                    if (Arrays.equals(playerPosition, spartan)) {
                        life -= 2;
                        matrix[spartan[0]][spartan[1]] = "-";
                        if (life <= 0) {
                            System.out.printf("Paris died at %d;%d.%n", playerPosition[0], playerPosition[1]);
                            matrix[playerPosition[0]][playerPosition[1]] = "X";
                            parisIsDead = true;
                            break;
                        }
                    }
                    if (life <= 0) {
                        System.out.printf("Paris died at %d;%d.%n", playerPosition[0], playerPosition[1]);
                        matrix[playerPosition[0]][playerPosition[1]] = "X";
                        parisIsDead = true;
                        break;
                    }
                    if (Arrays.equals(playerPosition, helenPosition)) {
                        System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", life);
                        matrix[playerPosition[0]][playerPosition[1]] = "-";
                        hellenMissing = false;
                        break;
                    }
                    break;
                case "right":
                    life--;
                    matrix[spartan[0]][spartan[1]] = "S";
                    if (canMove(playerPosition[1] + 1, size)) {
                        matrix[playerPosition[0]][playerPosition[1]] = "-";
                        playerPosition[1]++;
                    }
                    if (Arrays.equals(playerPosition, spartan)) {
                        life -= 2;
                        matrix[spartan[0]][spartan[1]] = "-";
                        if (life <= 0) {
                            System.out.printf("Paris died at %d;%d.%n", playerPosition[0], playerPosition[1]);
                            matrix[playerPosition[0]][playerPosition[1]] = "X";
                            parisIsDead = true;
                            break;
                        }
                    }
                    if (life <= 0) {
                        System.out.printf("Paris died at %d;%d.%n", playerPosition[0], playerPosition[1]);
                        matrix[playerPosition[0]][playerPosition[1]] = "X";
                        parisIsDead = true;
                        break;
                    }
                    if (Arrays.equals(playerPosition, helenPosition)) {
                        System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", life);
                        matrix[playerPosition[0]][playerPosition[1]] = "-";
                        hellenMissing = false;
                        break;
                    }
                    break;
            }
        }

        printMatrix(matrix);

    }

//    private static boolean canMove(int[] player, int size) {
//        return player[0] >= 0 && player[0] <= size - 1 && player[1] >= 0 && player[1] <= size - 1;
//    }

    private static boolean canMove(int nextIndex, int size) {
        return nextIndex >= 0 && nextIndex <= size - 1;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join("", matrix[row]));
        }
    }
}
