package Exams;

import java.util.Scanner;

public class ThroneConquering_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];
        int helenRow = -1;
        int helenCol = -1;
        int parisRow = -1;
        int parisCol = -1;
        int parisDeadRow = -1;
        int parisDeadCol = -1;

        for (int row = 0; row < n; row++) {
            char[] tokens = scanner.nextLine().toCharArray();
            for (int col = 0; col < tokens.length; col++) {
                if (tokens[col] == 'H') {
                    helenRow = row;
                    helenCol = col;
                }

                if (tokens[col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
                field[row][col] = tokens[col];
            }
        }

        boolean foundHelen = false;
        boolean parisIsDead = false;
        while (!foundHelen) {
            String[] line = scanner.nextLine().split(" ");
            String command = line[0];
            int enemyRow = Integer.parseInt(line[1]);
            int enemyCol = Integer.parseInt(line[2]);
            field[enemyRow][enemyCol] = 'S';
            field[parisRow][parisCol] = '-';

            switch (command) {
                case "up":
                    if (isInBounds(parisRow - 1, parisCol, n, n)) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (isInBounds(parisRow + 1, parisCol, n, n)) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (isInBounds(parisRow, parisCol - 1, n, n)) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (isInBounds(parisRow, parisCol + 1, n, n)) {
                        parisCol++;
                    }
                    break;
            }
            energy--;

            if (field[parisRow][parisCol] == 'H') {
                foundHelen = true;
                field[parisRow][parisCol] = '-';
                break;
            }

            if (energy <= 0) {
                parisIsDead = true;
                field[parisRow][parisCol] = 'X';
                parisDeadRow = parisRow;
                parisDeadCol = parisCol;
                break;
            }

            if (field[parisRow][parisCol] == 'S') {
                energy -= 2;
                // energy check
                if (energy <= 0) {
                    parisIsDead = true;
                    field[parisRow][parisCol] = 'X';
                    parisDeadRow = parisRow;
                    parisDeadCol = parisCol;
                    break;
                }

                field[parisRow][parisCol] = '-';
            }


        }

        if(foundHelen) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: " + energy + "\n");
        }

        if(parisIsDead && !foundHelen) {
            System.out.printf("Paris died at %d;%d.%n", parisDeadRow, parisDeadCol);
        }

        for (char[] c : field) {
            for (char c1 : c) {
                System.out.printf(c1 + "");
            }
            System.out.println();
        }

    }

    public static boolean isInBounds(int currRow, int currCol, int matrixRowSize, int matrixColSize) {
        if (currRow > matrixRowSize - 1 || currRow < 0
                || currCol > matrixColSize - 1 || currCol < 0) {
            return false;
        }
        return true;
    }
}
