

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Table
 */
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Manager Viewing</title>");
		writer.println("</head>");
		writer.println("<body>");
	//	writer.println(" a.button { -webkit-appearance: button; -moz-appearance: button;  appearance: button; 	text-decoration: none; color: initial; ");
		
		writer.println("<a href='http://localhost:8080/WebProject/Result' class='button'>Go Back</a> " );
		
		
		writer.println("<table border='1'>");
		writer.println("<tr>");
		writer.println("<td>ID</td>");
		writer.println("<td>Name</td>");
		
		writer.println("<td>Details</td>");
		writer.println("</tr>");
	
		int length = Result.sol.size();
		for(Details i : Result.sol)
		{
			writer.println("<tr>");
			writer.println("<td>" + i.enroll +"</td>");
			writer.println("<td>" + i.name +"</td>");
			String path =  "file:///C:\\Users\\Sidharth\\workspace\\newwebapp\\src\\" + i.enroll + ".txt";
		
			System.out.println(	path);
		
			writer.println("<td><form action=" + path + " >" 
				+ "<input type='submit'  value='More Info'> </form> </td>");
			writer.println("</tr>");
	
		}
		
		writer.println("</body>");
		writer.println("</html>");
		Result.sol.clear();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
	}

}
