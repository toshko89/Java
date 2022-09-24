import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        if(input[1].equals("A")){
            int[][] result = patternA(input);
            printMatrix(result);
        }

        if(input[1].equals("B")){
            int[][] result = patternB(input);
            printMatrix(result);
        }
    }

    private static int[][] patternA(String[] input) {
        int matricDims = Integer.parseInt(input[0]);
        int[][] martix = new int[matricDims][matricDims];
        int value = 0;
        for (int rows = 0; rows < martix.length; rows++) {
            for (int cols = 0; cols < martix[rows].length; cols++) {
                value++;
                martix[cols][rows] = value;
            }
        }

        return martix;
    }

    private static int[][] patternB(String[] input) {
        int matricDims = Integer.parseInt(input[0]);
        int[][] martix = new int[matricDims][matricDims];
        int value = 0;
        for(int col = 0; col <matricDims;col++){
            if(col % 2 == 0){
                for(int row = 0; row < matricDims; row++){
                    value++;
                    martix[row][col] = value;
                }
            }else{
                for(int row = matricDims - 1; row >= 0; row--){
                    value++;
                    martix[row][col] = value;
                }
            }
        }
        return martix;
    }

   private static void printMatrix(int[][] matrix){
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

}
