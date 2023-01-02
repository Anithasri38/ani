package webapp.Assignments;

import javax.enterprise.inject.Model;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleInterestController {
	@RequestMapping(value="/simpleInterest",method=RequestMethod.GET)
	public String getInterest()
	{
		return "simpleInterest";
	}
	@RequestMapping(value="/simpleInterest",method=RequestMethod.POST)
	public String setInterest(@RequestParam int amount,@RequestParam int rate,@RequestParam int time,ModelMap model)
	{
		//Integer amount1=(Integer)request.getAttribute("amount");
		
		//model.addAttribute("amount",amount);
		double SI=(amount*time*rate)/100;
		model.addAttribute("simpleinterest",SI);
		return "simple";
		
		
	}
	

}
