
import java.util.ArrayList;
import java.util.Arrays;
//5alst el dangerLvl , Reason dan , awarness Hum ,invasive, na2s location
public abstract class Animal {
    private String name ,dangerLvl;
    private Location locations = new Location();
    private ArrayList<String> reasonForDanger = new ArrayList<>();
    private ArrayList<String> awarnessForHuman = new ArrayList<>();
    private ArrayList<String> invasiveSpecies = new ArrayList<>();
    public Animal(String name, String danger , String location , String resFoDan , String awarForhuman , String invasSpe) {
        this.name = name;
        dangerFilter(danger);
        filterLocation(location);
        filterawarnesHum(awarForhuman);
        filterResFDanger(resFoDan);
        invasiveFilter(invasSpe);
    }
    
    void  dangerFilter(String danger){
        dangerLvl = danger.split(":")[1].replace("*", "");
        dangerLvl = dangerLvl.trim();
        
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
        String[] arr = humawrness.split("-");
        String[] result = Arrays.copyOfRange(arr, 1, arr.length);
        for (int i = 0; i < result.length; i++) {
            awarnessForHuman.add(result[i].replace("\\t*", "").trim());
        }
    }
    //invasive filter
    void invasiveFilter(String invasive){
        String arr[] = invasive.split(":")[1].split(",");
        for (int i = 0; i < arr.length; i++) {
            invasiveSpecies.add(arr[i].replace("\\t*", "").trim());
        }
    }
    //here to add location and filter it
    void filterLocation(String loca){

        String location = loca.split(":")[1];
        String name = location.split("\s\\(")[0].substring(2).trim();
        String x = location.substring(location.indexOf("(")+1,location.indexOf(",")).trim();
        String y = location.substring(location.indexOf(", ")+2,location.indexOf(")")).trim();
        System.out.println(location);
        System.out.println(name);
        
        System.out.println(x);
        
        System.out.println(y);
        locations = new Location(name, x, y);
        
    }
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", dangerLvl='" + dangerLvl + '\'' +
                ", locations=" + locations +
                ", reasonForDanger=" + reasonForDanger +
                ", awarnessForHuman=" + awarnessForHuman +
                ", invasiveSpecies=" + invasiveSpecies +
                '}';
    }
    public String getName(){
        return name;
    }
}
