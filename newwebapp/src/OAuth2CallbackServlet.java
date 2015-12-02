

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class AdminController
 */
@WebServlet(urlPatterns={"/OAuth2CallbackServlet"}, asyncSupported=true)
public class OAuth2CallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String admin="sidharth14163@iiitd.ac.in";
		AsyncContext ctx = request.startAsync(); 
	      ctx.start(new GetUserInfo(request, response,ctx)); 
	    HttpSession session = request.getSession();
	    String email = (String) (session.getAttribute("email"));
	   System.out.println(email);
	   if(email!=null && email.equals(admin))
	   {
		   RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
	       rd.include(request, response);
	   }
	   else
	   {
		   BufferedReader file = null;
		   String line,rno = null;
		   boolean flag=false;
		   try {
				file = new BufferedReader(new FileReader("C:/Users/Sidharth/workspace/newwebapp/src/users.txt"));
				while ((line = file.readLine()) != null)
				{
					String eps[] = line.split("#");
					if(email!=null && email.equals(eps[0]))
					{
						flag = true;
						rno = eps[1];
					}
				}
				file.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		   if(flag==false)
		   {
			   RequestDispatcher rd = request.getRequestDispatcher("/hello.jsp");
		       rd.include(request, response);
		   }
		   else
		   {
			   try
		        {  
		            Runtime.getRuntime().exec("notepad "+"./src/"+rno+".txt");  
		        } 
		        catch (Exception e)
		        {  
		        	e.printStackTrace();
		        }  
		   }
		   
	   }
	   /*
	    * 
	    * email === admin
	    * filters 
	    */
	}

	
	

}