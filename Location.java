

public class Location {
    private String name;
    private String xLoc , yLoc;

    public Location() {
    }
    
    Location(String name, String xLoc,String yLoc){
        this.name = name;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }
    String getName(){
        return name;
    }
    
    String getx(){
        return xLoc;
    }
    
    String gety(){
        return yLoc;
    }
    public String toString(){
        return "Name : "+name+" x: "+xLoc + " y: "+yLoc;
    }
}
