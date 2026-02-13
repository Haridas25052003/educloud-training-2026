import java.util.*;
class WrapperPractice{
    public static void main(String[]args){

        //autoboxing
        int a=5;
        Integer objA=a;

        //unboxing
        Integer objB=10;
        int b=objB;

        //parsing
        String str="123";
        int num=Integer.parseInt(str);
       
        //using in ArrayList
        ArrayList<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("sum: "+(list.get(0)+list.get(1)));
        System.out.println("Parsed numbers: "+num);
    }
}