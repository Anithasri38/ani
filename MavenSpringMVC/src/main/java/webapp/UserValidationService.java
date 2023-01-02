package webapp;

public class UserValidationService 
{
   public boolean isUserValid(String user,String password)
   {
	   if(user.equals("surya")&&password.equals("dummy"))
	   {
		   return true;
		   
	   }
	   else
	   {
		   return false;
	   }
   }
}
