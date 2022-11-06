import java.util.*;
import java.lang.*;
public class LoginDetails {
 public static void main(String args[])
 {
  Scanner s=new Scanner(System.in);
  String username="Anitha";
  String password="Anitha@123";
  int i=1;
     while(i<=3)
     {
      System.out.println("Enter UserName:");
      String Username=s.next();
      System.out.println("Enter Password:");
      String Password=s.next();

         if((username.equals(Username))&&(password.equals(Password)))
         {
          System.out.println("Welcome");
          break;
         }
         if(i==3)
         {
          System.out.println("contact Admin");
          break;
         }
         else
         {
          System.out.println("Please enter proper username and password");
         }
         i=i+1;
     }
 }
}
