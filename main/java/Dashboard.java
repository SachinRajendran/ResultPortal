import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw =res.getWriter();
			RequestDispatcher rds = req.getRequestDispatcher("General.html");
			rds.include(req, res);
		HttpSession hs =req.getSession(false);
		if(hs!=null) {
		String name = (String) hs.getAttribute("name");
		pw.println("Welcome "+name+" This is Dashboard");
	}
		else {
			pw.print("OOPS!! you need to login first");
			
		}
	}
}

