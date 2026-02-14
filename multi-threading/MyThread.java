 class TestThread extends Thread {
    
    public void run(){
        System.out.println("new thread running");
    }
}

public class MyThread{
    public static void main(String[] args) {
        
        TestThread t1=new TestThread();
        t1.start();
    }
}