public class LambdaThread {
    public static void main(String[] args) {
        
        Thread t1=new Thread(()->{
            System.out.println("lambda thread running");
        });
        t1.start();
    }
}
