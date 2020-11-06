import java.util.HashMap;
public class Juice extends Food {
    private String juiceName;
    //생성자를 private으로 하고 객체를 생성하는 method를 작성함.
    public static Juice getJuice(String name, int price){
        return new Juice(name,price);
    }
    private Juice(String s, int p){
        super(s, p);
    }
}
