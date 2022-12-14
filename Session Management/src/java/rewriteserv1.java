import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class rewriteserv1 extends HttpServlet 
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String s1 = request.getParameter("regno");
        String s2 = request.getParameter("name");
        String existpath = request.getContextPath();
        String newurl = existpath+"/unames="+s2+"/ids="+s1+"/";
        //String addURL = response.encodeURL(existpath + "/Welcome");

        response.sendRedirect("rewriteserv2?stname="+s2+"&sid="+s1);
    }

}
