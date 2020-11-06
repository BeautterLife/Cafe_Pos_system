import java.util.Scanner;
public class Payment {
    static Scanner in = new Scanner(System.in);
    public void Pay(SaleslineItem newSale, Sale sale){
        int total=0;
        System.out.println("장바구니 목록입니다.");
        newSale.printCart();
        System.out.println("합계는 "+ sale.showTotal() +" 원 입니다.");
        char c;
        do {
            System.out.println("신용카드 결제는 1, 현금결제는 2를 눌러주세요.");
            c = in.next().charAt(0);
        }while(c!='1' && c!='2');
        int money;
        if(c==50){
            do{
                System.out.println("현금을 투입하세요.");
                money = in.nextInt();
                if(money-sale.showTotal()<0){
                    System.out.println("합계 이상의 지폐를 투입하세요");
                }
            }
            while(money-sale.showTotal()<0);
            System.out.printf("거스름돈은 %d 입니다.%n",money-sale.showTotal());
        }
        System.out.println("결제되었습니다.");
    }
}
