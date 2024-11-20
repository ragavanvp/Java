import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DataInsert extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
		{
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			try{
							
			String name = req.getParameter("name");
			String age = req.getParameter("age");
			String pass = req.getParameter("psw");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("localhost:3306/Database");
			ps = con.prepareStatement("INSERT INTO data (name,password) values(?,?)");
			ps.setString(1,nm);
			ps.setString(2,pass);
			int i = ps.executeUpdate();
			pw.println("<h1><center>Welcome</center></h1>");
			pw.println(i);
			if(i!=0)
			{
				pw.println("Your Data has been successfully stored in database");
				pw.println("Hello <b>"+nm+"</b><br>");
				pw.println("Your password is "+pass);
			}
			else
			{
				pw.println("sorry failed to store ! try again......");
			}
			
			}
			catch(Exception e)
			{
				pw.println(e.getMessage());
			}
		}
}
