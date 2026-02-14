enum Role{

    ADMIN("Full access"),
    USER("Limited access"),
    GUEST("view only");

    private String description;

    Role(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }
}
public class EnumWithConstruct {
       public static void main(String[] args) {
      
         Role r=Role.ADMIN;
         System.out.println(r.getDescription());

       }
}
