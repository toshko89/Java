package Exams;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int[] mousePositon = null;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            matrix[row] = input;
            for (int col = 0; col < input.length; col++) {
                if (input[col].equals("M")) {
                    mousePositon = new int[]{row, col};
                }
            }
        }

        int cheese = 0;
        boolean mouseIsInMatrix = true;
        int mouseRow = mousePositon[0];
        int mouseCol = mousePositon[1];
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "up":
                    matrix[mouseRow][mouseCol] = "-";
                    if (isInMatrix(mouseRow - 1, mouseCol, matrix)) {
                        mouseRow--;
                    } else {
                        matrix[mouseRow][mouseCol] = "-";
                        System.out.println("Where is the mouse?");
                        mouseIsInMatrix = false;
                        break;
                    }
                    if (matrix[mouseRow][mouseCol].equals("B")) {
                        matrix[mouseRow][mouseCol] = "-";
                        if (isInMatrix(mouseRow - 1, mouseCol, matrix)) {
                            mouseRow--;
                            matrix[mouseRow][mouseCol] = "M";
                        } else {
                            matrix[mouseRow][mouseCol] = "-";
                            System.out.println("Where is the mouse?");
                            mouseIsInMatrix = false;
                            break;
                        }
                        if (matrix[mouseRow][mouseCol].equals("c")) {
                            cheese += 1;
                            matrix[mouseRow][mouseCol] = "M";
                        }
                    }
                    if (matrix[mouseRow][mouseCol].equals("c")) {
                        cheese += 1;
                        matrix[mouseRow][mouseCol] = "M";
                    }
                    matrix[mouseRow][mouseCol] = "M";
                    break;
                case "down":
                    matrix[mouseRow][mouseCol] = "-";
                    if (isInMatrix(mouseRow + 1, mouseCol, matrix)) {
                        mouseRow++;
                    } else {
                        matrix[mouseRow][mouseCol] = "-";
                        System.out.println("Where is the mouse?");
                        mouseIsInMatrix = false;
                        break;
                    }
                    if (matrix[mouseRow][mouseCol].equals("B")) {
                        matrix[mouseRow][mouseCol] = "-";
                        if (isInMatrix(mouseRow + 1, mouseCol, matrix)) {
                            mouseRow++;
                            matrix[mouseRow][mouseCol] = "M";
                        } else {
                            matrix[mouseRow][mouseCol] = "-";
                            System.out.println("Where is the mouse?");
                            mouseIsInMatrix = false;
                            break;
                        }
                        if (matrix[mouseRow][mouseCol].equals("c")) {
                            cheese += 1;
                            matrix[mouseRow][mouseCol] = "M";
                        }
                    }
                    if (matrix[mouseRow][mouseCol].equals("c")) {
                        cheese += 1;
                        matrix[mouseRow][mouseCol] = "M";
                    }
                    matrix[mouseRow][mouseCol] = "M";
                    break;
                case "left":
                    matrix[mouseRow][mouseCol] = "-";
                    if (isInMatrix(mouseRow, mouseCol - 1, matrix)) {
                        mouseCol--;
                    } else {
                        matrix[mouseRow][mouseCol] = "-";
                        System.out.println("Where is the mouse?");
                        mouseIsInMatrix = false;
                        break;
                    }
                    if (matrix[mouseRow][mouseCol].equals("B")) {
                        matrix[mouseRow][mouseCol] = "-";
                        if (isInMatrix(mouseRow, mouseCol - 1, matrix)) {
                            mouseCol--;
                            matrix[mouseRow][mouseCol] = "M";
                        } else {
                            matrix[mouseRow][mouseCol] = "-";
                            System.out.println("Where is the mouse?");
                            mouseIsInMatrix = false;
                            break;
                        }
                        if (matrix[mouseRow][mouseCol].equals("c")) {
                            cheese += 1;
                            matrix[mouseRow][mouseCol] = "M";
                        }
                    }
                    if (matrix[mouseRow][mouseCol].equals("c")) {
                        cheese += 1;
                        matrix[mouseRow][mouseCol] = "M";
                    }
                    matrix[mouseRow][mouseCol] = "M";
                    break;
                case "right":
                    matrix[mouseRow][mouseCol] = "-";
                    if (isInMatrix(mouseRow, mouseCol + 1, matrix)) {
                        mouseCol++;
                    } else {
                        matrix[mouseRow][mouseCol] = "-";
                        System.out.println("Where is the mouse?");
                        mouseIsInMatrix = false;
                        break;
                    }
                    if (matrix[mouseRow][mouseCol].equals("B")) {
                        matrix[mouseRow][mouseCol] = "-";
                        if (isInMatrix(mouseRow, mouseCol + 1, matrix)) {
                            mouseCol++;
                            matrix[mouseRow][mouseCol] = "M";
                        } else {
                            matrix[mouseRow][mouseCol] = "-";
                            System.out.println("Where is the mouse?");
                            mouseIsInMatrix = false;
                            break;
                        }
                        if (matrix[mouseRow][mouseCol].equals("c")) {
                            cheese += 1;
                            matrix[mouseRow][mouseCol] = "M";
                        }
                    }
                    if (matrix[mouseRow][mouseCol].equals("c")) {
                        cheese += 1;
                        matrix[mouseRow][mouseCol] = "M";
                    }
                    matrix[mouseRow][mouseCol] = "M";
                    break;
            }
            if (!mouseIsInMatrix) {
                break;
            }
            input = scanner.nextLine();
        }

        if (cheese >= 5) {
            System.out.println("Great job, the mouse is fed " + cheese + " cheeses!");
        } else {
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - cheese) + " cheeses more.");
        }

        printMatrix(matrix);

    }

    private static boolean isInMatrix(int row, int col, String[][] mat) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[row].length;
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join("", matrix[row]));
        }
    }
}
