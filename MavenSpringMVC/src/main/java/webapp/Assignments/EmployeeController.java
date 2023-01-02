package webapp.Assignments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class EmployeeController {
	@Autowired
   EmployeeService service;
	@RequestMapping(value="/employeeform",method=RequestMethod.GET)
	public String getList()
	{
		return "employeeform";
	}
	@RequestMapping(value="/employeeform",method=RequestMethod.POST)
	public String getEmp(@RequestParam int employeeId,@RequestParam String employeeName,@RequestParam String employeeDepartment,@RequestParam String employeeDesignation,@RequestParam long employeeSalary,ModelMap model)
	{
		model.addAttribute("employee",service.retrieveEmployees());
		service.addEmployee(employeeId, employeeName, employeeDepartment, employeeDesignation, employeeSalary);
		return "employeeDeatils";
	}
}
