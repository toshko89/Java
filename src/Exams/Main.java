package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> licensePlatesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carsStack = new ArrayDeque<>();

        int[] newLicensePlates = Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt).toArray();
        for (Integer newLicensePlate : newLicensePlates) {
            licensePlatesQueue.offer(newLicensePlate);
        }
        input = scanner.nextLine();
        int[] newCars = Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt).toArray();
        for (Integer car : newCars) {
            carsStack.push(car);
        }

        Integer countTotalDays = 0;
        Integer countOfRegisteredCars = 0;
        while (!carsStack.isEmpty() && !licensePlatesQueue.isEmpty() ) {
            Integer platesToday = licensePlatesQueue.poll();
            Integer carsToday = carsStack.pop();
            Integer totalNeededPlates = carsToday * 2;
            Integer platesRemaining = platesToday - totalNeededPlates;
            if (platesRemaining <= 0) {
                Integer carsRemaning = carsToday - (platesToday / 2);
                countOfRegisteredCars -= carsRemaning;
                carsStack.push(carsRemaning);
            } else if (platesRemaining > 0) {
                licensePlatesQueue.offer(platesRemaining);
                System.out.println();
            }
            countOfRegisteredCars += carsToday;
            countTotalDays++;
        }

        System.out.println(countOfRegisteredCars + " cars were registered for " + countTotalDays + " days!");
        if (!licensePlatesQueue.isEmpty()) {
            Integer total = 0;
            for (Integer integer : licensePlatesQueue) {
                total += integer;
            }
            System.out.println(total + " license plates remain!");
        } else if (!carsStack.isEmpty()) {
            Integer total = 0;
            for (Integer integer : carsStack) {
                total += integer;
            }
            System.out.println(total + " cars remain without license plates!");
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
