package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] map = new String[dimensions[0]][dimensions[1]];

        for (int rows = 0; rows < dimensions[0]; rows++) {
            String[] input = scanner.nextLine().split(" ");
            for (int cols = 0; cols < dimensions[1]; cols++) {
                map[rows][cols] = input[cols];
            }
        }
        int[] playerPosition = findPlayerPosition(map);

//        for (int rows = 0; rows < dimensions[0]; rows++) {
//            String[] input = scanner.nextLine().split(" ");
//            for (int cols = 0; cols < dimensions[1]; cols++) {
//                map[rows][cols] = input[cols];
//                if (map[rows][cols].equals("Y")) {
//                 return  new int[] {rows,cols};
//                }
//            }
//        }

        int playerColumn = playerPosition[0];
        int playerRow = playerPosition[1];
        String input = scanner.nextLine();
        StringBuffer steps = new StringBuffer();
        String currentField = "";
        while (!input.equals("Finish")) {
            switch (input) {
                case "up":
                    steps.append("up, ");
                    if ((playerColumn - 1) >= 0 && map[playerColumn - 1][playerRow] != "T") {
                        currentField = map[playerColumn - 1][playerRow];
                        playerColumn -= 1;
                    }
                    break;
                case "down":
                    steps.append("down, ");
                    if ((playerColumn + 1) <= dimensions[0] && map[playerColumn + 1][playerRow] != "T") {
                        currentField = map[playerColumn + 1][playerRow];
                        playerColumn += 1;
                    }
                    break;
                case "right":
                    steps.append("right, ");
                    if ((playerRow + 1) <= dimensions[1] && map[playerColumn][playerRow + 1] != "T") {
                        currentField = map[playerColumn][playerRow + 1];
                        playerRow += 1;
                    }
                    break;
                case "left":
                    steps.append("left, ");
                    if ((playerRow - 1) >= 0 && map[playerColumn][playerRow - 1] != "T") {
                        currentField = map[playerColumn][playerRow - 1];
                        playerRow -= 1;
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        if (currentField.equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + steps.substring(0, steps.length() - 2));
        } else {
            System.out.println("The map is fake!");
        }
    }

    public static int[] findPlayerPosition(String[][] map) {
        for (int rows = 0; rows < map.length; rows++) {
            for (int cols = 0; cols < map[rows].length; cols++) {
                if (map[rows][cols].equals("Y")) {
                    return new int[]{rows, cols};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
