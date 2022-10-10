package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> male = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(male::push);

        ArrayDeque<Integer> female = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int match = 0;

        while (!male.isEmpty() && !female.isEmpty()) {
            int checkMale = male.peek();
            int checkFemale = female.peek();
            if (checkMale <= 0) {
                male.poll();
            } else if (checkFemale <= 0) {
                female.pop();
            } else if (checkMale % 25 == 0) {
                male.poll();
                male.poll();
            } else if (checkFemale % 25 == 0) {
                female.pop();
                female.pop();
            } else if(checkMale == checkFemale){
                match++;
                male.poll();
                female.pop();
            } else {
                female.pop();
                int currentMale = male.poll();
                currentMale-=2;
                male.push(currentMale);
            }

        }

        System.out.println("Matches: " + match);

        if(male.size() > 0){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Males left: ");
            for (Integer integer : male) {
                stringBuilder.append(integer).append(", ");
            }
            final int i = stringBuilder.lastIndexOf(",");
            stringBuilder.deleteCharAt(i);
            System.out.println(stringBuilder.toString().trim());
        }else{
            System.out.println("Males left: none");
        }

        if(female.size() > 0){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Females left: ");
            for (Integer integer : female) {
                stringBuilder.append(integer).append(", ");
            }
            final int i = stringBuilder.lastIndexOf(",");
            stringBuilder.deleteCharAt(i);
            System.out.println(stringBuilder.toString().trim());
        }else{
            System.out.println("Females left: none");
        }

    }
}
