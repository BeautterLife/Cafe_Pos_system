import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner in = new Scanner(System.in);

    Menu(){
        File file = new File("./FilePath.xt");
    }

    public void enrollMenu(String s,File fileListFile, String filePath) throws IOException{
        //int c;

        //메뉴를 처음 등록하는것이 아니면 등록
        FileWriter writer = new FileWriter(fileListFile, true);

        BufferedWriter bWriter = new BufferedWriter(writer);

        bWriter.append(filePath+s+"\n");
        bWriter.flush();
        File file = new File(filePath+s+".txt");
        FileWriter writer2 = new FileWriter(file, true);
        BufferedWriter bWriter2 = new BufferedWriter(writer2);
        BufferedReader read = new BufferedReader(new FileReader(file));


        //flag = True;
        //file = new File(filePath+s+".txt");
        //if (file==null)
        //FileWriter writer2 = new FileWriter(file, true);
        //BufferedWriter bWriter2 = new BufferedWriter(writer2);


        do{
            System.out.println("메뉴 이름을 입력하세요");
            bWriter2.append(in.next()+" ");
            bWriter2.flush();
            System.out.println("가격을 입력하세요");
            bWriter2.append(in.next()+"\n");
            bWriter.flush();
            System.out.println("메뉴 세부정보를 입력하세요");
            bWriter2.append("\\"+in.next()+"\n");
            bWriter2.flush();
            System.out.println("계속 등록은 1을, 입력 종료를 원하면 0을 누르세요.");
        }
        while((in.nextInt())!=0);
        bWriter.flush();
        writer.close();
        writer2.close();
        bWriter.close();
        bWriter2.close();
    }
}
