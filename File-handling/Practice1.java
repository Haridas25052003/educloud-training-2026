import java.io.FileWriter;
import java.io.IOException;
public class Practice1 {
    public static void main(String[] args) {
        
        try {
            FileWriter fw=new FileWriter("demo.txt");
            fw.write("my name is haridas shinde");
            fw.close();
            System.out.println("data writtern successfully");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
