package webapp.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
	TodoService service;
	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));
	}
    @RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String listtodos(ModelMap model)
	{
    	
    	model.addAttribute("todos",service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}
    @RequestMapping(value="/todo",method=RequestMethod.GET)
	public String showTodoPage(ModelMap model)
	{
    	model.addAttribute("todo",new Todo(0,"in28Minuties","",new Date(),false));
		return "todo";
	}
    @RequestMapping(value="/todo",method=RequestMethod.POST)
	public String addtodo(ModelMap model,@Valid Todo todo,BindingResult result)
	
	{
    	if(result.hasErrors())
    	{	
    		return "todo";
    	}
         	service.addTodo("in28Minutes",todo.getDesc(),new Date(),false);
    	   model.clear();
		   return "redirect:list-todos";
    	
	}
    @RequestMapping(value="/update-todo",method=RequestMethod.GET)
   	public String updatetodo(ModelMap model,@RequestParam int id)
   	
   	{
       	Todo todo=service.retrieveTodo(id);
       	model.clear();
       	model.addAttribute("todo",todo);
   		return "todo";
   	}
    @RequestMapping(value="/update-todo",method=RequestMethod.POST)
   	public String updatetodo(ModelMap model,@Valid Todo todo,BindingResult result)
   	
   	{     if(result.hasErrors())
	       {	
		      return "todo";
	        }
   	
       	service.updateTodo(todo);
   		     return "redirect:list-todos";
   	}
    @RequestMapping(value="/delete-todo",method=RequestMethod.GET)
   	public String deletetodo(ModelMap model,@RequestParam int id)
   	
   	{
       	service.deleteTodo(id);
       	model.clear();
   		return "redirect:list-todos";
   	}
}
