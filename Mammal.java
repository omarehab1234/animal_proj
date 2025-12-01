
public class Mammal extends Animal {

    private String type;

    public Mammal(String name, String dangerLvl, String location, String resFoDan , String awarForhuman,String invasSpe ,String type) {
        super(name, dangerLvl,location, resFoDan ,awarForhuman, invasSpe);
        this.type = type;
    }
}
