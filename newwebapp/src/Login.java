import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static final String CLIENT_ID = "847489921998-qacncda548sfv8d6io00kd6mm1mglb4v.apps.googleusercontent.com"; 
	private static final String CLIENT_SECRET = "GexdPXu66CxCK5oijH3uHMU3";
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServiceBuilder builder= new ServiceBuilder(); 
	      OAuthService service = builder.provider(Google2Api.class) 
	         .apiKey(CLIENT_ID) 
	         .apiSecret(CLIENT_SECRET) 
	         .callback("http://localhost:8080/newwebapp/OAuth2CallbackServlet") 
	         .scope("openid profile email " + 
	               "https://www.googleapis.com/auth/plus.login " + 
	               "https://www.googleapis.com/auth/plus.me")  
	         .debug()
	         .build();
	      HttpSession sess = request.getSession(); 
	      sess.setAttribute("oauth2Service", service);
	      PrintWriter out = response.getWriter();
	      out.println(service.getAuthorizationUrl(null));
	      response.sendRedirect(service.getAuthorizationUrl(null)); 
	}
	

}