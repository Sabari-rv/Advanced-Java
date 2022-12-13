package student_sql;

import java.sql.*; //Importing SQL library.
public class Student_SQL 
{
    public static void main(String[] args) 
    {
        String UserName = "xyz";
        String PassWord = "abc";
        String URL = "jdbc:mysql://localhost:3306/java";
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver"); //registering Drivers for the pgm.
            Connection conn;
            conn = DriverManager.getConnection(URL,UserName,PassWord);
            Statement stmt = conn.createStatement();
            
            //Creating a new Table named Student
            String sql = "CREATE TABLE Student "
                    + "(RegNo varchar(20), Name char(20),"
                    + "Age int, Course varchar(30), Mark real)";
            stmt.executeUpdate(sql);
            System.out.println("Table created Successfully!");
            
            String sql1 = "INSERT INTO Student "
                    + "(RegNo,Name,Age,Course,Mark) VALUES(?,?,?,?,?)";
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            
            //First record.
            stmt1.setString(1,"19MID0057");
            stmt1.setString(2, "Sabari");
            stmt1.setInt(3, 21);
            stmt1.setString(4,"Advanced Java");
            stmt1.setFloat(5, 90.87f);
            stmt1.executeUpdate();
            
            //second record.
            stmt1.setString(1,"19MID0001");
            stmt1.setString(2, "Sridhar");
            stmt1.setInt(3, 21);
            stmt1.setString(4,"Internet of Everything");
            stmt1.setFloat(5, 92.83f);
            stmt1.executeUpdate();
            
            //Third record.
            stmt1.setString(1,"19MID0002");
            stmt1.setString(2, "Kowshik");
            stmt1.setInt(3, 20);
            stmt1.setString(4,"Advanced Data compression");
            stmt1.setFloat(5, 82.83f);
            stmt1.executeUpdate();
            
            //Fourth record.
            stmt1.setString(1,"19MIS0001");
            stmt1.setString(2, "Hrithik");
            stmt1.setInt(3, 20);
            stmt1.setString(4,"Advanced Java");
            stmt1.setFloat(5, 95.0f);
            stmt1.executeUpdate();
            
            //Fifth record.
            stmt1.setString(1,"19MIC0001");
            stmt1.setString(2, "Nishanth");
            stmt1.setInt(3, 21);
            stmt1.setString(4,"Theory of Computation");
            stmt1.setFloat(5, 90.0f);
            stmt1.executeUpdate();
            
            //Sixth record.
            stmt1.setString(1,"19BCE0001");
            stmt1.setString(2, "Sheema");
            stmt1.setInt(3, 20);
            stmt1.setString(4,"Cloud Computing");
            stmt1.setFloat(5, 92.83f);
            stmt1.executeUpdate();
            
            //Seventh record.
            stmt1.setString(1,"19BCT0001");
            stmt1.setString(2, "Motish");
            stmt1.setInt(3, 21);
            stmt1.setString(4,"Advanced Java");
            stmt1.setFloat(5, 92.83f);
            
            
            int rowsinserted = stmt1.executeUpdate();
            System.out.println();
            if(rowsinserted >0){
                System.out.println("New rows inserted successfully!");
            }
            //System.out.println("No.of.Rows Inserted: " + rowsinserted);
            System.out.println("Created Table: ");
            System.out.println();
            Statement sstmt = conn.createStatement();
            ResultSet sres = sstmt.executeQuery("SELECT * FROM Student");
            while (sres.next())   {
                    System.out.println(sres.getString(1) + "  " + 
                            sres.getString(2)+ "  " + 
                            sres.getInt(3)+ "  " + 
                            sres.getString(4)+ "  " + 
                            sres.getFloat(5));
                    }
            System.out.println();
            System.out.println();
            System.out.println("Students who have taken 'Advanced Java': ");
            Statement jstmt = conn.createStatement();
            String querynew = "SELECT * FROM Student WHERE Course = 'Advanced Java'";
            Statement prpstmt = conn.prepareStatement(querynew);
            ResultSet jres = jstmt.executeQuery("SELECT * FROM Student WHERE Course = 'Advanced Java'");
            while (jres.next())   {
                    System.out.println(jres.getString(1) + "  " + 
                            jres.getString(2)+ "  " + 
                            jres.getInt(3)+ "  " + 
                            jres.getString(4)+ "  " + 
                            jres.getFloat(5));
                    }
            conn.close();
            stmt.close();
            stmt1.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
}
