//this class made to be the interface between GUI and The API so we can modify it later
import java.util.HashMap;

public class AnimalService {

    private HashMap<String, Animal> cache = new HashMap<>();
    private AnimalApi api; 

    public AnimalService(AnimalApi api) {
        this.api = api;
    }

    // Fetch animal (from cache or API)
    public Animal getAnimal(String name) throws Exception {
        name = name.toLowerCase();

        if (cache.containsKey(name)) {
            System.out.println("Loaded from cache: " + name);
            return cache.get(name);
        }

        Animal animal = api.fetchAnimal(name); 
        while(animal == null){
            animal = api.fetchAnimal(name);
            try {
                Thread.sleep(1000); // here to be alwayes ok that the api will give u what u want
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cache.put(name, animal);

        return animal;
    }

    // Optional: display animal info nicely
    public String displayAnimal(String name) {
        name = name.toLowerCase();
        if (cache.containsKey(name)) {
            Animal a = cache.get(name);
            return a.toString();
        }
        return "Animal not found!";
    }

    // Optional: clear cache
    public void clearCache() {
        cache.clear();
    }
}


