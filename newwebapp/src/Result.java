

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class Result
 */

public class Result extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	public static boolean flag = true;

	public static ArrayList<Details> all = new ArrayList<Details>();
	public static ArrayList<Details> inter = new ArrayList<Details>();
	public static ArrayList<Details> sol = new ArrayList<Details>();
	
	//TAB 1
		private static final int NAME = 0;
		private static final int EMAIL = 1;
		private static final int Enrollment = 2;
		private static final int CAT = 3;
		private static final int GENDER = 4;
		private static final int PHYSICAL = 5;
		private static final int DOB = 6;
		///////TAB 2
		private static final int STREAM = 7;
		private static final int G_DEG = 8;
		private static final int PG_DEG = 9;
		
		private static final int X_BOARD = 10;
		private static final int XII_BOARD = 11;
		
		private static final int G_DEPT = 12;
		private static final int PG_DEPT = 13;
		private static final int G_UNI = 14;
		private static final int PG_UNI = 15;
		
		private static final int G_STATE = 16;
		private static final int PG_STATE = 17;
		
		private static final int X_PERCENT = 18;
		private static final int XII_PERCENT = 19;
		private static final int  G_PERCENT= 20;
		private static final int PG_PERCENT = 21;
		private static final int GATE_SCORE = 22;
		private static final int FORM_DATE = 23;
		public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }
   
   public void init()
   {
	   try
		{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sidharth\\workspace\\newwebapp\\src\\input.txt"));
		String thisLine;
		while((thisLine = br.readLine())!=null)
		{
			String vars[] = thisLine.split("#");
			Details obj = new Details(vars[NAME],vars[EMAIL],vars[Enrollment],vars[CAT],vars[GENDER],vars[PHYSICAL],vars[DOB]
					,vars[STREAM],vars[G_DEG],vars[PG_DEG],vars[X_BOARD],vars[XII_BOARD],vars[G_DEPT],vars[PG_DEPT],vars[G_UNI]
					,vars[PG_UNI],vars[G_STATE],vars[PG_STATE],vars[X_PERCENT],vars[XII_PERCENT],vars[G_PERCENT],vars[PG_PERCENT]
					,vars[GATE_SCORE],vars[FORM_DATE]);
			
				all.add(obj);
		}
		br.close();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}	
    	
    }
	

	private String C(String a, String b)
	{
		if(a==null || a.equals("All") || b==null || b.equals("") || b.equals("null"))
			return b;
		else
			return a; 
	}
	private String S(String a, String b)
	{
		//System.out.println(a);
		
		if(a==null || a.equals("") || b==null || b.equals("") || b.equals("null"))
			return b;
		else
			return a.trim();
	}
	
	
	private Boolean Q(Boolean a, Boolean b,Boolean c,String d,String e)
	{
		if(!(a||b||c) || a&&b&&c || d.equals(null)) 
		{
			return true;
		}
		else if(d.equals("null"))
			return false;
		
		else
		{

			if(!d.equals(""))
			{
				Double given = Double.parseDouble(d);
			
			Double req = Double.parseDouble(e);
			
			System.out.println(a+" "+b+" "+c +" "+given +" " +req);
			
			if(a && b)
			{
				if(given.compareTo(req) < 0)
					return false;
				else
					return true;
			}
			
			if(b && c)
			{	
				if(given.compareTo(req) > 0)
					return false;
				else
					return true;
			}
			
			if(a)
			{
				if(given.compareTo(req) <= 0)
					return false;
				else
					return true;
			}
			if(b)
			{
				if(given.compareTo(req) != 0)
					return false;
				else
					return true;
			}
			if(c)
			{
				if(given.compareTo(req) >= 0)
					return false;
				else
					return true;
			}
			if(a && c)
			{	
				if(given.compareTo(req) == 0)
					return false;
				else
					return true;
			}
			
			return true;
			}
			else
				return true;
		}
		
   }
	private Boolean R(String a,String b,String c,String d,String e)
	{
		return Q(a.equals("Y"),b.equals("Y"),c.equals("Y"),d, e);
	}
	
	
	private void tab2(Details main,String start_date,String end_date)
	{
		for(Details i : inter)
		{
			if(( C(main.stream ,i.stream).equals(i.stream) &&   C(main.grad_degree,i.grad_degree).equals(i.grad_degree) && C(main.post_grad_degree,i.post_grad_degree).equals(i.post_grad_degree)
					&& C(main.x_board,i.x_board).equals(i.x_board) && C(main.xii_board,i.xii_board).equals(i.xii_board)&& C(main.grad_dept,i.grad_dept).equals(i.grad_dept)
					&& C(main.post_grad_dept,i.post_grad_dept).equals(i.post_grad_dept) && C(main.grad_state,i.grad_state).equals(i.grad_state) 
					&& C(main.post_grad_state,i.post_grad_state).equals(i.post_grad_state) 
					&& S(main.grad_uni , i.grad_uni).equals(i.grad_uni) && S(main.post_grad_uni , i.post_grad_uni).equals(i.post_grad_uni)) 
					
					&& R(main.form_date.split(";")[4],main.form_date.split(";")[5],main.form_date.split(";")[6],i.x_percent,main.x_percent ) 
					&& R(main.form_date.split(";")[7],main.form_date.split(";")[8],main.form_date.split(";")[9],i.xii_percent,main.xii_percent) 
					&& R(main.form_date.split(";")[10],main.form_date.split(";")[11],main.form_date.split(";")[12],i.grad_percent,main.grad_percent) 
					&& R(main.form_date.split(";")[13],main.form_date.split(";")[14],main.form_date.split(";")[15],i.post_grad_percent,main.post_grad_percent )
					&& R(main.form_date.split(";")[16],main.form_date.split(";")[17],main.form_date.split(";")[18],i.gate_score,main.gate_score )
					
					) 	
				{
					System.out.println("inside" + start_date + " " +end_date);
					
					if(start_date=="")
						start_date=null;
					if(end_date=="")
						end_date=null;
					
					if(start_date!=null || end_date!=null)
					{
						LocalDate actual = LocalDate.parse(i.form_date.toString(),formatter);
						
					
						if(start_date!=null  && end_date!=null)
						{
							
							LocalDate choice_start = LocalDate.parse(start_date.toString(),formatter);
							LocalDate choice_end = LocalDate.parse(end_date.toString(),formatter);
							if( (choice_start.isBefore(actual) && choice_end.isAfter(actual)) 
									|| choice_start.equals(actual) || choice_end.equals(actual))           sol.add(i);
							
						}
						else if(start_date!=null)
						{
							LocalDate choice_start = LocalDate.parse(start_date.toString(),formatter);
							if(choice_start.isBefore(actual) || choice_start.equals(actual))           sol.add(i);
							
						}
						else
						{
							LocalDate choice_end = LocalDate.parse(end_date.toString(),formatter);
							if(choice_end.isAfter(actual) ||choice_end.equals(actual))           sol.add(i);
						
						}
					}
					else
					{
						sol.add(i);
					}
			}
		}
		for(Details i : sol)
		{
			System.out.println("sol has " + i.gender);
			
		}
		
	
	}
	private void tab1(Details main)
	{
		
			
		for (Details i : all)
		{
			System.out.println(main.name + " " + i.name+ S(main.name,i.name).equals(i.name) );
			
			
			
			if(S(main.name,i.name).equals(i.name) && 
					S( main.email , i.email).equals(i.email) 
					&& S( main.enroll , i.enroll).equals(i.enroll) 
				 && C(main.category,i.category).equals(i.category)	&& S(main.gender,i.gender).equals(i.gender) && 
				 S(main.physical,i.physical).equals(i.physical) ) 			
			{
				
				
				String on = main.form_date.split(";")[1];
				String before = main.form_date.split(";")[2];
				String after = main.form_date.split(";")[3];
				
				System.out.println("OBA" + on + before + after );
				
				
				
				if(on.equals("Y") || before.equals("Y") || after.equals("Y"))
				{	
					System.out.println("here");
					
					if ( !(i.dob.toString().equals("")) && !(i.dob.equals("null")))
					{
					LocalDate choice = LocalDate.parse(main.dob.toString(),formatter);
					LocalDate actual = LocalDate.parse(i.dob.toString(),formatter);
					
					
					if(on.equals("Y") && choice.equals(actual))
						{
						inter.add(i);
						
						System.out.println("on");
						}
					else if(before.equals("Y") && actual.isBefore(choice))
						{
						inter.add(i);
						
						System.out.println("before");
						}
					else if(after.equals("Y") && actual.isAfter(choice))
						{
						inter.add(i);
						
						System.out.println("After");
						}
					}
					else
						inter.add(i);
					
				}
				else
				{
					inter.add(i);
				}
			
				
			
			}
		}
	}

    
    
    
	public boolean SanityCheck(HttpServletRequest request, HttpServletResponse response)
	{
		
	return true;	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		
	
		RequestDispatcher rd = request.getRequestDispatcher("admin.html");    
		rd.include(request, response);
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter writer = response.getWriter();
		
		//System.out.println(request.getAttribute("nme") + S(main.name,i.name).equals(i.name));
		
		/*if(SanityCheck(request,response))
		{
			writer.write("Invalid Combination of Filters");
			flag=false;
			doGet(request, response);
			
		}
		*/
		
		System.out.println("print" + request.getParameter("cat") + " " +request.getParameter("sex"));
		
		
		
		
		
		Details main = new Details(request.getParameter("nme"),request.getParameter("Email"),request.getParameter("enroll"),request.getParameter("cat"),request.getParameter("sex"),request.getParameter("physical")
				,request.getParameter("dob"),request.getParameter("stream"),request.getParameter("grad_degree"),request.getParameter("post_grad_degree")
				,request.getParameter("x_board"),request.getParameter("xii_board"),request.getParameter("grad_dept"),request.getParameter("post_grad_dept")
				,request.getParameter("grad_uni"),request.getParameter("post_grad_uni"),request.getParameter("grad_state"),request.getParameter("post_grad_state")
				,request.getParameter("x_percent"),request.getParameter("xii_percent"),request.getParameter("grad_percent"),request.getParameter("post_grad_percent")
				,request.getParameter("gate_score"), " " + ";"+
				
						request.getParameter("toggle_1") +";"+ request.getParameter("toggle_2")  + ";"+ request.getParameter("toggle_2")  +";"+
						request.getParameter("x_greater") + ";"+ request.getParameter("x_equal")  + ";"+  request.getParameter("x_less")  + ";"+
						request.getParameter("xii_greater") + ";"+ request.getParameter("xii_equal")  + ";"+ request.getParameter("xii_less")  + ";"+
						request.getParameter("grad_greater") + ";"+ request.getParameter("grad_equal")  + ";"+ request.getParameter("grad_less")  + ";"+
						request.getParameter("post_grad_greater") +";"+ request.getParameter("post_grad_equal")  + ";"+ request.getParameter("post_grad_less")  + ";"+
						request.getParameter("gate_greater") + ";"+ request.getParameter("gate_equal") + ";"+ request.getParameter("gate_less") 
						);
				
		//System.out.println("legth is "+main.form_date.split(";")[16]);
		inter.clear();
		//all.clear();
		sol.clear();
		
		tab1(main);
		
		for(Details i : inter)
		{
			System.out.println("inter has " + i.name);
			
		}
		
		tab2(main,request.getParameter("start_date"),request.getParameter("end_date"));
		
		inter.clear();
		
		
		System.out.println("Dispatching");
		RequestDispatcher rd = request.getRequestDispatcher("intermediate.html");
		rd.forward(request, response);
		
		

		
		//all.clear();
		//sol.clear();
	
		

	}
}
