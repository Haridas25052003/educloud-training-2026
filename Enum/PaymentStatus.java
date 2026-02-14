enum Status{

    SUCCESS(200),
    FAILED(500),
    PENDING(300);

    private int code;

    Status(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }
}
class PaymentStatus{
    public static void main(String[] args) {
     
        Status s=Status.SUCCESS;
        System.out.println(s.getCode());

    }
}