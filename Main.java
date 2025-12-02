
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    AnimalApi api = new AnimalApi();
    AnimalService aService = new AnimalService(api);
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine().trim();

    while (!name.equalsIgnoreCase("exit")) {

        if (name.isEmpty()) {
            System.out.println("Enter an animal name or type 'exit' to finish:");
        } else {
            try {
                aService.getAnimal(name);     // fetch from API or cache
                System.out.println(aService.displayAnimal(name));    // display
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        name = sc.nextLine().trim();   // ask again
    }
    }
}