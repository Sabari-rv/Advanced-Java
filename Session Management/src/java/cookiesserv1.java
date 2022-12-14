import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class cookiesserv1 extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        String s1 = request.getParameter("regno");
        String s2 = request.getParameter("name");
        
        Cookie cookie = new Cookie("registernum",s1);
        Cookie cookie1 = new Cookie("studentname",s2);
        response.addCookie(cookie);
        response.addCookie(cookie1);
        cookie.setMaxAge(180);  //for 3 minutes
        cookie1.setMaxAge(180); //for 3 minutes
        
        response.sendRedirect("cookiesserv2");
    }

}




