
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class rewriteserv2 extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String newname = request.getParameter("stname");
        String newreg = request.getParameter("sid");
        out.println("<body background='https://wallpaperaccess.com/full/687453.jpg'>");
        out.println("<h1><center>Rewrote Page</center></h1>");
        out.println("<h1>Student Name: "+newname+"</h1>");
        out.println("<h1>Student Register Number: "+newreg+"</h1>");
        out.println("<a href=\"index.html\" style=\"color: black\">Click here to go back to Home page</a>");
        out.println("</body>");
    }

}

