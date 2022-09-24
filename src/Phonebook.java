import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while(!input.equals("search")){
            String[] data = input.split("-");
            String name = data[0];
            String phone = data[1];
            phonebook.put(name,phone);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while(!input.equals("stop")){
            String contact = phonebook.get(input);
            if(contact != null){
                System.out.println(input + " -> " + contact);
            }else{
                System.out.printf("Contact %s does not exist.%n",input);
            }
            input = scanner.nextLine();
        }

        System.out.println();
    }
}
