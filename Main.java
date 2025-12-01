
public class Main {
    public static void main(String[] args) {
        AnimalApi api = new AnimalApi();
        try {
            api.getAnimal("Lion");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        api.showAnimal("Lion");
    }
}