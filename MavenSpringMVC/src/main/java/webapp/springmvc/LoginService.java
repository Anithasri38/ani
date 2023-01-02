package webapp.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
  public boolean validateUser(String name,String password)
  {
	  return name.equalsIgnoreCase("Ani")&&password.equals("sri");
  }
}
