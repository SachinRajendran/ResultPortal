import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

class Loginverify {
	public static boolean isvaliddata(String email, String Password ,HttpSession hs) {
		
		boolean check=false;
		
		
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root16");
			String str = "SELECT Studentname,Sem,mark1,mark2,mark3,mark4,Status FROM studentdetails WHERE email=? and Password=?;";
			
		PreparedStatement ps;
		ps =cn.prepareStatement(str);
		ps.setString(1,email);
		ps.setString(2,Password);		
		ps.executeQuery();
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			check=true;
			String name = rs.getString(1);
			int a =rs.getInt(2);
			int b =rs.getInt(3);
			int c =rs.getInt(4);
			int d =rs.getInt(5);
			int e =rs.getInt(6);
			String Status = rs.getString(7);
		
		hs.setAttribute("name", name);
		hs.setAttribute("a", a);
		hs.setAttribute("b", b);
		hs.setAttribute("c", c);
		hs.setAttribute("d", d);
		hs.setAttribute("e", e);
		hs.setAttribute("Status", Status);
		
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return check;
	}


//	public static boolean isvaliddata1(String uid, String pass) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	
}