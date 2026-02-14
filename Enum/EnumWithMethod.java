enum Level{
    LOW,MEDIUM,HIGH;

    public void printMessege(){
        System.out.println("Level this: "+this);
    }
}
public class EnumWithMethod {
    public static void main(String[] args) {

        Level l=Level.HIGH;
        l.printMessege();

        

    }
}
