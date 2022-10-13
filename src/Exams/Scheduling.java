package Exams;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> task = new ArrayDeque<>();
        String[] bombCasingStrings = scanner.nextLine().split(", ");
        for (String bombCasing : bombCasingStrings) {
            task.push(Integer.parseInt(bombCasing));
        }
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        String[] bombEffectStrings = scanner.nextLine().split(" ");
        for (String bombEffect : bombEffectStrings) {
            threads.offer(Integer.parseInt(bombEffect));
        }

        int taskToKill = Integer.parseInt(scanner.nextLine());
        int threadKiller = 0;

        while (!task.isEmpty() && !threads.isEmpty()) {
            int thread = threads.poll();
            int currentTask = task.pop();
            if (currentTask == taskToKill) {
                threadKiller = thread;
                System.out.println("Thread with value " + threadKiller + " killed task " + taskToKill);
                break;
            } else if (thread >= currentTask) {
                continue;
            } else if (thread < currentTask) {
                task.push(currentTask);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(threadKiller + " ");

        if (threads.size() > 0) {
            for (Integer thread : threads) {
                stringBuilder.append(thread + " ");
            }
        }

        System.out.println(stringBuilder.toString().trim());


    }
}
