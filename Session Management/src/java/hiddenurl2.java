
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sabarinathan R V
 */
public class hiddenurl2 extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse 
response)
 throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String StudName = request.getParameter("newnames");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<body background='https://img.freepik.com/free-vector/white-gold-hexagon-pattern-background_53876-115292.jpg?w=2000'>");
        out.println("<h1><br><br><center>"+StudName+"</center></h1>");
        out.println("<a href=\"index.html\" style=\"color: black\">Click here to go back to Home page</a>");
        out.println("</body>");
 } 
}
