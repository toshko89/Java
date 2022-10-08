package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class Armory {
    // Тази матрица има телепорти с прескачане
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int[] playerPosition = null;
        int[] mirrorOne = null;
        int[] mirrorTwo = null;
        int toBuy = 65;
        boolean isWithinMatrix = true;
        int currentMoney = 0;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            matrix[row] = input;
            for (int col = 0; col < input.length; col++) {
                if (input[col].equals("A")) {
                    playerPosition = new int[]{row, col};
                } else if (input[col].equals("M")) {
                    if (mirrorOne == null) {
                        mirrorOne = new int[2];
                        mirrorOne[0] = row;
                        mirrorOne[1] = col;
                    } else {
                        mirrorTwo = new int[2];
                        mirrorTwo[0] = row;
                        mirrorTwo[1] = col;
                    }
                }
            }
        }

        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        while (currentMoney < toBuy && isWithinMatrix) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    matrix[playerRow][playerCol] = "-";
                    playerRow--;
                    if (playerRow < 0) {
                        System.out.println("I do not need more swords!");
                        isWithinMatrix = false;
                        break;
                    } else if (isInt(matrix[playerRow][playerCol])) {
                        int currentValue = Integer.parseInt(matrix[playerRow][playerCol]);
                        currentMoney += currentValue;
                        if (currentMoney >= toBuy) {
                            matrix[playerRow][playerCol] = "A";
                        } else {
                            matrix[playerRow][playerCol] = "-";
                        }
                    } else if (matrix[playerRow][playerCol].equals("M")) {
                        matrix[playerRow][playerCol] = "-";
                        if (playerRow == mirrorOne[0] && playerCol == mirrorOne[1]) {
                            playerRow = mirrorTwo[0];
                            playerCol = mirrorTwo[1];
                        } else {
                            playerRow = mirrorOne[0];
                            playerCol = mirrorOne[1];
                        }
                        matrix[playerRow][playerCol] = "-";
                    }
                    break;
                case "down":
                    matrix[playerRow][playerCol] = "-";
                    playerRow++;
                    if (playerRow >= matrix.length) {
                        System.out.println("I do not need more swords!");
                        isWithinMatrix = false;
                        break;
                    } else if (isInt(matrix[playerRow][playerCol])) {
                        int currentValue = Integer.parseInt(matrix[playerRow][playerCol]);
                        currentMoney += currentValue;
                        if (currentMoney >= toBuy) {
                            matrix[playerRow][playerCol] = "A";
                        } else {
                            matrix[playerRow][playerCol] = "-";
                        }
                    } else if (matrix[playerRow][playerCol].equals("M")) {
                        matrix[playerRow][playerCol] = "-";
                        if (playerRow == mirrorOne[0] && playerCol == mirrorOne[1]) {
                            playerRow = mirrorTwo[0];
                            playerCol = mirrorTwo[1];
                        } else {
                            playerRow = mirrorOne[0];
                            playerCol = mirrorOne[1];
                        }
                        matrix[playerRow][playerCol] = "-";
                    }
                    break;
                case "left":
                    matrix[playerRow][playerCol] = "-";
                    playerCol--;
                    if (playerCol < 0) {
                        System.out.println("I do not need more swords!");
                        isWithinMatrix = false;
                        break;
                    } else if (isInt(matrix[playerRow][playerCol])) {
                        int currentValue = Integer.parseInt(matrix[playerRow][playerCol]);
                        currentMoney += currentValue;
                        if (currentMoney >= toBuy) {
                            matrix[playerRow][playerCol] = "A";
                        } else {
                            matrix[playerRow][playerCol] = "-";
                        }
                    } else if (matrix[playerRow][playerCol].equals("M")) {
                        matrix[playerRow][playerCol] = "-";
                        if (playerRow == mirrorOne[0] && playerCol == mirrorOne[1]) {
                            playerRow = mirrorTwo[0];
                            playerCol = mirrorTwo[1];
                        } else {
                            playerRow = mirrorOne[0];
                            playerCol = mirrorOne[1];
                        }
                        matrix[playerRow][playerCol] = "-";
                    }
                    break;
                case "right":
                    matrix[playerRow][playerCol] = "-";
                    playerCol++;
                    if (playerCol >= matrix.length) {
                        System.out.println("I do not need more swords!");
                        isWithinMatrix = false;
                        break;
                    } else if (isInt(matrix[playerRow][playerCol])) {
                        int currentValue = Integer.parseInt(matrix[playerRow][playerCol]);
                        currentMoney += currentValue;
                        if (currentMoney >= toBuy) {
                            matrix[playerRow][playerCol] = "A";
                        } else {
                            matrix[playerRow][playerCol] = "-";
                        }
                    } else if (matrix[playerRow][playerCol].equals("M")) {
                        matrix[playerRow][playerCol] = "-";
                        if (playerRow == mirrorOne[0] && playerCol == mirrorOne[1]) {
                            playerRow = mirrorTwo[0];
                            playerCol = mirrorTwo[1];
                        } else {
                            playerRow = mirrorOne[0];
                            playerCol = mirrorOne[1];
                        }
                        matrix[playerRow][playerCol] = "-";
                    }
                    break;
            }
        }

        if (playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol > matrix.length) {
            matrix[playerRow][playerCol] = "A";
        }

        if (currentMoney >= toBuy) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.println("The king paid " + currentMoney + " gold coins.");
        printMatrix(matrix);
    }


    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join("", matrix[row]));
        }
    }

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}