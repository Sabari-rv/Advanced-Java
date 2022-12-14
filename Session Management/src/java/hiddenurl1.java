
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class hiddenurl1 extends HttpServlet 
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String newname=request.getParameter("name");
        //String register=request.getParameter("regno");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<body background='https://wallpaperaccess.com/full/46504.png'>");
        out.println("<center>"); 
        out.println("<h1>---Click below---</h1>");
        out.println("<form action='hiddenurl2' method='post'>"); 
        out.println("<input type='hidden' name='newnames' value='"+"Welcome "+newname+"'>"); 
        out.println("<input type='submit' value='check out'>");
        out.println("</form></center>");
        out.println("</body>");
    } 
}



