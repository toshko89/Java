import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        while (input-- > 0){
            String userName = scanner.nextLine();
            usernames.add(userName);
        }

        usernames.forEach(el->System.out.println(el));

    }
}
