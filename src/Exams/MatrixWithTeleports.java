package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixWithTeleports {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] pastryShop = new char[n][n];
        int[] coordinates = new int[2];

        int[] pillarOneCoordinates = null;
        int[] pillarTwoCoordinates = null;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                char currentChar = line.charAt(j);
                pastryShop[i][j] = currentChar;
                if (currentChar == 'S') {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    pastryShop[i][j] = '-';
                } else if (currentChar == 'P') {
                    if (pillarOneCoordinates == null) {
                        pillarOneCoordinates = new int[2];
                        pillarOneCoordinates[0] = i;
                        pillarOneCoordinates[1] = j;
                    } else {
                        pillarTwoCoordinates = new int[2];
                        pillarTwoCoordinates[0] = i;
                        pillarTwoCoordinates[1] = j;
                    }
                }
            }
        }

        int money = 0;
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    coordinates[0]--;
                    break;
                case "down":
                    coordinates[0]++;
                    break;
                case "left":
                    coordinates[1]--;
                    break;
                case "right":
                    coordinates[1]++;
                    break;
            }

            if (0 > coordinates[0] || coordinates[0] >= n
                    || 0 > coordinates[1] || coordinates[1] >= n) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }

            char currentChar = pastryShop[coordinates[0]][coordinates[1]];
            if (Character.isDigit(currentChar)) {
                money += (currentChar - '0');
                pastryShop[coordinates[0]][coordinates[1]] = '-';
                if (money >= 50) {
                    System.out.println("Good news! You succeeded in collecting enough money!");
                    break;
                }

                continue;
            }

            if (currentChar == 'P') {
                if (Arrays.equals(coordinates, pillarOneCoordinates)) {
                    coordinates = pillarTwoCoordinates;
                } else {
                    coordinates = pillarOneCoordinates;
                }
                pastryShop[pillarOneCoordinates[0]][pillarOneCoordinates[1]] = '-';
                pastryShop[pillarTwoCoordinates[0]][pillarTwoCoordinates[1]] = '-';
            }
        }

        System.out.println("Money: " + money);
        printMatrix(pastryShop, coordinates);
    }

    private static void printMatrix(char[][] board, int[] coordinates) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (coordinates[0] == i && coordinates[1] == j) {
                    System.out.print('S');
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }
}
