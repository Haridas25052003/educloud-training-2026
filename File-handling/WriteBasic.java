
import java.io.FileWriter;
import java.io.IOException;

class WriteBasic{
    public static void main(String[]args){
 
        try {
            FileWriter fw=new FileWriter("demo.txt");
            fw.write("hello");
            fw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}