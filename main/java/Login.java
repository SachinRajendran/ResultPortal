

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		String email = req.getParameter("email");
		String Password = req.getParameter("Password");
		boolean check = Loginverify.isvaliddata(email,Password,req.getSession());
		PrintWriter pw = res.getWriter();
		RequestDispatcher rds1 = req.getRequestDispatcher("Nextpage1.html");
		rds1.include(req, res);
		
		if(check)
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("email", email);
			pw.print("login Successfully");
//            RequestDispatcher rds = req.getRequestDispatcher("Dashboard");
//            rds.forward(req, res);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("Interface.html");
			rd.forward(req, res);
		}
	}

}
