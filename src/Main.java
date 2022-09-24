import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> browser = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String current = "";

        while(!line.equals("Home")){
            if(line.equals("back")){
                if(!browser.isEmpty()){
                    browser.pop();
                }else{
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
        }else{
             if(!line.equals("")){
                 browser.push(line);
                 current = line;
             }
            }
            System.out.println(current);
            line = scanner.nextLine();

        }

    }

}
