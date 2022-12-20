<%-- 
    Document   : driver1
    Created on : Sep 11, 2022, 5:12:30 PM
    Author     : Sabarinathan R V
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Home Page</title>
        <style>
            html,body{
              height: 100%;
              margin: 0;
            }

            .bg {
              background-image: url("https://img.freepik.com/premium-vector/students-with-driving-license-training-car_165429-816.jpg?w=1060");
              height: 100%; 
              background-position: center;
              background-repeat: no-repeat;
              background-size: cover;
            }
            .input{
                margin: 20px;
            }
        </style>
    </head>
    <body>
        <%
            out.println("<style>");
            out.println("body,html{ height: 100%; marigin: 0px;}");
            out.println(".bg{background-repeat: no-repeat;");
            out.println("backgound-size: cover; height: 100%; background-position: center; ");
            out.println("background-image: url('https://www.hdfcergo.com/images/default-source/car-insurance/safe-driving-tips-for-damaged-roads.jpg')");
            out.println("}</style>");
            out.println("<body>");
            out.println("<div class='bg'>");
            String name = request.getParameter("dname");
            String age = request.getParameter("dage");
            String d_time = name+"_datetime";
            //String l_num = request.getParameter("lnum");
            
            int d_age = Integer.parseInt(age);
            
            if (d_age < 18) 
            { 
                out.println("<center>");
                out.println("<h2>Sorry, You are not eligible to drive :( </h2>");
                out.println("<a href = 'index.html'>Click Here to go back to Login Page</a>");
                out.println("</center>");
            }
            else
            {
                out.println("<center>");
                //Integer attribute = (Integer)session.getAttribute(l_num);
                session.setMaxInactiveInterval(3600);
                Integer attribute = (Integer)session.getAttribute(name);
                if(attribute == null)
                {
                    attribute = new Integer(1);
                    
                }
                if(attribute == 1)
                {
                    out.println("<br>");
                    out.println("<h2>You have 2 more chances left :(</h2>");
                    attribute=new Integer(attribute.intValue()+1);
                    
                }
                else if (attribute == 2)
                {
                    out.println("<br>");
                    out.println("<h2>You have only 1 chance left :(</h2>");
                    attribute=new Integer(attribute.intValue()+1);
                    
                }
                else if (attribute == 3)
                {
                    out.println("<br>");
                    out.println("<h2>Your Driving license has been cancelled :(</h2>");
                    out.println("<h2>Cancelled at: </h2>");
                    LocalDateTime datetime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    session.setAttribute(d_time,datetime.format(formatter));
                    out.println("<h2>"+datetime.format(formatter)+"</h2>");
                    attribute=new Integer(attribute.intValue()+1);
                }
                else
                {
                    
                    String cancelled_time = (String) session.getAttribute(d_time);
                    out.println("<br>");
                    out.println("<h2>Your Driving license has been cancelled :(</h2>");
                    out.println("<h2>Cancelled on: "+cancelled_time+"</h2>");
                    attribute=new Integer(attribute.intValue()+1);
                    
                }
                out.println("</center>");
                session.setAttribute(name,attribute);
            }
            out.println("</div>");
            out.println("</body>");
        %>
    </body>
</html>