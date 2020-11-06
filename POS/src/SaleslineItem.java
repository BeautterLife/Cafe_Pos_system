import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
public class SaleslineItem {
    //장바구니 역할을 하는 HashMap.
    //Food name, 수량을 담고있음.
    private HashMap<String, Integer> cart = new HashMap<>();
    Iterator<String> iter;
    public HashMap returnCart(){
        return cart;
    }
    //FoodMenu 객체에서, 사용자가 원하는 item을 Food 타입의 vector로 받아서 cart(장바구니)에 저장하는 method.
    public void buyItem(Vector<Food> food){
        for(int i=0;i<food.size();i++){
            if(cart.isEmpty()||!cart.containsKey(food.get(i).getName())) cart.put(food.get(i).getName(),1);
            else{
                cart.put(food.get(i).getName(),cart.get(food.get(i).getName())+1);
            }
        }
    }
    public void printCart(){
        for(Map.Entry<String,Integer> map : cart.entrySet()){
            System.out.println(map.getKey()+" "+map.getValue()+"개");
        }
    }
    /*
    public String toString(Food food){
        return food.getName();
    }
    */
}


/*
            iter = cart.keySet().iterator();
            do{

               // System.out.println('s');

                //Food f = iter.next();

                if(!iter.hasNext()||iter.next().getName() != food.get(i).getName()){
                    cart.put(Food.getFood(food.get(i).getName(),food.get(i).getPrice()),1);

                }
                else{
                    cart.put( food.get(i),cart.get(food.get(i))+1 );
                    cart.put(Food.getFood(food.get(i).getName(),food.get(i).getPrice()),);
                    System.out.println("d");
                }

            }while(iter.hasNext());
            */

//else cart.put( food.get(i),cart.get(food.get(i))+1 );