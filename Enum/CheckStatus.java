enum Status{
    SUCCESS,FAILED,PENDING
}
public class CheckStatus {
    public static void main(String[] args) {
        
        Status s=Status.SUCCESS;

        switch(s){
            case SUCCESS:
                System.out.println("operation successful");
                break;

            case FAILED:
                System.out.println("operation failed");
                break;

            case PENDING:
                System.out.println("operation pending");
                break;
        }
    }
}
