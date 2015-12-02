import java.io.ByteArrayInputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

class GetUserInfo implements Runnable { 
	   private HttpServletRequest req; 
	   private HttpServletResponse resp; 
	   private AsyncContext asyncCtx; 
	   public GetUserInfo(HttpServletRequest req, HttpServletResponse resp, AsyncContext asyncCtx) { 
	      this.req = req; 
	      this.resp = resp; 
	      this.asyncCtx = asyncCtx; 
	   }
	   @Override 
	   public void run() {  
	      HttpSession sess = req.getSession(true); 
	      sess.setMaxInactiveInterval(3600);
	      OAuthService service = (OAuthService)sess.getAttribute("oauth2Service");	    
	      String code = req.getParameter("code");
	      Token token = service.getAccessToken(null, new Verifier(code)); 
	      sess.setAttribute("token", token);
	      try { 
	         req.login("fred", "fredfred"); 
	      } catch (ServletException e) { 
	         //Handle error - should not happen 
	      }
	      //Now do something with it - get the user's G+ profile 
	      OAuthRequest oReq = new OAuthRequest(Verb.GET, 
	            "https://www.googleapis.com/oauth2/v2/userinfo"); 
	      service.signRequest(token, oReq); 
	      Response oResp = oReq.send(); 

	      //Read the result 
	      
	      JsonReader reader = Json.createReader(new ByteArrayInputStream( 
	            oResp.getBody().getBytes()));
	      //System.out.println(oResp.getBody());
	     JsonObject profile = reader.readObject(); 
	      //Save the user details somewhere or associate it with 
	      sess.setAttribute("email", profile.getString("email")); 
	      //System.out.println(profile.getString("email"));
	      asyncCtx.complete(); 
	      
	      
	   } 
}