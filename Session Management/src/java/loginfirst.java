import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;


public class loginfirst extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        //int x = 1;
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String regno = request.getParameter("regno");
        Integer attribute = (Integer)session.getAttribute(regno);
        
        if (attribute == null)
        {
            attribute=new Integer(1);
            out.println("<h1><center>Welcome "+name+"</center></h1>");
            out.println("<h2><center>Hope you like our Website :)</h2>");
        } 
        else 
        {
            out.println("<h1><center>Welcome back, "+name+"</center></h1>");
            attribute=new Integer(attribute.intValue()+1);
        }
        session.setAttribute(regno,attribute);
        session.setMaxInactiveInterval(60);
        out.println("<body background='https://www.imarc.com/writable/images/thought-hero-images/pexels-photo-238118_copy1.jpeg'>");
        //out.println("<h2> Your Session id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+session.getId()+"</h2>");
        out.println("<h2>Student Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+name+"</h2>");
        out.println("<h2>Register Number: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+regno+"</h2>");
        out.println("<h2>Your Last accessed time:  "+new Date(session.getLastAccessedTime())+"</h2>");
        out.println("<h2>Your Number of visits:&nbsp;&nbsp;"+attribute+"</h2>");
        out.println("<a href=\"index.html\" style=\"color: white\">Click here to go back to Home page</a>");
        out.println("</body>");
   
    }

}
