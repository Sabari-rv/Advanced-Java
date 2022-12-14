import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
public class cookiesserv2 extends HttpServlet 
{
    private int k = -1;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        k++;
        PrintWriter out = response.getWriter();
        Cookie cookies[] = request.getCookies();
        response.setContentType("text/html");
        if( cookies != null ) 
        {
            out.println("<body background='https://blog.getcomplied.com/wp-content/uploads/2018/07/cookies-post-24-1360x765.png'>");
            out.println("<h1 style= 'color:white;'><center> Found Cookies Name and Value</center></h1>");
            out.print("<h2>Register number : " +cookies[0].getValue() + "</h2>");
            out.print("<h2>Student Name : " + cookies[1].getValue() + "</h2>");
            out.print("<h2>Number of Entires: " + (k+1)+ "</h2>");
            
            
        }
        else 
        {
            out.println("<h2>No cookies founds</h2>");
        }
        out.println("<a href=\"index.html\" style=\"color: white\">Click here to go back to Home page</a>");
        out.println("</body>");
    }

}

