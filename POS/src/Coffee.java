import java.util.HashMap;
public class Coffee extends Food  {
    private char size;
    private int addShot;
    private String coffeeName;

    private Coffee(String s, int p, int c) {
        super(s + " " + (c + 1) + "샷", p);  // Food의 생성자를 호출함.
        // 매개변수로 받은 s와 p로 Coffee 객체의 name을 설정함.
        size = 'S';
        addShot = c + 1;
    }
    //생성자를 private으로 하여 객체를 생성하는 method를 따로 작성함.
    public static Coffee getCoffee(String name, int price, int caffeine) {
        return new Coffee(name, price, caffeine);
    }


    public static Coffee getCoffee(String name, int price) {
        return new Coffee(name, price);
    }

    private Coffee(String s, int p) {
        super(s + " 1샷", p);
        //coffeeName = s;
        size = 'S';
        addShot = 1;
    }


}
    /*
    public void changeSize(char c){
        this.size = c;
    }
    public void changeCaffeineShot(int n){
        this.addCaffeine = n;
    }
    */


