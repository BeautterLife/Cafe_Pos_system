import javax.sql.rowset.spi.TransactionalWriter;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Admin{
    final String filePath = "./file2/";
    //final String fileListFile = ".\\file2\\filePath";
    private File fileListFile = new File("./file2/FilePath.txt");
    private Vector<String> filePaths;
    private Scanner in;
    Admin(){
        //System.out.println("관리자 모드입니다.");
        in = new Scanner(System.in);
    }

    public void MakeMenu(String s) throws IOException{
        Menu menu = new Menu();
        menu.enrollMenu(s,fileListFile, filePath);
    }

    public void showTransactionList() throws IOException{
        Transaction transaction = new Transaction();

        BufferedReader bufReader = new BufferedReader(new FileReader("./file2/transactionFile.txt"));
        String line="";
        while((line = bufReader.readLine())!=null){
            System.out.println(line);
        }
    }

    /*
    public void setFilePaths() throws IOException {
        //File file = new File(filePath);
        FileReader filereader = new FileReader(filePath);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = "";

        while((line = bufReader.readLine()) != null){
            filePaths.add(line+".txt");
        }
        bufReader.close();
        filereader.close();
        System.out.println("음식 파일 경로 읽기 완료");
    }
    */
}
