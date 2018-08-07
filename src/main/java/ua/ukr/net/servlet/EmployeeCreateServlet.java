package ua.ukr.net.servlet;

import ua.ukr.net.dao.JdbcEmployeeDao;
import ua.ukr.net.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/employee/create")
public class EmployeeCreateServlet extends HttpServlet {
    //private Employee employeeDao;
    JdbcEmployeeDao employeeDao = new JdbcEmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/employee_create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        Employee employee = new Employee();
        employee.setName(req.getParameter("name"));
        employee.setEmail(req.getParameter("email"));
        try {
            Date birthday = new SimpleDateFormat("YYYY-MM-DD").parse(req.getParameter("date"));
            employee.setBirthday(new java.sql.Date(birthday.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employeeDao.create(employee);

        //just for ferifying
        employee = employeeDao.findByEmail(employee.getEmail());
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/jsp/employee_result.jsp").forward(req, resp);


    }
}
