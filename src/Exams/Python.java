package Exams;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] board = new char[n][n];

        int foodAvailable = 0;
        int[] coordinates = new int[2];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            for (int j = 0; j < n; j++) {
                char currChar = line.charAt(j);
                if (currChar == 'f') {
                    foodAvailable++;
                } else if (currChar == 's') {
                    coordinates[0] = i;
                    coordinates[1] = j;
                }

                board[i][j] = currChar;
            }
        }
        boolean gameOver = false;
        int length = 1;
        for (String command : commands) {
            move(n, coordinates, command);
//            printMatrix(board);
//            System.out.println("Coordinates: " + coordinates[0] + ", " + coordinates[1]);
            char currentChar = board[coordinates[0]][coordinates[1]];
            if (currentChar == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                gameOver = true;
                break;
            } else if (currentChar == 'f') {
                foodAvailable--;
                length++;
                board[coordinates[0]][coordinates[1]] = '*';
            }
        }

        if (!gameOver) {
            if (foodAvailable == 0) {
                System.out.println("You win! Final python length is " + length + " ");
            } else {
                System.out.println("You lose! There is still " + foodAvailable + " food to be eaten.");
            }
        }
    }

    private static void printMatrix(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void move(int n, int[] coordinates, String command) {
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
        //nomralize coordinates
        if (coordinates[0] < 0) {
            coordinates[0] += n;
        } else {
            coordinates[0] %= n;
        }

        if (coordinates[1] < 0) {
            coordinates[1] += n;
        } else {
            coordinates[1] %= n;
        }
    }
}

