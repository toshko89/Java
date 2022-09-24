import java.util.*;

public class SetsElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr= Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();
        int firstSetLength = inputArr[0];
        int secondSetLength = inputArr[1];
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> resultSet = new LinkedHashSet<>();
        int nextLine;
        int firstCounter = firstSetLength;
        int secondCounter = secondSetLength;

        while(firstCounter-- > 0){
            nextLine = Integer.parseInt(scanner.nextLine());
            firstSet.add(nextLine);
        }

        while(secondCounter-- > 0){
            nextLine = Integer.parseInt(scanner.nextLine());
            secondSet.add(nextLine);
        }

        if(firstSetLength >= secondSetLength){
            firstSet.forEach(el->{
               if(secondSet.contains(el)){
                   resultSet.add(el);
               }
            });
        }else if(firstSetLength <= secondSetLength){
            secondSet.forEach(el->{
                if(firstSet.contains(el)){
                    resultSet.add(el);
                }
            });
        }

        resultSet.forEach(el->System.out.print(el + " "));
        System.out.println();
    }
}
