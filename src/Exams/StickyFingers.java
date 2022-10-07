package Exams;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        String[] commands = scanner.nextLine().split(",");

        for (int i = 0; i < size; i++) {
            String[] inputLines = scanner.nextLine().split(" ");
            matrix[i] = inputLines;
        }

        int[] DillingerPosition = playerPosition(matrix);
        int dillingerRow = DillingerPosition[0];
        int dillingerCol = DillingerPosition[1];

        int rowCopy = dillingerRow;
        int colCopy = dillingerCol;
        int totalMoney = 0;

        for (int j = 0; j < commands.length; j++) {
            String currentCommand = commands[j];
            switch (currentCommand) {
                case "up":
                    if (dillingerRow <= 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    matrix[dillingerRow][dillingerCol] = "+";
                    dillingerRow--;
                    break;
                case "down":
                    if (dillingerRow >= matrix.length - 1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    matrix[dillingerRow][dillingerCol] = "+";
                    dillingerRow++;
                    break;
                case "left":
                    if (dillingerCol <= 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    matrix[dillingerRow][dillingerCol] = "+";
                    dillingerCol--;
                    break;
                case "right":
                    if (dillingerCol >= matrix.length - 1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        break;
                    }
                    matrix[dillingerRow][dillingerCol] = "+";
                    dillingerCol++;
                    break;
            }
            if (matrix[dillingerRow][dillingerCol].equals("$")) {
                totalMoney += (dillingerRow * dillingerCol);
                matrix[dillingerRow][dillingerCol] = "D";
                System.out.printf("You successfully stole %d$.%n", dillingerRow * dillingerCol);
            } else if (matrix[dillingerRow][dillingerCol].equals("P")) {
                matrix[dillingerRow][dillingerCol] = "#";
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                printMatrix(matrix);
                return;
            } else {
                matrix[dillingerRow][dillingerCol] = "D";
            }

        }

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        printMatrix(matrix);
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join(" ", matrix[row]));
        }
    }

    public static int[] playerPosition(String[][] allFields) {
        for (int row = 0; row < allFields.length; row++) {
            for (int col = 0; col < allFields[row].length; col++) {
                if (allFields[row][col].equals("D")) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[0];
    }
}
