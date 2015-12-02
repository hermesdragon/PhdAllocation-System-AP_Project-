

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class client
 */

public class client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public client() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession(false);
		s.invalidate();
		String s1= request.getParameter("name");
		String s2= request.getParameter("email");
		String s3= request.getParameter("id");
		String s4= request.getParameter("categ");
		String s5= request.getParameter("gender");
		String s6= request.getParameter("phys");
		String s7= request.getParameter("dob");
		String s8= request.getParameter("phdstream");
		String s9= request.getParameter("graddeg");
		String s10= request.getParameter("pgdeg");
		String s11= request.getParameter("xboard");
		String s12= request.getParameter("xiiboard");
		String s13= request.getParameter("graddepart");
		String s14= request.getParameter("pgdepart");
		String s15= request.getParameter("graduniv");
		String s16= request.getParameter("pgclg");
		String s17= request.getParameter("gradstate");
		String s18= request.getParameter("pgstate");
		String s19= request.getParameter("xmarks");
		String s20= request.getParameter("xiimarks");
		
		
		String s21= request.getParameter("graddcore");
		String s22= request.getParameter("cm1");
		
		String s23= request.getParameter("gatescore");
		
		if(s21.equals("cgpa"))
			s21 = Integer.parseInt(request.getParameter("gradcgpa")+"")*(9.5) + "";
		else
			s21 = request.getParameter("gradmarks");
		
		if(s22!=null && s22.equals("Cgpa"))
			s22 = Integer.parseInt(request.getParameter("Cgpa1")+"")*(9.5) + "";
		else
			s22 = request.getParameter("Marks1");
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calobj = Calendar.getInstance();
		String s24= df.format(calobj.getTime()) + "";
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);
		System.out.println(s7);
		System.out.println(s8);
		System.out.println(s9);
		System.out.println(s10);
		System.out.println(s11);
		System.out.println(s12);
		System.out.println(s13);
		System.out.println(s14);
		System.out.println(s15);
		System.out.println(s16);
		System.out.println(s17);
		System.out.println(s18);
		System.out.println(s19);
		System.out.println(s20);
		System.out.println(s21);
		System.out.println(s22);
		System.out.println(s23);
		
		
		String s25= request.getParameter("file1");
		String s26= request.getParameter("file2");
		System.out.println(s24);
		System.out.println(s25);
		
		String out1 = s1 + "#" + s2 + "#" + s3 + "#" + s4 + "#" + s5 + "#" + s6 + "#" + s7 + "#" + s8 + "#" + s9 + "#" + s19 + "#" + s11 + "#" + s12 + "#" + s13 + "#" + s14 + "#" + s15 + "#" + s16 + "#" + s17 + "#" + s18 + "#" + s19 + "#" + s20 + "#" + s21 + "#" + s22 + "#" + s23 + "#" + s24;
		
		BufferedWriter file2 = null;
		try{
			 file2 = new BufferedWriter(new FileWriter("C:\\Users\\Sidharth\\workspace\\newwebapp\\src\\input.txt",true));
			file2.append(out1+"\n");
			file2.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		BufferedWriter file3 = null;
		try{
			 file3 = new BufferedWriter(new FileWriter("C:\\Users\\Sidharth\\workspace\\newwebapp\\src\\users.txt",true));
			file3.append(s2+"#"+s3+"\n");
			file3.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		/*String s26= request.getParameter("Department");
		String s27= request.getParameter("Degree");
		String s28= request.getParameter("XIIthYear");
		String s29= request.getParameter("XIIBoard");
		String s30= request.getParameter("XthYear");
		String s31= request.getParameter("XIIthMarks");
		String s32= request.getParameter("XthMarks");*/
		//String s33= request.getParameter("XIIthYear");
		try{
		BufferedWriter bw  = new BufferedWriter(new FileWriter("C:\\Users\\Sidharth\\workspace\\newwebapp\\src\\"+s3+".txt"));
		bw.write("Name :" + s1);
		bw.newLine();
		
		bw.write("Enrollment No :" + s3);
		bw.newLine();
		
		bw.write("Email ID :" + s2);
		bw.newLine();
		
		bw.write("Date of Birth :" + s7);
		bw.newLine();
		
		bw.write("Category :" + s4);
		bw.newLine();
		
		bw.write("Gender :" + s5);
		bw.newLine();
		
		bw.write("Physically Disabled :" + s6);
		bw.newLine();
		
		bw.write("Phd stream :" + s8);
		bw.newLine();
		
		bw.write("Class X Board :" + s11);
		bw.newLine();
		bw.write("Class X Percent :" + s19);
		bw.newLine();
		bw.write("Class XII Board :" + s12);
		bw.newLine();
		bw.write("Class XII Percent :" + s20);
		bw.newLine();
		
		
		
		bw.write("Graduation Degree :" + s9);
		bw.newLine();
		bw.write("Graduation Dept :" + s13);
		bw.newLine();
		bw.write("Graduation State :" + s17);
		bw.newLine();
		bw.write("Graduation Percentage :" + s21);
		bw.newLine();
		bw.write("Graduation University :" + s15);
		bw.newLine();
		
		bw.write("Post Graduation Degree :" + s10);
		bw.newLine();
		bw.write("Post Graduation Dept :" + s14);
		bw.newLine();
		bw.write("Post Graduation State :" + s18);
		bw.newLine();
		bw.write("Post Graduation Percentage :" + s22);
		bw.newLine();
		bw.write("Post Graduation University :" + s16);
		bw.newLine();
		
		bw.write("Form Filled On :" + s24);
		bw.newLine();
		
		
		
		bw.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
		
		
		String e1= request.getParameter("file1");
		String e2= request.getParameter("file2");
		
		
		
		    
		    	
		String g1 = null,g2=null;
		 StringTokenizer finalstring = new StringTokenizer(e1,"\\.");  
	     while (finalstring.hasMoreTokens()) {  
	         
	        	 g1=finalstring.nextToken();
	         
	     }
	     
	     StringTokenizer finalstring1 = new StringTokenizer(e2,"\\.");  
	     while (finalstring1.hasMoreTokens()) {  
	         
	         
	      	 g2=finalstring1.nextToken();
	         
	     }
	     
	     String address="C:/Users/Sidharth/workspace/newnew/src/"+"PHD2015"+""+s3+""+"Cv"+"."+g1;
	     String address1="C:/Users/Sidharth/workspace/newnew/src/"+"PHD2015"+""+s3+""+"Statement"+"."+g2;   	
	     FileChannel source=new FileInputStream(new File(e1)).getChannel();
	     FileChannel desti=new FileOutputStream(new File(address)).getChannel();
	     desti.transferFrom(source, 0, source.size());
	     source.close(); desti.close();
		 
	     FileChannel source1=new FileInputStream(new File(e2)).getChannel();
	     FileChannel desti1=new FileOutputStream(new File(address1)).getChannel();
	     desti1.transferFrom(source1, 0, source1.size());
	     source1.close(); desti1.close();
	}

}
