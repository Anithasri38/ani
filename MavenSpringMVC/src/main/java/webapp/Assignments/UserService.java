package webapp.Assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
@Service
public class UserService {
	private int count;
	boolean result;
   private static List<UserModel> user=new CopyOnWriteArrayList<UserModel>();
   public void add(String username,String password,String email)
   {
	   user.add(new UserModel(username,password,email));
   }
   public List<UserModel> retrivedetails()
   {
	   List<UserModel> filtered=new CopyOnWriteArrayList<UserModel>();
	   for(UserModel users:user)
	   {
		   filtered.add(users);
	   }
	   return filtered;
   }
   Iterator<UserModel> iterator=user.iterator();
   public boolean isUser(String username,String password)
   {
	   while(iterator.hasNext())
	   {
		   UserModel usermodel=iterator.next();
		   if((usermodel.getUsername().equals(username))&&(usermodel.getPassword().equals(password)))
		   {
			  
			    result=true;
			    break;
			  
		   }
	   }
	   if(result)
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
   }
}
