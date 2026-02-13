import java.io.FileWriter;

public class practice2 {
    public static void main(String[] args) {
        
        try {
           FileWriter fw=new FileWriter("demo.txt");
           fw.write("java");
           fw.write("core java programming");
           fw.write("this is the programming way");
           fw.close();
           System.out.println("content added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
