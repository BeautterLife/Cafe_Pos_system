public class Bakery extends Food {
    private String bakeryName;

    private Bakery(String s, int p){
        super(s,p);
    }
    //생성자를 private으로 하고 객체를 생성하는 method를 작성함.
    public static Bakery getBakery(String name, int price){
        return new Bakery(name,price);
    }
}
