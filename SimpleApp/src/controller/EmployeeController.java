package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.DAO.EmployeeDao;
import com.DAOImpl.EmployeeDAOImpl;
import com.pojo.EmployeeDetails;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    EmployeeDetails employee = new EmployeeDetails();
    EmployeeDAOImpl employeeDaoImpl = new EmployeeDAOImpl();
    //EmployeeDao edao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("addEmployee")!=null){
            String ename = request.getParameter("ename");
            String enumber = request.getParameter("enumber");
            employee.setEname(ename);
            employee.setEnumber(enumber);
            employeeDaoImpl.saveEmployee(employee);
            RequestDispatcher rd = request.getRequestDispatcher("EmployeeAdd.jsp");
            rd.forward(request, response);
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("showEmployee")!=null){
            List<EmployeeDetails> employeeList = new ArrayList();
            employeeList = employeeDaoImpl.showAllEmployees();
            request.setAttribute("employeeList", employeeList);
            RequestDispatcher rd = request.getRequestDispatcher("ShowAll.jsp");
            rd.forward(request, response);
        }
         
          if(request.getParameter("updateEmployee")!=null){
             int id1 = Integer.parseInt(request.getParameter("id"));
             String ename = request.getParameter("ename");
             String enumberupdate = request.getParameter("enumberupdate");
             employeeDaoImpl.updateEmployee(id1, ename, enumberupdate);
             
             RequestDispatcher rd = request.getRequestDispatcher("EmployeeAdd.jsp");
             rd.forward(request, response);
             
         }
          
         if(request.getParameter("deleteEmployee")!=null){
             int id2 = Integer.parseInt(request.getParameter("id"));
             employee.setId(id2);
             employeeDaoImpl.deleteEmployee(employee);
              RequestDispatcher rd = request.getRequestDispatcher("EmployeeAdd.jsp");
            rd.forward(request, response);
         }
	}
	@Override
    public String getServletInfo() {
        return "Short description";
    }

}
