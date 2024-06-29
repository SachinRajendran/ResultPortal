

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      PrintWriter pw=res.getWriter();
	      RequestDispatcher rd1=req.getRequestDispatcher("again.html");
	      rd1.include(req, res);
		HttpSession hp = req.getSession();
		hp.getAttribute("email");
		hp.invalidate();
	
		pw.print("Log out Successfully");
	}

}
