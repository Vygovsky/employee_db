package ua.ukr.net.servlet;

import ua.ukr.net.dao.JdbcEmployeeDao;
import ua.ukr.net.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet("/employee/listEmployee")
public class EmployeeList extends HttpServlet {
    private JdbcEmployeeDao employeeDao=new JdbcEmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employeeList = employeeDao.findAll();
        req.setAttribute("list", employeeList);
        req.getServletContext().getRequestDispatcher("/jsp/employee_list.jsp").forward(req, resp);
    }
}
