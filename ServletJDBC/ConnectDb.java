import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnectDb extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("localhost:3306/Database");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT* FROM servlet");
			pw.println("Id \t \t Name \t \t Place<br>");
			while (rs.next()) {
				pw.println("\t \t \t \t \t");
				pw.println(rs.getObject(1).toString());
				pw.println(rs.getObject(2).toString());
				pw.println(rs.getObject(3).toString());
				pw.println("<br>");
			}
		} catch (SQLException e) {
			pw.println(e.getNextException());
		} catch (ClassNotFoundException e) {
			pw.println(e.getException());
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (Exception e) {
				pw.close();
			}
		}
	}
}
