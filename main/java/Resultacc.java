import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Resultacc")
public class Resultacc extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        Connection cn;
        try {
            
            String email = req.getParameter("email");
            String Password = req.getParameter("Password");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root16");

            String str = "SELECT Studentname,Sem,mark1,mark2,mark3,mark4,Status FROM studentdetails WHERE email=? and Password=?;";
            PreparedStatement ps = cn.prepareStatement(str);
            ps.setString(1, email);
            ps.setString(2, Password);
            HttpSession hs = req.getSession();
            hs.setAttribute("email", email );
        	
 
            // Execute the query and get the result set
            PrintWriter pw = res.getWriter();
//            ResultSet rs = ps.executeQuery();
            
            // Get the PrintWriter object from HttpServletResponse
 
            
            // Process each row in the result set
            RequestDispatcher rds = req.getRequestDispatcher("General.html");
			rds.include(req, res);
            if(hs!=null) {
            	String na = (String) (hs.getAttribute("name"));
                int Sem = (int)(hs.getAttribute("a"));
                int Mark1 = (int)(hs.getAttribute("b"));
                int Mark2 = (int)(hs.getAttribute("c"));
                int Mark3 = (int)(hs.getAttribute("d"));
                int Mark4 = (int)(hs.getAttribute("e"));
                String Status = (String)(hs.getAttribute("Status"));
                
                // Output the result to the PrintWriter
                pw.println("<html><body><center>");
                pw.print("<h1>Here is your result</h1>"+"<br><hr>");
               pw.println("<p><table>name : "+ na+" </p>");
                pw.println("<p>Sem : "+Sem+" </p>" );
                pw.println("<p>Mark1: "+Mark1+" </p>");
                pw.println("<p>Mark2: "+Mark2+" </p>");
                pw.println("<p>Mark3: "+Mark3+" </p>");
                pw.println("<p>Mark4: "+Mark4+" </p>");
                pw.println("<p>Status: "+Status+" </table></p>");
                pw.println("</center></body></html>");
                
                
               // System.out.print(na+" " + Sem + " " + Mark1 + " " + Mark2 + " " + Mark3 + " " + Mark4 + " " + Status);
                
            }
            else {
            	pw.println("You need to login first");
            }
            
            // Close the ResultSet, PreparedStatement, and Connection
            
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

