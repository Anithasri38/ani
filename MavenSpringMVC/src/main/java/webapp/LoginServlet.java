package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
  
	private UserValidationService service=new UserValidationService();
	/*@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Yahoo!!!!!!!!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("My First Program");
		out.println("</body>");
		out.println("</html>");*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        /* PrintWriter writer=response.getWriter();
          writer.println("<html>");
          writer.println("<head>");
          writer.println("<title>Wishes</title>");
          writer.println("</head>");
          writer.println("<body>");
          writer.println("Good Morning<br>");
          writer.println("Good Afternoon<br>");
          writer.println("Good Evening");
          writer.println("</body>");
          writer.println("</html>");*/
		//String name=request.getParameter("name");
		//request.setAttribute("name","Anisri");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
		//request.getParameter("name");
		//String name=request.getParameter("name");
		//request.setAttribute("name", name);
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		boolean isuser=service.isUserValid(name, password);
		if(isuser)
		{
		  request.setAttribute("name",request.getParameter("name"));
		  request.setAttribute("password",request.getParameter("password"));
		  request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
		}
	}

}