public class Food {
    private int price;
    private String name;

    protected Food() {
    }

    protected Food(String s, int p) {
        name = s;
        price = p;
    }

    static public Food getFood(String s, int p) {
        return new Food(s, p);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int cost) {
        price += cost;
    }

    public String getName() {
        return name;
    }
}
    /*
    public boolean isSameFood(Food food1,Food food2){
        if(food1 instanceof Coffee){
            return (Coffee)
        }
    }
    */

