import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Transaction {
        public void SaveTransaction(HashMap<String,Integer> hashmap) throws IOException {
            File transactionFile = new File(".\\file2\\transactionFile.txt");
            FileWriter writer = new FileWriter(transactionFile, true);
            BufferedWriter bWriter = new BufferedWriter(writer);
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy:MM:dd-hh:mm:ss");
            String datetime = sdf1.format(cal.getTime());
            for(Map.Entry<String,Integer> map : hashmap.entrySet()){
                bWriter.append(map.getKey()+" ");
                bWriter.flush();
                bWriter.append(map.getValue()+"개 ");
                bWriter.flush();
            }
            bWriter.append("| 판매 시각 : "+datetime+'\n');
            bWriter.flush();
        }
}
