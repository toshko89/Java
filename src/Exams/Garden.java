package Exams;

import java.util.List;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int matrixSize = Integer.parseInt(size[0]);
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = 0;
            }
        }

        String coordinates = scanner.nextLine();
        List<Integer[]> allCoordinates = null;

        while (!coordinates.equals("Bloom Bloom Plow")) {
            String[] task = coordinates.split(" ");
            int currentRow = Integer.parseInt(task[0]);
            int currentCol = Integer.parseInt(task[1]);
            if (isInMatrix(currentRow, currentCol, matrix)) {
                matrix[currentRow][currentCol] +=1;
                //up
                for (int row = currentRow - 1; row >= 0; row--) {
                    matrix[row][currentCol] += 1;
                }
                //down
                for (int row = currentRow + 1; row < matrixSize; row++) {
                    matrix[row][currentCol] += 1;
                }

                //left
                for (int left = currentCol - 1; left >= 0; left--) {
                    matrix[currentRow][left] += 1;
                }

                for (int rigth = currentRow + 1; rigth < matrixSize; rigth++) {
                    matrix[currentRow][rigth] += 1;
                }

            } else {
                System.out.println("Invalid coordinates.");
            }

            if(coordinates.equals("Bloom Bloom Plow")){
                break;
            }

            coordinates = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static boolean isInMatrix(int row, int col, int[][] mat) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[row].length;
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}