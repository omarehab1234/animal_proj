
public class Reptile extends Animal {

    private String type;

    public Reptile(String name, String dangerLvl, String location, String resFoDan , String awarForhuman,String invasSpe ,String type) {
        super(name, dangerLvl,location, resFoDan ,awarForhuman, invasSpe);
        this.type = type;
    }
}
