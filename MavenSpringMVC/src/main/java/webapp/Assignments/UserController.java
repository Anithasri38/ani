package webapp.Assignments;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Service
public class UserController {
	
	@Autowired
	UserService service;
	
	List<UserModel> s=new CopyOnWriteArrayList<UserModel>();
	@RequestMapping(value="/registration",method=RequestMethod.GET)
     public String login()
     {
		
    	return "registration";
     }
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String handleForm(@RequestParam String username,@RequestParam String password,@RequestParam String email,ModelMap model)
	{
		//user.setUsername(username);
		//user.setPassword(password);
		//user.setEmail(email);
		service.add(username, password, email);
		s=service.retrivedetails();
		model.addAttribute("result",s);
		return "log";
		
	}
	//Iterator<UserModel> iterator=s.iterator();
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public String validate(@RequestParam String username1,@RequestParam String password1,ModelMap model)
	{
		/*Iterator<UserModel> iterator=s.iterator();
	   /* boolean result=service.isUser(username1,password1);
	    if(result)
	    {
	    	return "success";
	    }
	    else
	    {
	    	return "error";
	    }*/
		
		/*while(iterator.hasNext())
		{
			UserModel temp=iterator.next();
			if()
		}*/
		model.addAttribute(password1,password1);
		return "success";
	}
	
}
