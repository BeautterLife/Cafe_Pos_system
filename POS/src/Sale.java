import java.io.*;
import java.util.Map;
import java.util.Vector;

public class Sale {
    private Vector<String> foods;
    private Vector<Integer> prices;
    private Vector<String> CoffeeList;
    private Vector<Integer> CoffeePrices;
    private Vector<String> JuiceList;
    private Vector<Integer> JuicePrices;
    private Vector<String> BakeryList;
    private Vector<Integer> BakeryPrices;
    //Vector<Integer> SizeUpList;
    private Vector<String>  AddShotList;
    private Vector<Integer> AddShotPrices;

    private Vector<String> filePaths;
    private final String filePath = "./file2/FilePath.txt";
    private int totalPrice;

    Sale() {
        filePaths = new Vector<>();
        foods = new Vector<>();
        prices = new Vector<>();
        CoffeeList = new Vector<>();
        CoffeePrices = new Vector<>();
        totalPrice =0;
    }
    //중복코드 줄여보기.  Coffee, Juice, Bakery에 map에 string이 아닌 객체를 담을 방법 생각해보기
    //실제 객체 만들어서 전의 getclass와 같으면 value+1 => menu에서 해주기.
    //menu에서 한것 그대로 customer의 buyItem에는 복사하기?
    public Vector returnFood(int menuNum, int vol,int c){
        Vector<Coffee> coffee = new Vector<>();
        for(int i=0;i<vol;i++){
            coffee.add(Coffee.getCoffee(CoffeeList.get(menuNum-1),CoffeePrices.get(menuNum-1)+AddShotPrices.get(c-1),c-1));
        }
        return coffee;
    }

    public Vector returnFood2(int menuType, int menuNum, int vol){
        switch (menuType){
            case 1 :{
                Vector<Coffee> coffee = new Vector<>(vol);
                for(int i=0;i<vol;i++){
                    coffee.add(Coffee.getCoffee(CoffeeList.get(menuNum-1),CoffeePrices.get(menuNum-1)));
                }
                return coffee;

            }
            case 2 : {
                Vector<Juice> juice = new Vector<>(vol);
                for(int i=0;i<vol;i++){
                    juice.add(Juice.getJuice(JuiceList.get(menuNum-1),JuicePrices.get(menuNum-1)));
                }
                return juice;

            }
            case 3 : {
                Vector<Bakery> bakery = new Vector<>(vol);
                for(int i=0;i<vol;i++){
                    bakery.add(Bakery.getBakery(BakeryList.get(menuNum-1),BakeryPrices.get(menuNum-1)));
                }
                return bakery;
            }
        }
        return null;
    }

    public void CalTotal(Vector<Food> f){
        for(int i=0;i<f.size();i++){
            totalPrice+=f.get(i).getPrice();
        }
    }
    public int showTotal(){
        return totalPrice;
    }

    public void showEachMenu(int n){
        switch (n){
            case 1:{
                print(CoffeeList,CoffeePrices);
                break;
            }
            case 2:{
                print(JuiceList,JuicePrices);
                break;
            }
            case 3:{
                print(BakeryList,BakeryPrices);
                break;
            }
        }
    }
    public void print(Vector<String> foodName,Vector<Integer> foodPrice){
        int len = foodName.size();
        for(int i=0;i<len;i++) {
            System.out.println(i+1+" "+foodName.get(i)+" "+foodPrice.get(i)+"원");
        }
        System.out.println();
    }
    //각 메뉴가 저장된 파일 경로 설정.
    public void setFilePaths() throws IOException{
        File file = new File(filePath);
        FileReader filereader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";
        while((line = bufReader.readLine()) != null){
            filePaths.add(line+".txt");
        }
        bufReader.close();
        filereader.close();
        System.out.println("음식 파일 경로 읽기 완료");
    }
    //메뉴가 저장된 파일 read후 프로그램에 load.
    public void setFoodMenu() throws IOException {
        FileReader fileReader;
        BufferedReader bufReader;
        File file;
        /*                            5/5 수정할사항.
        try{
            open(filepath)
        }
        catch{
            filepath.txt만들기
        }
        */

        for(int i=0;i<filePaths.size();i++){
            file = new File(filePaths.get(i));
            //fileReader = new FileReader(file);
            bufReader = new BufferedReader(new FileReader(file));
            String line="";
            Vector<String> nameList;
            Vector<Integer> priceList;
            if(i==0) {
                nameList = new Vector<>();
                priceList = new Vector<>();
                CoffeeList = nameList;
                CoffeePrices = priceList;
            }
            else if(i==1){
                nameList = new Vector<>();
                priceList = new Vector<>();
                JuiceList = nameList;
                JuicePrices = priceList;
            }
            else if(i==2){
                nameList = new Vector<>();
                priceList = new Vector<>();
                BakeryList = nameList;
                BakeryPrices = priceList;
            }
            else {
                nameList = new Vector<>();
                priceList = new Vector<>();
                AddShotList = nameList;
                AddShotPrices = priceList;
            }
            while((line=bufReader.readLine()) != null){
                if(line.startsWith("\\") ){
                    //System.out.println("추가정보 line임.");
                    continue;
                }
                //System.out.println(line);
                String spec[] = line.split(" ");
                foods.add(spec[0]);
                nameList.add(spec[0]);
                prices.add(Integer.parseInt(spec[1]));
                priceList.add(Integer.parseInt(spec[1]));
            }
        }
    }

}
