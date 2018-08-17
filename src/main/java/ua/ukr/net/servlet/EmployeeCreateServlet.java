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
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/employee/create")
public class EmployeeCreateServlet extends HttpServlet {
    //private Employee employeeDao;
    private JdbcEmployeeDao employeeDao = new JdbcEmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/employee_create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        Employee employee = new Employee();
        employee.setName(req.getParameter("name"));
        employee.setEmail(req.getParameter("email"));
        LocalDate birthday = LocalDate.parse(req.getParameter("date"));
        employee.setBirthday(java.sql.Date.valueOf(birthday));

        employeeDao.create(employee);

        //just for ferrying
        employee = employeeDao.findByEmail(employee.getEmail());
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/jsp/employee_result.jsp").forward(req, resp);


    }
}
