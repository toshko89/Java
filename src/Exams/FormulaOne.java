package Exams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class FormulaOne {
    // Тази използва normalization за превъртане на матрицата
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        Integer countCommands = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int[] playerPosition = new int[0];

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            matrix[row] = input;
            for (int i = 0; i < input.length; i++) {
                if (input[i].equals("P")) {
                    playerPosition = new int[]{row, i};
                }
            }
        }

        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        boolean finish = false;

        for (int i = 0; i < countCommands; i++) {
            String input = scanner.nextLine();
            switch (input) {
                case "up":
                    if (!matrix[playerPosition[0]][playerPosition[1]].equals("B")
                            && !matrix[playerPosition[0]][playerPosition[1]].equals("T")
                            && !matrix[playerPosition[0]][playerPosition[1]].equals("F")) {
                        matrix[playerRow][playerCol] = ".";
                    }
                    playerPosition[0]--;
                    normalization(playerPosition, size);
                    if (matrix[playerPosition[0]][playerPosition[1]].equals("B")) {
                        playerPosition[0]--;
                        normalization(playerPosition, size);
                    } else if (matrix[playerPosition[0]][playerPosition[1]].equals("T")) {
                        playerPosition[0]++;
                        normalization(playerPosition, size);
                    } else if (matrix[playerPosition[0]][playerPosition[1]].equals("F")) {
                        matrix[playerPosition[0]][playerPosition[1]] = "P";
                        finish = true;
                        System.out.println("Well done, the player won first place!");
                        break;
                    }
                    break;
                case "down":
                    if (!matrix[playerPosition[0]][playerPosition[1]].equals("B")
                            && !matrix[playerPosition[0]][playerPosition[1]].equals("T")
                            && !matrix[playerPosition[0]][playerPosition[1]].equals("F")) {
                        matrix[playerPosition[0]][playerPosition[1]] = ".";
                    }
                    playerPosition[0]++;
                    normalization(playerPosition, size);
                    if (matrix[playerPosition[0]][playerPosition[1]].equals("B")) {
                        playerPosition[0]++;
                        normalization(playerPosition, size);
                    } else if (matrix[playerPosition[0]][playerPosition[1]].equals("T")) {
                        playerPosition[0]--;
                        normalization(playerPosition, size);
                    } else if (matrix[playerPosition[0]][playerPosition[1]].equals("F")) {
                        matrix[playerPosition[0]][playerPosition[1]] = "P";
                        finish = true;
                        System.out.println("Well done, the player won first place!");
                        break;
                    }
                    break;
                case "left":
                    if (!matrix[playerPosition[0]][playerPosition[1]].equals("B")
                            && !matrix[playerPosition[0]][playerPosition[1]].equals("T")
                            && !matrix[playerPosition[0]][playerPosition[1]].equals("F")) {
                        matrix[playerPosition[0]][playerPosition[1]] = ".";
                    }
                    playerPosition[1]--;
                    normalization(playerPosition, size);
                    if (matrix[playerPosition[0]][playerPosition[1]].equals("B")) {
                        playerPosition[1]--;
                        normalization(playerPosition, size);
                    } else if (matrix[playerPosition[0]][playerPosition[1]].equals("T")) {
                        playerPosition[1]++;
                        normalization(playerPosition, size);
                    } else if (matrix[playerPosition[0]][playerPosition[1]].equals("F")) {
                        matrix[playerPosition[0]][playerPosition[1]] = "P";
                        finish = true;
                        System.out.println("Well done, the player won first place!");
                        break;
                    }
                    break;
                case "right":
                    if (!matrix[playerPosition[0]][playerPosition[1]].equals("B")
                            && !matrix[playerPosition[0]][playerPosition[1]].equals("T")
                            && !matrix[playerPosition[0]][playerPosition[1]].equals("F")) {
                        matrix[playerPosition[0]][playerPosition[1]] = ".";
                    }
                    playerPosition[1]++;
                    normalization(playerPosition, size);
                    if (matrix[playerPosition[0]][playerPosition[1]].equals("B")) {
                        playerPosition[1]++;
                        normalization(playerPosition, size);
                    } else if (matrix[playerPosition[0]][playerPosition[1]].equals("T")) {
                        playerPosition[1]--;
                        normalization(playerPosition, size);
                    } else if (matrix[playerPosition[0]][playerPosition[1]].equals("F")) {
                        matrix[playerPosition[0]][playerPosition[1]] = "P";
                        finish = true;
                        System.out.println("Well done, the player won first place!");
                        break;
                    }
                    break;
            }
            // Matrix normalization
//            if (playerRow < 0) {
//                playerRow += size;
//            } else {
//                playerRow %= size;
//            }
//
//            if (playerCol < 0) {
//                playerCol += size;
//            } else {
//                playerCol %= size;
//            }

            if (finish) {
                break;
            }
        }
        if (!finish) {
            matrix[playerPosition[0]][playerPosition[1]] = "P";
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static void normalization(int[] playerPosition, int size) {
        if (playerPosition[0] < 0) {
            playerPosition[0] += size;
        } else {
            playerPosition[0] %= size;
        }

        if (playerPosition[1] < 0) {
            playerPosition[1] += size;
        } else {
            playerPosition[1] %= size;
        }
    }


    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join("", matrix[row]));
        }
    }
}
