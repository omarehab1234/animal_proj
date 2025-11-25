
import java.util.ArrayList;
//5alst el dangerLvl , Reason dan , awarness Hum ,invasive, na2s location
public abstract class Animal {
    private String name ,dangerLvl;
    private ArrayList<Location> locations = new ArrayList<>();
    private ArrayList<String> reasonForDanger = new ArrayList<>();
    private ArrayList<String> awarnessForHuman = new ArrayList<>();
    private ArrayList<String> invasiveSpecies = new ArrayList<>();
    public Animal(String name, String danger) {
        this.name = name;
        dangerLvl = dangerFilter(danger);
    }
    public static void main(String[] args) {
        String d = dangerFilter("**Danger Level**: Endangered");
        // filterawarnesHum("**Practical Advice for Humans**:\r\n" + //
        //                 "\\t* Support conservation efforts by donating to reputable organizations, such as the World Wildlife Fund (WWF) or the Lion Conservation Fund.\r\n" + //
        //                 "\\t* Spread awareness about the importance of protecting lion habitats and the impact of human activities on lion populations.\r\n" + //
        //                 "\\t* When visiting lion habitats, choose responsible and eco-friendly tour operators that follow best practices for wildlife viewing and support local conservation efforts.\r\n" + //
        //                 "\\t* Reduce your carbon footprint and support sustainable land-use practices to help mitigate the effects of climate change on lion habitats.\r\n" + //
        //                 "\\t* Avoid products made from lion parts, such as trophies or decorative items, and report any suspected lion poaching or trade to the relevant authorities.");
        // filterResFDanger("**Reason for Danger**: The main reasons for the decline in tiger population are habitat loss and fragmentation due to deforestation, poaching for their fur, bones, and body parts, and human-tiger conflict.");

    }
    public void addLocation(Location l){
        locations.add(l);
    }
    static String dangerFilter(String danger){
        return  danger.split(":")[1].trim();
        
    }
    //this to filter danger api reasons for animal decline 
    void filterResFDanger(String resDanger){
        String arr[] = resDanger.split(":")[1].split(",");
        for (int i = 0; i < arr.length; i++) {
            reasonForDanger.add(arr[i].replaceFirst("\\band\\b", "").trim());
        }
        System.out.println(reasonForDanger.size());

    }
    //this to filter human awarness
    void filterawarnesHum(String humawrness){
        String arr[] = humawrness.split(":")[1].split("\\.");
        for (int i = 0; i < arr.length; i++) {
            awarnessForHuman.add(arr[i].replace("\\t*", "").trim());
        }
    }
    //invasive filter
    void invasiveFilter(String invasive){
        String arr[] = invasive.split(":")[1].split("\\.");
        for (int i = 0; i < arr.length; i++) {
            invasiveSpecies.add(arr[i].replace("\\t*", "").trim());
        }
    }

}
