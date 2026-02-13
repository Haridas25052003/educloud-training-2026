
import java.io.FileReader;

public class ReadFile {
    public static void main(String[] args) {
        
        try {
            FileReader fr=new FileReader("demo.txt");
            int ch;

            while((ch=fr.read())!=-1){
                System.out.print((char)ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
