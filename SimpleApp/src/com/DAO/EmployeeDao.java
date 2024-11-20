package com.DAO;
import java.util.List;
import com.pojo.EmployeeDetails;

public interface EmployeeDao {
    
    public void saveEmployee (EmployeeDetails employee);
    public List<EmployeeDetails> showAllEmployees();
    public void updateEmployee (int id, String ename, String enumber);
    public void deleteEmployee (EmployeeDetails employee);
    
    
}