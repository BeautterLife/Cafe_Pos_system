import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;


public class Possystem {
    Scanner in = new Scanner(System.in);
    Possystem(){
        System.out.println("홈 화면입니다.");
    }
    private String[] category ={"CoffeeList", "JuiceList", "BakeryList", "AddCaffeineList"};
    public void start(){
        int modeNum;
        do{
            System.out.println("주문은 1번, 관리자 모드는 2번, 종료는 0번입니다");
            modeNum = in.nextInt();
            //System.out.println(modeNum);

            switch (modeNum){
                case 1: {
                    Sale sale = new Sale();
                    SaleslineItem newSale = new SaleslineItem();
                    try{
                        sale.setFilePaths();
                        System.out.println("데이터를 모두 읽었습니다.");
                        sale.setFoodMenu();
                        System.out.println("메뉴를 로딩합니다....");
                    }
                    catch (IOException e){
                        System.out.println("메뉴가 없습니다. 관리자 모드에서 메뉴를 등록하세요.");
                        break;
                    }
                    //Customer customer = new Customer();
                    //Boolean order = true;
                    OrderMode(newSale, sale);
                    PayMode(newSale, sale);
                    try{
                        SaveTransaction(newSale.returnCart());
                    }
                    catch (IOException e){
                        System.out.println("거래내역 기록에 실패했습니다.");
                    }
                    break;
                }
                case 2: {
                    //AdminMenu adminMenu = new AdminMenu();
                    Admin admin = new Admin();
                    System.out.println("메뉴 등록은 1, 판매기록은 2, 종료는 0을 누르세요.");
                    int n = in.nextInt();
                    switch (n){
                        case 1:{
                            for(int i=0;i<category.length;i++){
                                try{
                                    System.out.println(category[i]+"를 등록합니다.");
                                    admin.MakeMenu(category[i]);
                                    System.out.println("메뉴 등록을 완료했습니다.");
                                }
                                catch (IOException e){
                                    System.out.println("에러가 발생했습니다. 종료합니다");
                                    System.out.println(e);
                                    return;
                                }
                            }
                            break;
                        }
                        case 2:{
                            try {
                                admin.showTransactionList();
                            }
                            catch (IOException e){
                                System.out.println("거래 내역 부르기를 실패했습니다. 파일이 없거나 삭제되었습니다");
                            }
                            break;
                        }
                        case 0:{
                            System.out.println("관리자 모드를 종료합니다.");
                        }
                    }
                    break;
                }
                case 0:
                    System.out.println("홈화면을 종료합니다.");
                    return;
                //GUI 적용시 다른 입력값이 들어올 경우가 없어 에러처리 안함.
            }
        }while(modeNum!=0);   //잘못된 입력 체크
    }

    public void OrderMode(SaleslineItem newSale, Sale sale){
        while(true){
            System.out.println("-----------카페 메뉴입니다-----------");
            System.out.println("주문할 메뉴를 입력하세요 \n커피는 1번 주스는 2번 빵은 3번입니다.");
            int menu = in.nextInt();
            sale.showEachMenu(menu);
            System.out.println("메뉴의 번호를 입력하세요");
            int menuNum = in.nextInt();
            System.out.println("메뉴의 수량을 입력하세요");
            int vol = in.nextInt();
            if(menu==1){
                System.out.println("1샷추가를 원하면 1번, 2샷추가는 2번 원하지 않으면 0번을 입력해주세요.");
                int shot = in.nextInt();
                newSale.buyItem(sale.returnFood(menuNum,vol,shot));
                sale.CalTotal(sale.returnFood(menuNum,vol,shot));
                newSale.printCart();
                System.out.println("추가 주문은 1번, 결제는 2번입니다, ");
                if(in.nextInt()==2) break;
                else continue;
            }
            //itemMenu.returnFood(menu,menuNum,vol);
            newSale.buyItem(sale.returnFood2(menu,menuNum,vol));
            sale.CalTotal(sale.returnFood2(menu,menuNum,vol));
            newSale.printCart();
            System.out.println("추가 주문은 1번, 결제는 2번입니다, ");
            if(in.nextInt()==2) break;
        }
    }

    public void PayMode(SaleslineItem newSale, Sale sale){
        Payment p = new Payment();
        p.Pay(newSale,sale);
    }

    public void SaveTransaction(HashMap<String,Integer> hashmap) throws IOException {
        Transaction transaction = new Transaction();
        transaction.SaveTransaction(hashmap);
    }
}
